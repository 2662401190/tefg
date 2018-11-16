package com.tefg.common;

/**
 * @ClassName AjaxResult
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001613:42
 * @Version 1.0
 **/
public class AjaxResult {
    public boolean success;

    public String message;

    public Page page;

    public Object datas;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
