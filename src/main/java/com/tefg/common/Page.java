package com.tefg.common;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001613:43
 * @Version 1.0
 **/
public class Page {
    public Integer pageno;//当前页
    public Integer pagesize;//一页显示数量
    public List datas;//集合
    public Integer totalsize;//总行数
    public Integer totalno;//总页数

    public Page(Integer pageno, Integer pagesize) {
        if(pageno<=0){
            this.pageno = 1;
        }else{
            this.pageno = pageno;
        }

        if(pagesize<=0){
            this.pagesize = 10;
        }else{
            this.pagesize = pagesize;
        }




    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
        this.totalno=(totalsize%pagesize)==0?(totalsize/pagesize):(totalsize/pagesize+1);
    }

    public Integer getTotalno() {
        return totalno;
    }

    public void setTotalno(Integer totalno) {
        this.totalno = totalno;
    }


    public Integer getstartIndex(){
        return (this.pageno-1)*pagesize;
    }
}
