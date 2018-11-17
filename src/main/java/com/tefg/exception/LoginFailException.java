package com.tefg.exception;

/**
 * @ClassName LoginFailException
 * @Description TODO
 * @Author Administrator
 * @Date 2018\10\13 001320:32
 * @Version 1.0
 **/
public class LoginFailException extends RuntimeException {
    public LoginFailException(String message){
        super(message);
    }
}
