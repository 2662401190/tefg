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

    /**
     * 订单状态
     */
    public enum OrderStatusEnum{
        CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已支付"),
        SHIPPED(40,"已发货"),
        ORDER_SUCCESS(50,"订单完成"),
        ORDER_CLOSE(60,"订单关闭")
        ;

        OrderStatusEnum(int code,String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int  code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    /**
     * 等待买家付款
     */
    public interface AlipayCallback{
        //交易创建,等待买家付款
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        //交易支付成功
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    /**
     * 支付平台
     */
    public enum PayPlatformEnum{
        ALIPAY(1,"支付宝");

        PayPlatformEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 在线支付
     */
    public enum PaymentTypeEnum{
        ONLINE_PAY(1,"在线支付");

        PaymentTypeEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum : values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }
}
