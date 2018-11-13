package com.tefg.service.Imp;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.tefg.Utril.DoubleUtril;
import com.tefg.Utril.PropertiesUtil;
import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.dao.CartMapper;
import com.tefg.dao.ProductMapper;
import com.tefg.pojo.Cart;
import com.tefg.pojo.Product;
import com.tefg.service.IcartService;
import com.tefg.vo.cartProduct;
import com.tefg.vo.cartVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-12 14:12
 */
@Service("icartService")
public class CartServiceImp implements IcartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;


    /**
     * 查询
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<cartVO> list(Integer userId){

        cartVO cartVO = this.getcartVoLimit(userId);
        return ServerResponse.createBySuccess(cartVO);
    }

    /**
     * 添加到购物车
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    @Override
    public ServerResponse<cartVO> add(Integer userId, Integer productId, Integer count) {


        if (productId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Cart cart = cartMapper.selectCartByUserIdWithProductId(userId, productId);
        if (cart == null) {
            //如果这个商品不在这个购物车里，需要新增一个这个产品的记录
            Cart cart1 = new Cart();
            cart1.setQuantity(count);
            cart1.setChecked(Const.Cart.CHECKED);
            cart1.setProductId(productId);
            cart1.setUserId(userId);
            cartMapper.insert(cart1);
        } else {
            //这个产品已经在这个购物车里了
            //产品存在则数量相加
            count=cart.getQuantity()+count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);

    }

    /**
     * 更新购物车
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    @Override
    public ServerResponse<cartVO> update(Integer userId, Integer productId, Integer count){
        if (productId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdWithProductId(userId, productId);
        //如果 cart对象不为空 ，那就增加他的数量
        if (cart != null) {
            cart.setQuantity(count);
        }
        cartMapper.updateByPrimaryKeySelective(cart);

        return this.list(userId);

    }

    /**
     * 删除商品
     *
     * @param userId
     * @param productIds
     * @return
     */
    @Override
    public ServerResponse<cartVO> delectProduct(Integer userId, String productIds) {
        //将string 用，分割 变成list集合
        List<String> productList = Splitter.on(",").splitToList(productIds);

        if (CollectionUtils.isEmpty(productList)) {
            return  ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        cartMapper.deleteByUserIdProductIds(userId, productList);

        return this.list(userId);


    }


    /**
     * 获取 购物车商品总数
     * @param userId
     * @return
     */
    @Override
       public ServerResponse<Integer> getCartProductCount(Integer userId){

           if (userId == null) {
               return  ServerResponse.createBySuccess(0);
           }

           return ServerResponse.createBySuccess(cartMapper.selectCartProuctCount(userId));
       }



    /**
     * 全选 或者 不选
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<cartVO> selectOrUnSelect(Integer userId, Integer productId,Integer cheked){
        cartMapper.checkedOrUncheckedAProduct(userId,productId, cheked);

        return this.list(userId);
    }



    private cartVO getcartVoLimit(Integer userId){
        cartVO cartVO=new cartVO();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<cartProduct> cartProducts= Lists.newArrayList();
        Double cartTotalPrice = new Double("0");

        if (CollectionUtils.isNotEmpty(cartList)) {
            for (Cart cart : cartList) {
                cartProduct product=new cartProduct();

                product.setId(cart.getId());
                product.setUserId(cart.getUserId());
                product.setProductId(cart.getProductId());

                Product product1 = productMapper.selectByPrimaryKey(cart.getProductId());

                if (product1 != null) {
                    product.setProductMainImage(product1.getMainImage());
                    product.setProductName(product1.getName());
                    product.setProductSubtitle(product1.getSubtitle());
                    product.setProductStatuts(product1.getStatus());
                    product.setProductPrice(product1.getPrice());
                    product.setProductStock(product1.getStock());
                    //判断库存
                    int buyLimitCount=0;
                    if (product1.getStock() >= cart.getQuantity()) {
                        // 库存充足的时候
                        buyLimitCount=cart.getQuantity();
                        product.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
                        buyLimitCount=product1.getStock();
                        product.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();

                        cartForQuantity.setId(cart.getId());
                        cartForQuantity.setQuantity(buyLimitCount);

                        //更新
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }

                    product.setQuantity(buyLimitCount);

                    // 计算 总价
                    product.setProductTotalPrice(DoubleUtril.mul(product1.getPrice(),product.getQuantity()));

                    product.setProductChecked(cart.getChecked());
                }

                // 如果已经勾选，增加到整个购物车总价中
                if (cart.getChecked() == Const.Cart.CHECKED) {

                    cartTotalPrice = DoubleUtril.add(cartTotalPrice, product.getProductTotalPrice());
                }
                cartProducts.add(product);

            }
        }

        cartVO.setCartTotalPrice(cartTotalPrice);
        cartVO.setCartProductList(cartProducts);
        cartVO.setAllChecked(this.getAllCheckedStatus(userId));

        cartVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
        return  cartVO;
    }

    private boolean getAllCheckedStatus(Integer userId) {
        if (userId == null) {
            return false;
        }

        //如果勾选了就等于0
        return cartMapper.selectCartProductCheckedStatusByUserId(userId)==0;
    }
}
