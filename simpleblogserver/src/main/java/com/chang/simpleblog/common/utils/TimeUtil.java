package com.chang.simpleblog.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 * @Author: chang.tong
 * @Date: 2019/8/13 15:53
 * @Version 1.0
 */
public class TimeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeUtil.class);

    public TimeUtil() {
    }

    public static String getSysDate() {
        return getCurrentDate((String)null);
    }

    public static Date getSysDateAsDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getSysTime() {
        return getCurrentDate("HH:mm:ss");
    }

    public static String getSysTime2() {
        String parseStr = "HHmmss";
        return getCurrentDate(parseStr);
    }

    public static String getSysDateAll() {
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentDate(String format) {
        return formatDate(Calendar.getInstance().getTime(), format);
    }

    public static String getPreviousMonthFirst(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, -1);
        return formatDate(lastDate.getTime(), format);
    }

    public static Date getLastMonthFirstDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, -1);
        return lastDate.getTime();
    }

    public static String getFirstDayOfMonth(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        return formatDate(lastDate.getTime(), format);
    }

    public static String getNextMonthFirst(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, 1);
        return formatDate(lastDate.getTime(), format);
    }

    public static String formatDate(Date date, String format) {
        try {
            if (StringUtil.isStrEmpty(format)) {
                format = "yyyy-MM-dd";
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date);
        } catch (Exception var3) {
            return "";
        }
    }

    public static String formatDateToString(String date, String format) {
        if (StringUtil.isStrEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Calendar var3 = Calendar.getInstance();

        try {
            return dateFormat.format(dateFormat.parse(date));
        } catch (Exception e) {
            LOGGER.error("Convert String to Date Error,check String format.");
            return "";
        }
    }

    public static String getPreviousMonthLast(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(5, -1);
        return formatDate(lastDate.getTime(), format);
    }

    public static String getPrevioutMonthLast(String endDate, String format) {
        int year = Integer.valueOf(endDate.substring(0, 4));
        int month = Integer.valueOf(endDate.substring(5, 7));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        calendar.add(5, -1);
        return formatDate(calendar.getTime(), format);
    }

    public static String getLastDayOfMonth(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, 1);
        lastDate.add(5, -1);
        return formatDate(lastDate.getTime(), format);
    }

    public static String getNextMonthLast(String format) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, 2);
        lastDate.add(5, -1);
        return formatDate(lastDate.getTime(), format);
    }

    public static String getSysDateInString(Long date) {
        String sdate = String.valueOf(date);
        StringBuffer buffer = new StringBuffer();
        buffer.append(sdate.substring(0, 4)).append("-").append(sdate.substring(4, 6)).append("-").append(sdate.substring(6));
        return buffer.toString();
    }

    public static String getPreOrNextDay(String someDay, int n) {
        Date someDate = null;
        if (StringUtil.isStrEmpty(someDay)) {
            someDate = Calendar.getInstance().getTime();
        } else {
            someDate = formatDate((String)someDay, (String)null);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(someDate);
        calendar.add(6, n);
        return getSysDate(calendar.getTime());
    }

    public static Date getPreOrNextDay(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, n);
        return calendar.getTime();
    }

    public static String getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(7);
        if (1 == dayOfWeek) {
            return "周日";
        } else if (2 == dayOfWeek) {
            return "周一";
        } else if (3 == dayOfWeek) {
            return "周二";
        } else if (4 == dayOfWeek) {
            return "周三";
        } else if (5 == dayOfWeek) {
            return "周四";
        } else if (6 == dayOfWeek) {
            return "周五";
        } else {
            return 7 == dayOfWeek ? "周六" : "";
        }
    }

    public static Date formatDate(String date, String format) {
        if (StringUtil.isBlank(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date sysdate = null;
        if (StringUtil.isBlank(date)) {
            return null;
        } else {
            try {
                sysdate = dateFormat.parse(date);
            } catch (ParseException e) {
                LOGGER.error("日期格式化错误", e);
            }

            return sysdate;
        }
    }

    public static int getCurrentWeek(String endDate) {
        Date someDate = null;
        if (StringUtil.isStrEmpty(endDate)) {
            someDate = Calendar.getInstance().getTime();
        } else {
            someDate = formatDate((String)endDate, (String)null);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(someDate);
        calendar.add(6, -7);
        return calendar.get(3) + 1;
    }

    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(11, hour);
        return calendar.getTime();
    }

    public static String getSysDate(Date date) {
        return date == null ? null : formatDate((Date)date, (String)null);
    }

    public static Long getSysDateInLong() {
        return Long.valueOf(getCurrentDate("yyyyMMdd"));
    }

    public static Long getFormatDate(String strDate) {
        if (StringUtil.isBlank(strDate)) {
            return 0L;
        } else {
            StringBuffer buffer = new StringBuffer();
            buffer.append(strDate.substring(0, 4)).append(strDate.substring(5, 7)).append(strDate.substring(8, 10));
            return Long.valueOf(buffer.toString());
        }
    }

    public static String getLongFormatDate(String strDate) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(strDate.substring(0, 4)).append(strDate.substring(5, 7)).append(strDate.substring(8, 10));
        return buffer.toString();
    }

    public static Long getSomeDayInLongAfterDays(Long someDay, int days) {
        Date d = formatDate(String.valueOf(someDay), "yyyyMMdd");
        d.setDate(d.getDate() + days);
        return Long.valueOf(formatDate(d, "yyyyMMdd"));
    }

    public static Long getSomeDayInLongBeforeDays(Long someDay, int days) {
        Date d = formatDate(String.valueOf(someDay), "yyyyMMdd");
        d.setDate(d.getDate() - days);
        return Long.valueOf(formatDate(d, "yyyyMMdd"));
    }

    public static String getTheDayBeforeOneMonth() {
        Long theDay = getSomeDayInLongBeforeDays(getSysDateInLong(), 30);
        String date = String.valueOf(theDay);
        date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        return date;
    }

    public static Long getDayInLongAfterDays(int days) {
        Date d = Calendar.getInstance().getTime();
        d.setDate(d.getDate() + days);
        return Long.valueOf(formatDate(d, "yyyyMMdd"));
    }

    public static String getSomeDayTimeInLongAfterDays(Long someDay, int days) {
        Date d = formatDate(String.valueOf(someDay), "yyyyMMdd");
        d.setDate(d.getDate() + days);
        return formatDate(d, "yyyy-MM-dd HH:mm:ss");
    }

    public static Long getSomeMonthDayInLong(Long someDay, int monNum) {
        Date d = formatDate(String.valueOf(someDay), "yyyyMMdd");
        d.setMonth(d.getMonth() + monNum);
        return Long.valueOf(formatDate(d, "yyyyMMdd"));
    }


    public static long getBetweenDays(Date beginDate, Date endDate) {
        endDate.setHours(beginDate.getHours());
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        double betweenDays = (double)(endTime - beginTime) * 1.0D / 8.64E7D + 0.5D;
        return (long)Math.floor(betweenDays);
    }

    public static long getBetweenSeconds(Date beginDate, Date endDate) {
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        return endTime - beginTime;
    }

    public static String getSysDate(String parseFormat) {
        String sysdate = "";

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat(parseFormat);
            sysdate = dateFormat.format(date);
        } catch (IllegalArgumentException var5) {
            var5.printStackTrace();
            sysdate = "";
        } catch (NullPointerException var6) {
            var6.printStackTrace();
            sysdate = "";
        }

        return sysdate;
    }

    public static String getReportBeginDate(String reportPeriod, String reportEndDate) {
        String result = "";
        String year = reportEndDate.substring(0, 4);
        int month = Integer.valueOf(reportEndDate.substring(5, 7));
        if ("1".equals(reportPeriod)) {
            result = year + "-01-01";
        } else if ("2".equals(reportPeriod)) {
            result = year + "-" + String.format("%02d", month - 2) + "-01";
        } else if ("3".equals(reportPeriod)) {
            if (month == 6) {
                result = year + "-01-01";
            } else {
                result = year + "-07-01";
            }
        } else {
            result = year + "-01-01";
        }

        return result;
    }

    public static String getReportDateName(String reportPeriod, String reportEndDate) {
        String result = "";
        String year = reportEndDate.substring(0, 4);
        int month = Integer.valueOf(reportEndDate.substring(5, 7));
        if ("1".equals(reportPeriod)) {
            result = year + "年" + month + "月";
        } else if ("2".equals(reportPeriod)) {
            result = year + "年" + month / 3 + "季度";
        } else if ("3".equals(reportPeriod)) {
            if (month == 6) {
                result = year + "上半年";
            } else {
                result = year + "下半年";
            }
        } else {
            result = year + "年";
        }

        return result;
    }

    public static String[] getReportDateList(String flag) {
        if (flag != null && flag.length() >= 4) {
            String[] result = new String[2];
            if (flag.length() == 4) {
                result[0] = flag + "-01-01";
                result[1] = flag + "-12-31";
            } else {
                String year = flag.substring(0, 4);
                int season = Integer.parseInt(flag.substring(4));
                if (season == 1) {
                    result[0] = year + "-01-01";
                    result[1] = year + "-03-31";
                }

                if (season == 2) {
                    result[0] = year + "-04-01";
                    result[1] = year + "-06-30";
                }

                if (season == 3) {
                    result[0] = year + "-07-01";
                    result[1] = year + "-09-30";
                }

                if (season == 4) {
                    result[0] = year + "-10-01";
                    result[1] = year + "-12-31";
                }
            }

            return result;
        } else {
            return new String[2];
        }
    }

    public static int getSysCurrYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1);
    }

    public static Date getDateFromYYYYMMDDInt(int d) {
        GregorianCalendar cl = new GregorianCalendar();
        int year = d / 10000;
        int month = d % 10000 / 100 - 1;
        int day = d % 100;
        cl.set(year, month, day, 0, 0, 0);
        return cl.getTime();
    }

    public static Date safeToDate(Object date, String fmt, Date dv) {
        Date result = dv;
        if (date != null) {
            try {
                result = (new SimpleDateFormat(fmt)).parse(date.toString().trim());
            } catch (Exception var5) {
                ;
            }
        }

        return result;
    }

    public static int compareDate(String str1, String str2) {
        int result = 0;
        boolean b1 = StringUtil.isNotBlank(str1);
        boolean b2 = StringUtil.isNotBlank(str2);
        boolean b = NumberTool.safeToInteger(str2, 0) - NumberTool.safeToInteger(str1, 0) > 0;
        if (b1 || b2) {
            if (b) {
                result = 1;
            } else {
                result = -1;
            }
        }

        return result;
    }
}
