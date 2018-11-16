package com.tefg.common;

import com.google.common.collect.Sets;

import java.util.Set;

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

    //后台用户名
    public static final String ManagerUser="manageruser";

    public interface Cart{
        //购物车选中状态
        int CHECKED=1;
        //未选中
        int UN_CHENCKED=0;

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS ="LIMIT_NUM_SUCCESS";

    }

    //商品排序
    public  interface ProductListOrderBy{
        Set<String> PRI_ASC_DESC= Sets.newHashSet("price_desc","price_asc");
    }



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

    public enum ProductStatusEnum {
        ON_SALE(1,"在线");
        private  String value;
        private int code;

        ProductStatusEnum(int code,String value ) {
            this.value=value;
            this.code=code;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }
}
