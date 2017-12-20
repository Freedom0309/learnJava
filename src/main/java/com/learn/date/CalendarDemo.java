package com.learn.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 23:28 2017/12/20
 * @Modified By:
 **/
public class CalendarDemo {

    /**
     * 获取当前系统的前一天时间
     * @param date
     * @return
     */
    public static Date getPreviousDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }
}
