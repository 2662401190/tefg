package com.tefg.common;

/**
 * @author 贺威
 * TODO 常量类
 * @create 2018-11-01 11:09
 */
public class Const {

    //登录时保存的常量
    public  static final String  CURRENT_USER = "currentUser";

    //邮箱
    public static final String EMAIL = "email";

    //用户名
    public static  final  String USWENAME = "username";

    //角色管理
    public  interface  Role{
        /**
         * 普通用户
         */
        int ROLE_CUSTOMER=0;
        /**
         * 管理员
         */
        int ROLE_ADMIN = 1;


    }
}
