package com.tefg.controller.manager;

import com.tefg.common.AjaxResult;
import com.tefg.pojo.Category;
import com.tefg.service.ICotegoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName category
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\21 002111:08
 * @Version 1.0
 **/
@Controller
@RequestMapping("category")
public class McategoryController {
    @Autowired
    private ICotegoryService iCotegoryService;

    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData(){
        AjaxResult result=new AjaxResult();
        try {
            List<Category> root=new ArrayList<Category>();
            //查询全部商品
            List<Category> childredCategory=iCotegoryService.queryAllCategory();
            Map<Integer,Category> map=new HashMap<Integer, Category>();

            for(Category innerCategory:childredCategory){
                map.put(innerCategory.getId(),innerCategory);
            }

            for(Category category:childredCategory){
                //通过子节点查询父节点
                Category child=category;//假设为子菜单
                if(child.getParentId()==0){
                    root.add(child);
                }else{
                    Category parent=map.get(category.getParentId());
                    parent.getChildren().add(category);
                }
            }
            result.setSuccess(true);
            result.setDatas(root);
        }catch (Exception e){
            result.setMessage("加载数据失败");
            e.printStackTrace();
        }
        return result;
    }
}
