package com.tefg.service.Imp;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.tefg.common.ServerResponse;
import com.tefg.dao.CategoryMapper;
import com.tefg.pojo.Category;
import com.tefg.service.ICotegoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * @author 贺威
 * @create 2018-11-05 9:35
 */
@Service("iCotegoryService")
public class CotegoryServiceImp implements ICotegoryService {

    /**
     * 打印日志
     */
    private Logger logger=LoggerFactory.getLogger(CotegoryServiceImp.class);

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 添加 节点信息
     * @param cotegoryName
     * @param parenId
     * @return
     */
    @Override
    public ServerResponse addCotegory(String cotegoryName, Integer parenId) {

        if (parenId == null || StringUtils.isBlank(cotegoryName)) {
            return ServerResponse.createByErrorMessage("添加品类参数错误");
        }
        Category category=new Category();
        category.setId(parenId);
        category.setName(cotegoryName);
        category.setStatus(true);

        int rowCount=categoryMapper.insertSelective(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加品类信息成功");
        }
        return ServerResponse.createByErrorMessage("添加品类信息失败");
    }

    /**
     * 更新品类信息
     * @param categoryId
     * @param categoryName
     * @return
     */
    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName){
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("更新品类参数错误");
        }
            Category category=new Category();
            category.setId(categoryId);
            category.setName(categoryName);

        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCount > 0) {
            // TODO: 2018/11/5    message自己加上去的
            return  ServerResponse.createBySuccess("更新品类信息成功");
        }
            return  ServerResponse.createByErrorMessage("更新品类信息失败");
    }


    /**
     *查询子节点的category信息
     * @param categoryId
     * @return
     */
    @Override
    public ServerResponse<List<Category>> getCategoryParallelCategory(Integer categoryId){

        // 根据父节点 查询 子节点信息
        List<Category> categories = categoryMapper.selectCategoryChildrenByParenId(categoryId);
        //判断查询的子节点 是否是空值 ，空集合
        if (CollectionUtils.isEmpty(categories)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categories);
    }


    /**
     * 查询当前节点id及孩子节点信息id
     * @param categoryId
     * @return
     */
    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId){
        Set<Category> categorySet = Sets.newHashSet();
        findChildCategory(categorySet, categoryId);

        List<Integer> categoryList= Lists.newArrayList();
        if (categoryId != null) {
            for (Category category : categorySet) {
                categoryList.add(category.getId());
            }
        }
        return  ServerResponse.createBySuccess(categoryList);
    }

    //查询全部分类
    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }

    /**
     * 递归算法，算出子节点
     * @return
     */
    public Set<Category> findChildCategory(Set<Category> categorySet ,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        //查找子节点， 为空就退出 递归
        //  Mybatis 返回的list集合：如果没有的话，不会返回null
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParenId(categoryId);
        for (Category category1 : categoryList) {
            findChildCategory(categorySet, category1.getId());
        }
        return categorySet;
    }

}
