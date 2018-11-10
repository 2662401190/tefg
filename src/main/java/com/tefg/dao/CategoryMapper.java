package com.tefg.dao;

import com.tefg.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);


    /**
     * 查询子节点信息
     * @param parent_id
     * @return
     */
    List<Category> selectCategoryChildrenByParenId(Integer parent_id);
}