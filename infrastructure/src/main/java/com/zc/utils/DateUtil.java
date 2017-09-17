package com.zc.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日期转换工具
 */
public class DateUtil {
    public static final String DATE_DIVISION = "-";

    public static final String TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTON_DEFAULT = "yyyy-MM-dd";
    public static final String DATA_PATTON_YYYYMMDD = "yyyyMMdd";
    public static final String TIME_PATTON_HHMMSS = "HH:mm:ss";

    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = 60 * ONE_SECOND;
    public static final int ONE_HOUR = 60 * ONE_MINUTE;
    public static final long ONE_DAY = 24 * ONE_HOUR;

    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>>();


    /**
     * Return the current date
     *
     * @return － DATE<br>
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return currDate;
    }

    public static Date getCurrentDateByPointHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * Return the current date string
     *
     * @return － 产生的日期字符串<br>
     */
    public static String getCurrentDateStr() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return format(currDate);
    }

    public static Date getYesterday() {
        return addDays(new Date(), -1);
    }

    /**
     * Return the current date in the specified format
     *
     * @param strFormat
     * @return
     */
    public static String getCurrentDateStr(String strFormat) {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return format(currDate, strFormat);
    }

    /**
     * Parse a string and return a date value
     *
     * @param dateValue
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateValue) {
        return parseDate(DATE_PATTON_DEFAULT, dateValue);
    }

    /**
     * Parse a string and return a date value
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static Date parseDate(Object object) {
        return parseDate(DATE_PATTON_DEFAULT, (String) object);
    }

    /**
     * Parse a strign and return a datetime value
     *
     * @param dateValue
     * @return
     */
    public static Date parseDateTime(String dateValue) {
        return parseDate(TIME_PATTON_DEFAULT, dateValue);
    }

    /**
     * Parse a string and return the date value in the specified format
     *
     * @param strFormat
     * @param dateValue
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date parseDate(String strFormat, String dateValue) {
        if (dateValue == null) {
            return null;
        }

        if (strFormat == null) {
            strFormat = TIME_PATTON_DEFAULT;
        }

        // SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);

        SimpleDateFormat dateFormat = getSdf(strFormat);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            newDate = null;
        }

        return newDate;
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期。
     * @return 转换后符合给定格式的日期字符串
     */
    public static String format(Date aTs_Datetime) {
        return format(aTs_Datetime, DATE_PATTON_DEFAULT);
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期。
     * @return 转换后符合给定格式的日期字符串
     */
    public static String formatTime(Date aTs_Datetime) {
        return format(aTs_Datetime, TIME_PATTON_DEFAULT);
    }

    /**
     * 将Date类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Date aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || as_Pattern == null) {
            return null;
        }

        // //SimpleDateFormat dateFromat = new SimpleDateFormat();
        SimpleDateFormat dateFromat = getSdf(as_Pattern);
        dateFromat.applyPattern(as_Pattern);

        return dateFromat.format(aTs_Datetime);
    }

    /**
     * @param aTs_Datetime
     * @param as_Format
     * @return
     */
    public static String formatTime(Date aTs_Datetime, String as_Format) {
        if (aTs_Datetime == null || as_Format == null) {
            return null;
        }

        // SimpleDateFormat dateFromat = new SimpleDateFormat();
        SimpleDateFormat dateFromat = getSdf(as_Format);
        dateFromat.applyPattern(as_Format);

        return dateFromat.format(aTs_Datetime);
    }

    public static String getFormatTime(Date dateTime) {
        return formatTime(dateTime, TIME_PATTON_HHMMSS);
    }

    /**
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Timestamp aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || as_Pattern == null) {
            return null;
        }

        // SimpleDateFormat dateFromat = new SimpleDateFormat();
        SimpleDateFormat dateFromat = getSdf(as_Pattern);
        dateFromat.applyPattern(as_Pattern);

        return dateFromat.format(aTs_Datetime);
    }

    /**
     * 取得指定日期N天后的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }

    /**
     * 取得指定日期N年后的日期
     *
     * @param date
     * @param years
     * @return
     */
    public static Date addYears(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.YEAR, years);

        return cal.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int daysBetweenPlus(Date date1, Date date2) throws ParseException {
        String dateStr1 = format(date1);
        String dateStr2 = format(date2);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_DEFAULT);
        Date date1New = sdf.parse(dateStr1);
        Date date2New = sdf.parse(dateStr2);
        return daysBetween(date1New, date2New);
    }

    /**
     * 计算当前日期相对于"1977-12-01"的天数
     *
     * @param date
     * @return
     */
    public static long getRelativeDays(Date date) {
        Date relativeDate = DateUtil.parseDate("yyyy-MM-dd", "1977-12-01");

        return DateUtil.daysBetween(relativeDate, date);
    }

    public static Date getDateBeforTwelveMonth() {
        String date = "";
        Calendar cla = Calendar.getInstance();
        cla.setTime(getCurrentDate());
        int year = cla.get(Calendar.YEAR) - 1;
        int month = cla.get(Calendar.MONTH) + 1;
        if (month > 9) {
            date = String.valueOf(year) + DATE_DIVISION + String.valueOf(month) + DATE_DIVISION + "01";
        } else {
            date = String.valueOf(year) + DATE_DIVISION + "0" + String.valueOf(month) + DATE_DIVISION + "01";
        }

        Date dateBefore = parseDate(date);
        return dateBefore;
    }

    /**
     * 传入时间字符串,加一天后返回Date
     *
     * @param date 时间 格式 YYYY-MM-DD
     * @return
     */
    public static Date addDate(String date) {
        if (date == null) {
            return null;
        }

        Date tempDate = parseDate(DATE_PATTON_DEFAULT, date);
        String year = format(tempDate, "yyyy");
        String month = format(tempDate, "MM");
        String day = format(tempDate, "dd");

        GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

        calendar.add(GregorianCalendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 判断两个日期是否为同一个星期（星期从第几天开始可自定义）
     *
     * @param calendar1
     * @param calendar2
     * @param firstDayOfWeek 一个星期第一天定义
     * @return true-同一个星期，false-不同的星期
     */
    public static boolean isSameWeek(Calendar calendar1, Calendar calendar2, int firstDayOfWeek) {
        calendar1.setFirstDayOfWeek(firstDayOfWeek);
        calendar2.setFirstDayOfWeek(firstDayOfWeek);

        int taskPlanWeek = calendar2.get(Calendar.WEEK_OF_YEAR);
        int currentWeek = calendar1.get(Calendar.WEEK_OF_YEAR);

        boolean isSameWeek = (taskPlanWeek == currentWeek);
        return isSameWeek;
    }

//    /**
//     * 把当地时间转换成北京时间(通过增加或减少时差偏移量单位为分钟)
//     */
//    public static String getOffsetTime(String patton, String time, int amount) {
//        Date dateTime = DateUtil.parseDate(patton, time);
//        dateTime = DateUtils.add(dateTime, Calendar.MINUTE, amount);
//        return DateUtil.formatTime(dateTime, patton);
//    }
//
//    /**
//     * 把当地时间转换成北京时间(通过增加或减少时差偏移量单位为秒)
//     */
//    public static String getOffsetTimeSecond(String patton, String time, int amount) {
//        Date dateTime = DateUtil.parseDate(patton, time);
//        dateTime = DateUtils.add(dateTime, Calendar.SECOND, amount);
//        return DateUtil.formatTime(dateTime, patton);
//    }
//
//    public static String getDateString(Date date, String format) {
//        if (date == null)
//            return "";
//        if (StringUtils.isEmpty(format)) {
//            format = "yyyy-MM-dd";
//        }
//        SimpleDateFormat sdf = getSdf(format);
//        return sdf.format(date);
//    }

    public static long compareDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("date can not be null");
        }
        return date1.getTime() - date2.getTime();
    }

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    public static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 减少尝试的并发量
        if (tl == null) {
            sdfMap.putIfAbsent(pattern, new ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    return new SimpleDateFormat(pattern);
                }
            });
            tl = sdfMap.get(pattern);
        }

        return tl.get();
    }

    public static Date trunc(Date date1, String format) {

        if (date1 == null) {
            return null;
        }

        if (format == null) {
            format = DATE_PATTON_DEFAULT;
        }
        return DateUtil.parseDate(DateUtil.format(date1, format));

    }


    public static Date dateNvl(Date date1, Date date2) {

        if (date1 == null) {
            if (date2 == null) {
                return DateUtil.getCurrentDate();
            } else {
                return date2;
            }

        } else {
            return date1;
        }
    }

    public static Date dateNvl(Date date1) {
        return dateNvl(date1, null);
    }


    public static boolean nowInInterval(Date date1, Date date2) {
        return dateInInterval(new Date(), date1, date2);
    }

    public static boolean dateInInterval(Date target, Date date1, Date date2) {
        if (date1 == null || date2 == null || target == null) {
            return false;
        }

        long date1Time = date1.getTime();

        long date2Time = date2.getTime();

        long targetTime = target.getTime();

        return (targetTime >= date1Time && targetTime <= date2Time) || (targetTime <= date1Time && targetTime >= date2Time);
    }

    public static boolean isToday(Date lastNoticeDate) {

        return lastNoticeDate == null ? false : format(new Date()).equals(format(lastNoticeDate));

    }
}
