package com.tefg.controller.backend;

import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.User;
import com.tefg.service.ICotegoryService;
import com.tefg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 贺威
 * @create 2018-11-05 8:58
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICotegoryService iCotegoryService;

    @RequestMapping(value = "add_category.do")
    @ResponseBody
    public ServerResponse AddCategory(HttpSession session, String cotegoryName, @RequestParam(value = "parenId", defaultValue = "0") Integer parenId) {
        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
                //  添加分类信息
            return  iCotegoryService.addCotegory(cotegoryName, parenId);
        } else {
            return  ServerResponse.createByErrorMessage("没有权限操作,需要管理员");
        }
    }

    /**
     * 更新 CategoryName
     * @param session
     * @param categoryId
     * @param categoryName
     * @return
     */
    @RequestMapping(value = "set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session,Integer categoryId,String categoryName  ){
        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            // 更新categoryName
            return  iCotegoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return  ServerResponse.createByErrorMessage("没有权限操作,需要管理员");
        }
    }

    /**
     * 获取平级的信息
     * @return
     */
    @RequestMapping(value = "get_category.do")
    @ResponseBody
    public  ServerResponse  getChidrenParallelCategory(HttpSession session ,@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId ){
        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息，并且不递归，保持平级
            return iCotegoryService.getCategoryParallelCategory(categoryId);
        } else {
            return  ServerResponse.createByErrorMessage("没有权限操作,需要管理员");
        }
    }

    /**
     * 获取CategoryID ，并且递归查询子节点信息
     */
    @RequestMapping(value = "get_deep_category.do")
    @ResponseBody
    public  ServerResponse  getCategoryAndDeepChildrenCategory(HttpSession session ,@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId ){
        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id 和递归子节点的id
            return iCotegoryService.selectCategoryAndChildrenById(categoryId);
        } else {
            return  ServerResponse.createByErrorMessage("没有权限操作,需要管理员");
        }
    }

}
