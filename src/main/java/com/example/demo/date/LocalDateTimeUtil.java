package com.example.demo.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

/**
 * @author weiqisheng
 * @Title: LocalDateTimeUtil
 * @ProjectName utils
 * @Description: TODO localDateUtil工具类
 * @date 2020/12/2511:43
 */
public class LocalDateTimeUtil {

    private static final int FIRST_HOUR = 0;
    private static final int LAST_HOUR = 23;
    private static final int FIRST_MINUTE = 0;
    private static final int LAST_MINUTE = 59;
    private static final int FIRST_SECOND = 0;
    private static final int LAST_SECOND = 59;
    private static final int FIRST_NANO = 0;
    private static final int LAST_NANO = 999999999;
    private static final ZoneId zoneId = ZoneId.of("UTC+08:00");

    /**
     * 方法实现说明 获取当天的开始时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:09
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(FIRST_HOUR)
                .withMinute(FIRST_MINUTE)
                .withSecond(FIRST_SECOND)
                .withNano(FIRST_NANO);
    }

    /**
     * 方法实现说明 获取当天的结束时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:11
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(LAST_HOUR)
                .withMinute(LAST_MINUTE)
                .withSecond(LAST_SECOND)
                .withNano(LAST_NANO);
    }

    /**
     * 方法实现说明 获取一周的开始时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:35
     */
    public static LocalDateTime getWeekStart(LocalDateTime time) {
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        return time.with(fieldISO, 1)
                .withHour(FIRST_HOUR)
                .withMinute(FIRST_MINUTE)
                .withSecond(FIRST_SECOND)
                .withNano(FIRST_NANO);
    }

    /**
     * 方法实现说明 获取一周的的结束时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:37
     */
    public static LocalDateTime getWeekEnd(LocalDateTime time) {
        TemporalField fieldUS = WeekFields.of(Locale.US).dayOfWeek();
        return time.with(fieldUS, 1)
                .withHour(LAST_HOUR)
                .withMinute(LAST_MINUTE)
                .withSecond(LAST_SECOND)
                .withNano(LAST_NANO);
    }

    /**
     * 方法实现说明 获取当月的开始时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:13
     */
    public static LocalDateTime getMonthStart(LocalDateTime time) {
        return time.withDayOfMonth(1)
                .withHour(FIRST_HOUR)
                .withMinute(FIRST_MINUTE)
                .withSecond(FIRST_SECOND)
                .withNano(FIRST_NANO);
    }

    /**
     * 方法实现说明 获取当月的结束时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:15
     */
    public static LocalDateTime getMonthEnd(LocalDateTime time) {
        return time.plusMinutes(1).withDayOfMonth(1).minusDays(1)
                .withHour(LAST_HOUR)
                .withMinute(LAST_MINUTE)
                .withSecond(LAST_SECOND)
                .withNano(LAST_NANO);
    }

    /**
     * 方法实现说明 获取本年的开始时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:17
     */
    public static LocalDateTime getYearStart(LocalDateTime time) {
        return time.withDayOfYear(1)
                .withHour(FIRST_HOUR)
                .withMinute(FIRST_MINUTE)
                .withSecond(FIRST_SECOND)
                .withNano(FIRST_NANO);
    }

    /**
     * 方法实现说明 获取本年的结束时间
     *
     * @param time :
     * @return : java.time.LocalDateTime
     * @author weiqs
     * @date 2020-12-1 9:30
     */
    public static LocalDateTime getYearEnd(LocalDateTime time) {
        return time.plusYears(1).withDayOfYear(1).minusDays(1)
                .withHour(LAST_HOUR)
                .withMinute(LAST_MINUTE)
                .withSecond(LAST_SECOND)
                .withNano(LAST_NANO);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

}
