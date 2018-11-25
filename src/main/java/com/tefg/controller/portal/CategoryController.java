package com.tefg.controller.portal;

import com.tefg.common.ServerResponse;
import com.tefg.pojo.Category;
import com.tefg.service.ICotegoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-19 14:54
 */
@Controller
@RequestMapping("/category/")
public class CategoryController {


    @Autowired
    private ICotegoryService iCotegoryService;

    /**
     * 获取父节点
     * @param parentId
     * @return
     */
    @RequestMapping(value = "get_category_parentId.do")
    @ResponseBody
    public ServerResponse getParent(@RequestParam(value = "parentId",defaultValue = "0") Integer parentId){

        return iCotegoryService.getCategoryParallelCategory(parentId);
    }


    /**
     * 获取子节点
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "get_category_id.do")
    @ResponseBody
    public ServerResponse getCategory(@RequestParam(value = "categoryId") Integer categoryId){
        return iCotegoryService.getCategoryId(categoryId);
    }



    @RequestMapping("category_desc.do")
    @ResponseBody
    public List<Category> categoryDesc(){

        return  iCotegoryService.categoryDesc();
    }














}
