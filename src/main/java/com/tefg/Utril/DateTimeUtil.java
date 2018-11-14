package com.tefg.Utril;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author 贺威
 * @create 2018-11-07 14:40
 */
public class DateTimeUtil {

//     到 joda 包
    public static final  String STANDAR_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 字符串 转时间类型
     * @param dateTimeStr
     * @return
     */
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern( STANDAR_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);

        return  dateTime.toDate();
    }

    /**
     * 时间转字符串
     * @param date
     * @return
     */
    public static  String dateToStr(Date date){
        if (date == null) {
            //返回一个空的
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDAR_FORMAT);
    }


    /**
     * 字符串 转时间类型
     * @param dateTimeStr
     * @param formatStr
     * @return
     */
    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern( formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);

        return  dateTime.toDate();
    }

    /**
     * 时间转字符串
     * @param date
     * @param formarStr
     * @return
     */
    public static  String dateToStr(Date date,String formarStr){
        if (date == null) {
            //返回一个空的
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formarStr);
    }



}
