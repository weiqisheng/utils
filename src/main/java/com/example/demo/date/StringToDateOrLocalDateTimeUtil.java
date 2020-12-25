package com.example.demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author weiqisheng
 * @Title: StringToDateOrLocalDateTimeUtil
 * @ProjectName utils
 * @Description: TODO
 * @date 2020/12/2511:44
 */
public class StringToDateOrLocalDateTimeUtil {

    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 获取年月日
     * @param date
     * @return
     */
    public static Date getDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        try {
            Date now = simpleDateFormat.parse(date);
            return now;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取年月日加时间
     * @param date
     * @return
     */
    public static Date getDateTime(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);
        try {
            Date now = simpleDateFormat.parse(date);
            return now;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取年月日
     * @param date
     * @return
     */
    public static String getDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 获取年月日加时间
     * @param date
     * @return
     */
    public static String getDateTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);
        String format = simpleDateFormat.format(date);
        return format;
    }


    /**
     * localDate 转 String 获取年月日
     * @param localDate
     * @return
     */
    public static String getDate(LocalDate localDate){
        if (Objects.isNull(localDate)){
            return null;
        }
        return localDate.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }

    /**
     * localDateTime 转 String 获取年月日加时间
     * @param localDateTime
     * @return
     */
    public static String getDateTime(LocalDateTime localDateTime){
        if (Objects.isNull(localDateTime)){
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN));
    }



    /**
     * Date 转 LocalDate
     * @param date
     * @return
     */
    public static LocalDate getLocalDate(Date date){
        if (Objects.isNull(date)){
            return null;
        }
        //ZoneId.systemDefault() 获取时区
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date 转 localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime getLocalDateTime(Date date){
        if (Objects.isNull(date)){
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * localDate 转 Date
     * @param localDate
     * @return
     */
    public static Date getDateByLocalDate(LocalDate localDate){
        if (Objects.isNull(localDate)){
            return null;
        }
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * localDateTime 转 Date
     * @param localDateTime
     * @return
     */
    public static Date getDateByLocalDateTime(LocalDateTime localDateTime){
        if (Objects.isNull(localDateTime)){
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 毫秒级时间戳
     * @param localDateTime
     * @return
     */
    public static Long getMilli(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 秒级时间戳
     * @param localDateTime
     * @return
     */
    public static Long getSecond(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).getEpochSecond();
    }

    /**
     * 毫秒转时间
     * @param milli
     * @return
     */
    public static LocalDateTime getLocalDateTimeByMilli(Long milli){
        return Instant.ofEpochMilli(milli).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 毫秒转时间
     * @param milli
     * @return
     */
    public static LocalDate getLocalDateByMilli(Long milli){
        return Instant.ofEpochMilli(milli).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }


}
