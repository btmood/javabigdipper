package com.lark.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author btmood
 * @date 2021-08-11 17:42
 * @Description TODO
 */
public class DateUtil {

    /**
     * Date转LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    /**
     * LocalDateTime转Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 获取时间的字符串
     */
    public static String getDateStr(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime time = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(time);
    }

    public static String getDateStr(LocalDate localDate, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(localDate);
    }

    public static String getDateStr(LocalDateTime localDateTime, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 获取当前时间的字符串
     * @return
     */
    public static String getNowTimeStr() {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(nowTime);
    }

    /**
     * long类型timestamp转LocalDateTime
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * LocalDateTime转long类型timestamp
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 获取两个时间的间隔秒数
     * @param s1
     * @param s2
     * @return
     */
    public static long getBetweenSeconds(String s1, String s2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse1 = LocalDateTime.parse(s1, formatter);
        LocalDateTime parse2 = LocalDateTime.parse(s2, formatter);
        Duration between = Duration.between(parse1, parse2);
        return between.toMillis() / 1000;
    }

    /**
     * 获取两个字符串日期间隔的天数
     * @param s1：xxxx-xx-xx
     * @param s2: xxxx-xx-xx
     * @return
     */
    public static long getBetweenDays(String s1, String s2) {
        LocalDate localDate1 = LocalDate.parse(s1);
        LocalDate localDate2 = LocalDate.parse(s2);
        return localDate2.toEpochDay() - localDate1.toEpochDay();
    }
}
