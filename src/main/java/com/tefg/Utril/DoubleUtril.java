package com.tefg.Utril;

import java.math.BigDecimal;

/**
 * @author 贺威
 * @create 2018-11-12 16:21
 */
public class DoubleUtril {

    /**
     * 增加
     * @param v1
     * @param v2
     * @return
     */
    public static Double add(double v1,double v2){

        return v1+v2;
    }

    /**
     * 减法
     * @param v1
     * @param v2
     * @return
     */
    public  static Double sub(double v1,double v2){

        return v1-v2;
    }

    /**
     * 乘法
     * @param v1
     * @param v2
     * @return
     */
    public  static Double mul(double v1,double v2){

        return  v1*v2;
    }

    /**
     * 除法
     * @param v1
     * @param v2
     * @return
     */
    public static Double div(double v1,double v2){

        //保留两位数
        double f1 = new BigDecimal(v1/v2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}
