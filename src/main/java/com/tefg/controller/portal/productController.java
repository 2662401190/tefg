package com.tefg.controller.portal;

import com.github.pagehelper.PageInfo;
import com.tefg.common.ServerResponse;
import com.tefg.service.IProductService;
import com.tefg.vo.ProuctDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
