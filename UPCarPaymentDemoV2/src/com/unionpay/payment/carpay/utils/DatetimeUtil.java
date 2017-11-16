package com.unionpay.payment.carpay.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.text.format.Time;

public class DatetimeUtil {

    public static String formatLongTime(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
        return df.format(time);
    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        return df.format(new Date());
    }

    public static String getFormatCurrentTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(new Date());
    }

    public static String getFormatTime(String format, long time) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(time);
    }

    public static String getFormatTime(String format, Date date) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(date);
    }

    public static String getSystemTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        // 2016/05/05-01:01:34:364
        // System.out.println(new
        // SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
        return df.format(date);
    }

    @SuppressLint("DefaultLocale")
    public static String getSysDate() {
        Time t = new Time();
        t.setToNow();
        int year = t.year;
        int month = t.month + 1;
        int day = t.monthDay;

        int hour = t.hour; // 0-23
        int minute = t.minute;
        int second = t.second;

        return String.format("%04d%02d%02d%02d%02d%02d", year, month, day, hour, minute, second,
                Locale.getDefault());
    }

}
