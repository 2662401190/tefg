package com.tefg.service;

import com.tefg.common.ServerResponse;
import com.tefg.pojo.Category;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-05 9:34
 */
public interface ICotegoryService  {
    /**
     * 添加节点信息
     * @param cotegoryName
     * @param parenId
     * @return
     */
    ServerResponse addCotegory(String cotegoryName, Integer parenId);

    /**
     * 更新品类信息
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 查询子节点的category信息
     * @param categoryId
     * @return
     */
    ServerResponse<List<Category>> getCategoryParallelCategory(Integer categoryId);


    ServerResponse<List<Category>> getCategoryId(Integer categoryId);

    /**
     * 查询当前节点id及孩子节点信息id
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);


    List < Category >  queryAllCategory();

    List <Category> categoryDesc();

}
