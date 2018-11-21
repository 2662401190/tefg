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

<<<<<<< Updated upstream

    /**
     * 根据父节点查询子节点
     * @param categoryId
     * @return
     */
    List<Category> selectCategoryId(Integer categoryId);
=======
    List<Category> queryAllCategory();
>>>>>>> Stashed changes
}