package com.tefg.controller.portal;

import com.github.pagehelper.PageInfo;
import com.tefg.common.ServerResponse;
import com.tefg.service.IProductService;
import com.tefg.vo.ProductListVo;
import com.tefg.vo.ProuctDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-09 16:57
 */
@Controller
@RequestMapping(value = "/product/")
public class productController {

    @Autowired
    private IProductService iProductService;

    /**
     *  前端商品详情
     * @return
     */
    @RequestMapping(value = "product_detail.do")
    @ResponseBody
    public ServerResponse<ProuctDetailVO> detail(Integer id){
        return iProductService.getProductDetail(id);
    }

    public  ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false) String keyword,
                                          @RequestParam(value = "categoryId",required = false) Integer categoryId,
                                          @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                          @RequestParam(value = "orderBy",defaultValue = "") String  orderBy
                                          ){

        return iProductService.getProdictByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }


    /**
     * 商品搜索
     * @param productName
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("search.do")
    public String productSearch(String productName,
                                Integer categoryId,
                                @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                Model model){

        PageInfo info = iProductService.productSearch(categoryId, pageNum, pageSize);
       model.addAttribute("productName", productName);
        model.addAttribute("products", info);
        return "list";
    }

    /**
     * 搜索二级菜单
     * @param productName
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("search_two.do")
    public String productSearchWithTwo(String productName,
                                Integer categoryId,
                                @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                Model model){

        PageInfo info = iProductService.productSearchWithTwo(categoryId, pageNum, pageSize);
        model.addAttribute("productName", productName);
        model.addAttribute("products", info);
        return "list";
    }


    @RequestMapping("new_three_product.do")
    @ResponseBody
    public List<ProductListVo> newThreeProduct(){

        return iProductService.newThreeProduct();
    }

    @RequestMapping("money_ten.do")
    @ResponseBody
    public ServerResponse moneyTen(){


      return iProductService.moneyTen();
    }
    @RequestMapping("electronics_top_five.do")
    @ResponseBody
    public ServerResponse electronicsTopFive(@RequestParam(value = "categoryId",defaultValue = "100001") Integer categoryId){


        return iProductService.electronicsTopFive(categoryId);
    }



}
