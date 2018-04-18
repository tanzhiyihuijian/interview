package cn.com.dom4j.util;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateUtilTest {
    @Test
    public void compare() throws Exception {
    }

    @Test
    public void getInterval() throws Exception {
    }

    @Test
    public void getYearInterval() throws Exception {

        DateTime d1 = new DateTime(1995, 6, 3, 0, 0);
        DateTime d2 = new DateTime(1996, 5, 4, 0, 0);

        int interval = DateUtil.getYearInterval(d1.toDate(), d2.toDate());
        System.out.println(interval);


    }

    @Test
    public void getMonthInterval() throws Exception {

        DateTime d1 = new DateTime(1995, 4, 3, 0, 0);
        DateTime d2 = new DateTime(1996, 3, 5, 0, 0);

        int interval = DateUtil.getMonthInterval(d1.toDate(), d2.toDate());
        System.out.println(interval);


    }

    @Test
    public void getDayInterval() throws Exception {

        DateTime d1 = new DateTime(1995, 5, 3, 0, 0);
        DateTime d2 = new DateTime(1996, 4, 4, 0, 0);

        int interval = DateUtil.getYearInterval(d1.toDate(), d2.toDate());
        System.out.println(interval);

        interval = DateUtil.getMonthInterval(d1.toDate(), d2.toDate());
        System.out.println(interval);

        interval = DateUtil.getDayInterval(d1.toDate(), d2.toDate());
        System.out.println(interval);
    }

    @Test
    public void getMonthDays() throws Exception {

        int days = DateUtil.getMonthDays(2018, 2);

        System.out.println(days);

    }

    @Test
    public void dateToStr() throws Exception {
    }

}