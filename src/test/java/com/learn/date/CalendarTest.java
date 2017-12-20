package com.learn.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 23:33 2017/12/20
 * @Modified By:
 **/
public class CalendarTest {

    @Test
    public void getPreviousDayTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CalendarDemo calendarDemo = new CalendarDemo();
        Date date = calendarDemo.getPreviousDay(new Date());
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(date + ">>>>>>");
        System.out.println(simpleDateFormat.format(date));
    }
}
