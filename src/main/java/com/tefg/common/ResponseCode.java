package com.tefg.common;

/**
 * @author 贺威
 * @create 2018-10-31 18:28
 */
public enum ResponseCode {

    //成功
    SUCCESS(0,"SUCCESS"),
    //失败
    ERROR(1,"ERROR"),
    //登录
    NEED_LOGIN(10,"NEED_LOGIN"),

    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private  final  int code;
    private  final String desc;

    ResponseCode(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int  getCode(){
        return  code;
    }

    public String getDesc(){
        return  desc;
    }
}
