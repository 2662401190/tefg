package com.tefg.dao;

import com.tefg.pojo.Category;
import org.apache.ibatis.annotations.Select;

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



    /**
     * 根据父节点查询子节点
     * @param categoryId
     * @return
     */
    List<Category> selectCategoryId(Integer categoryId);

    List<Category> queryAllCategory();


    @Select("select * from tefg_category order by id desc limit 9")
    List<Category> categoryDesc();

}