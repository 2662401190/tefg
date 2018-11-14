package com.tefg.controller.backend;

import com.google.common.collect.Maps;
import com.tefg.Utril.PropertiesUtil;
import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.Product;
import com.tefg.pojo.User;
import com.tefg.service.IFilService;
import com.tefg.service.IProductService;
import com.tefg.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 贺威
 * @create 2018-11-07 9:48
 */
@Controller
@RequestMapping(value = "/manage/product/")
public class productManageContorller {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IFilService iFilService;
    /**
     * 添加商品Or 更新
     * @param session
     * @param product
     * @return
     */
    @RequestMapping(value = "product_save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }

        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.saveORupdateProduct(product);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }


    /**
     * 商品上下架
     * @param session
     * @param product
     * @return
     */
    @RequestMapping(value = "set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession session, Integer product,Integer status){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.setSaleStatus(product, status);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
     * 商品详情
     * @param session
     * @param productId
     * @return
     */
    @RequestMapping(value = "product_detail.do")
    @ResponseBody
    public ServerResponse getDetail(HttpSession session,Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.managePrdouctDetail(productId);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
     * 商品分页信息
     * @param session
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "product_list.do")
    @ResponseBody
    public ServerResponse getList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.getProductList(pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }


    /**
     * 商品搜索
     * @param session
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "product_search.do")
    @ResponseBody
    public ServerResponse productSearch(HttpSession session,String productName,Integer productId, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.searchPaoduct(productName, productId, pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }


    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "product_upload.do")
    @ResponseBody
    public  ServerResponse upload(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录;请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 路劲
            String path=request.getSession().getServletContext().getContextPath();
            String targetFileName = iFilService.upload(file, path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

            Map fileMap= Maps.newHashMap();
            fileMap.put("uri", targetFileName);
            fileMap.put("url", url);
            return ServerResponse.createBySuccess(fileMap);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
     * 富文本上传
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap=Maps.newHashMap();
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            resultMap.put("success", false);
            resultMap.put("msg", "请联系管理员");
            return resultMap;
        }
        //富文本中对于返回值有自己的要求，我们使用的是simditor ，所以按照simditor返回
        if (iUserService.checkAdminRole(user).isSuccess()) {
            // 路劲
            String path = request.getSession().getServletContext().getContextPath();
            String targetFileName = iFilService.upload(file, path);
            if (StringUtils.isBlank(targetFileName)) {
                resultMap.put("success", false);
                resultMap.put("msg", "上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

            resultMap.put("success", true);
            resultMap.put("msg", "上传成功");
            resultMap.put("file_path", url);

            response.addHeader("Access-Control-Allow-Headers","X-File-Name");
            return resultMap;

        } else {
            resultMap.put("success", false);
            resultMap.put("msg", "无权操作");
            return resultMap;
        }
    }





}
