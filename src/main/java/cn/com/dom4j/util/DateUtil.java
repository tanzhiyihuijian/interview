package cn.com.dom4j.util;

import cn.com.dom4j.enums.WeekEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static int compare(Date d1, Date d2) {
        return d1.compareTo(d2);
    }

    public static long getSecondInterval(Date d1, Date d2) {
        checkDateParams(d1, d2);
        return d1.getTime() - d2.getTime();
    }

    public static int getYearInterval(Date d1, Date d2) {

        checkDateParams(d1, d2);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int c1Year = c1.get(Calendar.YEAR);
        int c1Month = c1.get(Calendar.MONTH) + 1;
        int c1Day = c1.get(Calendar.DAY_OF_MONTH);

        int c2Year = c2.get(Calendar.YEAR);
        int c2Month = c2.get(Calendar.MONTH) + 1;
        int c2Day = c2.get(Calendar.DAY_OF_MONTH);

        if (c1Month == c2Month) {
            if (c1Day == c2Day) {
                return c1Year - c2Year;
            } else if (c1Day > c2Day) {
                return c1Year - c2Year + (c1Year > c2Year ? 0 : 1);
            } else {
                return c1Year - c2Year - (c1Year < c2Year ? 0 : 1);
            }
        } else if (c1Month > c2Month) {
            return c1Year - c2Year + (c1Year >= c2Year ? 0 : 1);
        } else {
            return c1Year - c2Year + (c1Year <= c2Year ? 0 : -1);
        }

    }

    public static int getMonthInterval(Date d1, Date d2) {

        checkDateParams(d1, d2);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int c1Year = c1.get(Calendar.YEAR);
        int c1Month = c1.get(Calendar.MONTH) + 1;
        int c1Day = c1.get(Calendar.DAY_OF_MONTH);

        int c2Year = c2.get(Calendar.YEAR);
        int c2Month = c2.get(Calendar.MONTH) + 1;
        int c2Day = c2.get(Calendar.DAY_OF_MONTH);


        if (c1Year == c2Year) {
            return c1Month - c2Month;
        } else if (c1Year > c2Year) {
            if (c1Day >= c2Day)
                return c1Month - c2Month + (c1Month < c2Month ? 12 : 0);
            else
                return c1Month - c2Month -1 + (c1Month <= c2Month ? 12 : 0);
        } else {
            if (c1Day == c2Day)
                return c1Month - c2Month;
            else if (c1Day > c2Day)
                return c1Month - c2Month + 1 - (c1Month < c2Month ? 0 : 12);
            else
                return c1Month - c2Month - 12;
        }
    }


    public static int getDayInterval(Date d1, Date d2) {

        checkDateParams(d1, d2);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int c1Year = c1.get(Calendar.YEAR);
        int c1Month = c1.get(Calendar.MONTH) + 1;
        int c1Day = c1.get(Calendar.DAY_OF_MONTH);

        int c2Year = c2.get(Calendar.YEAR);
        int c2Month = c2.get(Calendar.MONTH) + 1;
        int c2Day = c2.get(Calendar.DAY_OF_MONTH);


        if (c1Month == c2Month) {
            if (c1Year == c2Year)
                return c1Day - c2Day;
            else if (c1Year > c2Year)
                return c1Day - c2Day + (c1Day < c2Day ? getMonthDays(c2Year, c2Month - 1) : 0);
            else
                return c1Day - c2Day - (c1Year < c2Year ? getMonthDays(c2Year, c2Month - 1) : 0);
        } else if (c1Month > c2Month) {
            if (c1Year >= c2Year)
                return c1Day - c2Day + (c1Day < c2Day ? getMonthDays(c2Year, c2Month) : 0);
            else
                return c1Day - c2Day - (c1Day > c2Day ? getMonthDays(c2Year, c2Month - 1) : 0);
        } else {
            if (c1Year == c2Year)
                return c1Day - c2Day - (c1Day > c2Day ? getMonthDays(c2Year, c2Month - 1) : 0);
            else if (c1Year > c2Year)
                return c1Day - c2Day + (c1Day < c2Day ? getMonthDays(c1Year, c1Month - 1) : 0);
            else
                return c1Day - c2Day - (c1Day > c2Day ? getMonthDays(c2Year, c2Month - 1) : 0);
        }

    }


    /**
     * 获取某一年指定月份的天数
     */
    public static int getMonthDays(int year, int month) {

        if (month < 0 || month > 12)
            throw new RuntimeException("月份参数不正确, 范围是: 1 ~ 12");

        int[] noLoopMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] loopMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return isLeapYear(year) ? loopMonth[month - 1] : noLoopMonth[month - 1];

    }

    /**
     * 判断某个年份是否是闰年
     */
    private static boolean isLeapYear(int year) {
        return year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    public static int getWeekOfYear(Date date) {
        checkDateParams(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static WeekEnum getWeekEnum(Date date) {
        checkDateParams(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

        return WeekEnum.getEnumByCode(dayOfWeek);

    }



    private static void checkDateParams(Date... dates) {

        if (dates == null || dates.length == 0)
            return;

        for (Date d : dates) {
            if (d == null)
                throw new RuntimeException("日期参数不得为空");
        }
    }

    public static String format(Date date, String pattern) {

        if (pattern == null)
            throw new RuntimeException("日期格式不得为空");

        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(date);
    }


}
