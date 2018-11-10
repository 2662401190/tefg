package com.tefg.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.tefg.Utril.DateTimeUtil;
import com.tefg.Utril.PropertiesUtil;
import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.dao.CategoryMapper;
import com.tefg.dao.ProductMapper;
import com.tefg.pojo.Category;
import com.tefg.pojo.Product;
import com.tefg.service.ICotegoryService;
import com.tefg.service.IProductService;
import com.tefg.vo.ProductListVo;
import com.tefg.vo.ProuctDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-07 10:06
 */
@Service("iProductService")
public class ProductServiceIpm implements IProductService {


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ICotegoryService iCotegoryService;
    /**
     * 保存或者更新
     * @return
     */
    @Override
    public ServerResponse saveORupdateProduct(Product product){

        if (product != null) {
            //如果子图不是空的,就把子图，第一个赋值给主图
            if (StringUtils.isNotBlank(product.getSubImages())) {
                String [] subImageArray=product.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    product.setMainImage(subImageArray[0]);
                }
            }

            //更新
            if (product.getId() != null) {
                int rowCount = productMapper.updateByPrimaryKey(product);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("更新商品成功");
                }else {
                    return ServerResponse.createByErrorMessage("更新商品失败");
                }
            } else {
                int rowCount = productMapper.insert(product);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("保存商品成功");
                } else {
                    return ServerResponse.createByErrorMessage("保存商品失败");
                }
            }

        }
        return ServerResponse.createByErrorMessage("保存商品或者更新商品失败");
    }


    /**
     * 商品的上下架
     * @param productId
     * @param status
     * @return
     */
    @Override
    public ServerResponse<String> setSaleStatus(Integer productId, Integer status){

        if (productId == null || status == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product=new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount > 0) {
            return  ServerResponse.createBySuccessMessage("修改商品销售状态成功");
        }
        return  ServerResponse.createByErrorMessage("修改商品销售状态失败");
    }


    /**
     * 后台
     *
     *
     * 获取商品详情
     * @param productId
     * @return
     */
    @Override
    public ServerResponse<ProuctDetailVO> managePrdouctDetail(Integer productId) {
        if (productId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //获取商品详情
        Product product=productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return  ServerResponse.createByErrorMessage("商品已下架或删除");
        }
        ProuctDetailVO detailVO = assembleProductDetailVo(product);
        return ServerResponse.createBySuccess(detailVO);
    }

    public ProuctDetailVO assembleProductDetailVo(Product product){
        ProuctDetailVO prouctDetailVO=new ProuctDetailVO();
        prouctDetailVO.setId(product.getId());
        prouctDetailVO.setSubtitle(product.getSubtitle());
        prouctDetailVO.setPrice(product.getPrice());
        prouctDetailVO.setMainImage(product.getMainImage());
        prouctDetailVO.setSubimages(product.getSubImages());
        prouctDetailVO.setCategory(product.getCategoryId());
        prouctDetailVO.setDetail(product.getDetail());
        prouctDetailVO.setName(product.getName());
        prouctDetailVO.setStatucs(product.getStatus());
        prouctDetailVO.setStock(product.getStock());

        prouctDetailVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happytefg.com/"));


        Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());

        if (category == null) {
            //默认根节点
            prouctDetailVO.setParenCategory(0);
        }else {
            prouctDetailVO.setParenCategory(category.getParentId());
        }

        prouctDetailVO.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
        prouctDetailVO.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));

        return prouctDetailVO;
    }


    /**
     * 商品分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getProductList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList=productMapper.products_list();
        List<ProductListVo> productListVos=new ArrayList<>();
        for (Product product : productList) {
            ProductListVo productListVo = assembleProductListVo(product);
            productListVos.add(productListVo);
        }

        PageInfo info = new PageInfo(productList);
        info.setList(productListVos);

        return ServerResponse.createBySuccess(info);
    }


    public ProductListVo  assembleProductListVo(Product product){
        ProductListVo productListVo=new ProductListVo();
        productListVo.setId(product.getId());
        productListVo.setName(product.getName());
        productListVo.setCategoryId(product.getCategoryId());
        productListVo.setMainImage(product.getMainImage());
        productListVo.setSubtitle(product.getSubtitle());
        productListVo.setStatus(product.getStatus());
        productListVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happytefg.com/"));
        productListVo.setPrice(product.getPrice());

        return productListVo;
    }

    /**
     *  搜索商品
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> searchPaoduct(String productName, Integer productId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(productName)) {
            productName=new StringBuffer().append("% ").append(productName).append(" %").toString();
        }
        List<Product> productList = productMapper.selectByNameAndProduct(productName, productId);
        List<ProductListVo> productListVos=new ArrayList<>();
        for (Product product : productList) {
            ProductListVo productListVo = assembleProductListVo(product);
            productListVos.add(productListVo);
        }
        PageInfo info = new PageInfo(productList);
        info.setList(productListVos);
        return ServerResponse.createBySuccess(info);
    }

    // todo  前端一下



    /**
     * 前端  商品详情
     * @param productId
     * @return
     */
    @Override
    public  ServerResponse<ProuctDetailVO> getProductDetail(Integer productId){
        if (productId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //获取商品详情
        Product product=productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return  ServerResponse.createByErrorMessage("商品已下架或删除");
        }
        if (product.getStatus()!= Const.ProductStatusEnum.ON_SALE.getCode()) {
            return  ServerResponse.createByErrorMessage("商品已下架或删除");
        }
        ProuctDetailVO detailVO = assembleProductDetailVo(product);
        return ServerResponse.createBySuccess(detailVO);
    }


    /**
     * 商品分页 搜索
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getProdictByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy){

        if (StringUtils.isBlank(keyword) && categoryId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode
            .ILLEGAL_ARGUMENT.getDesc());
        }
        List<Integer> CategoryIdList=new ArrayList<>();
        if (categoryId != null) {
            Category category = categoryMapper.selectByPrimaryKey(categoryId);
            if (category==null&&StringUtils.isBlank(keyword)){
                PageHelper.startPage(pageNum, pageSize);
                List<ProductListVo> productListVoList= Lists.newArrayList();
                PageInfo pageInfo=new PageInfo();
                return ServerResponse.createBySuccess(pageInfo);
            }
            CategoryIdList = iCotegoryService.selectCategoryAndChildrenById(category.getId()).getData();
        }
        if (StringUtils.isNotBlank(keyword)) {
            keyword=new StringBuffer().append("%").append(keyword).append("%").toString();
        }

        PageHelper.startPage(pageNum, pageSize);
        //排序处理
        if (StringUtils.isNotBlank(orderBy)) {
            if (Const.ProductListOrderBy.PRI_ASC_DESC.contains(orderBy)) {
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0]+" "+ orderByArray[1]);
            }
        }

        List<Product> productList = productMapper.selectByNameAndCategoryIds(StringUtils.isBlank(keyword) ? null : keyword, CategoryIdList.size()==0?null:CategoryIdList);

        List<ProductListVo> productListVos=Lists.newArrayList();
        for (Product product : productList) {
            ProductListVo productListVo = assembleProductListVo(product);
            productListVos.add(productListVo);
        }

        PageInfo pageInfo = new PageInfo(productList);
        pageInfo.setList(productListVos);
        return  ServerResponse.createBySuccess(pageInfo);
    }






}
