package com.example.demo.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author weiqisheng
 * @Title: DateUtil
 * @ProjectName utils
 * @Description: TODO   Date工具类
 * @date 2020/12/2511:36
 */
public class DateUtil {

    /**
     * 方法实现说明  获取当天的开始时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 8:37
     */
    public static Date getStartDay(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }

    /**
     * 方法实现说明 获取今日的结束时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 8:40
     */
    public static Date getEndDay(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }

    /**
     * 方法实现说明 当周开始时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getStarWeek(){
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        return calendar.getTime();
    }
    /**
     * 方法实现说明 当周结束时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getEndWeek(){
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        return calendar.getTime();
    }
    /**
     * 方法实现说明 当月开始时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getStarMonth(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }
    /**
     * 方法实现说明 当月结束时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getEndMonth(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }
    /**
     * 方法实现说明 当年开始时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getStarYear(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }
    /**
     * 方法实现说明 当年结束时间
     * @author      weiqs
     * @return : java.util.Date
     * @date        2020-12-22 9:19
     */
    public static Date getEndYear(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }
}
