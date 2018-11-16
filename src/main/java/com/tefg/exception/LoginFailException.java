package com.tefg.exception;

/**
 * @ClassName LoginFailException
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001614:09
 * @Version 1.0
 **/
public class LoginFailException extends RuntimeException{
    public  LoginFailException(String message){
        super(message);
    }
}
