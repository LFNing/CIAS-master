package com.example.testit.util;
//该类实现本地时间的获取
import java.util.Date;
import java.util.Calendar;
import java.lang.String;

public class DateUtil {
    public String getDate(){
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        month+=1;
        int day=cal.get(Calendar.DATE);
        String Date = year + "年" + (month<10?"0"+month:month) + "月" + (day<10?"0"+day:day) + "日";
        return Date;
    }

    public String getNowTime(){
        Calendar cal=Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        String Time=(hour<10?"0"+hour:hour)+":"+(minute<10?"0"+minute:minute)+":"+(second<10?"0"+second:second);
        return Time;
    }


}