package com.codelabs.konspirasisnack.helper;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final String WEB_DATE_FORMAT = "yyyy-MM-dd";
    public static final String WEB_MONTH_FORMAT = "yyyy-MM";
    public static final String WEB_DATE_FORMAT_2 = "MM/dd/yyyy hh:mm:ss aa";
    public static final String date = "dd";
    public static final String month = "MM";
    public static final String year = "yyyy";
    public static final String month_name = "MMM";
    public static final String month_name_full = "MMMM";
    public static final String MONTH_YEAR = month_name_full+" "+ year;
    public static final String WEB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_MONTH_NAME_FULL = "dd MMMM yyyy";
    public static final String DATE_FORMAT_MONTH_NAME = "dd MMM yyyy";
    public static final String DATE_FORMAT_MONTH_NAME_NOYEAR = "dd MMM";
    public static final String DATE_FORMAT_MONTH_STANDARD = "dd-MM-yyyy";
    public static final String TIME_FORMAT_STANDARD = "HH:mm:ss";
    public static final String DATE_FORMAT_MONTH_TIME_STANDARD = DATE_FORMAT_MONTH_STANDARD+" "+TIME_FORMAT_STANDARD;
    public static final String TIME_FORMAT_STANDARD_2 = "HH:mm";
    public static final String DATE_FORMAT_MONTH_TIME_STANDARD2 = DATE_FORMAT_MONTH_NAME+" "+TIME_FORMAT_STANDARD_2;
    public static final String TIME_FORMAT_12H = "hh:mm aa";
    public static final String DATENAME_DATE_MONTH_YEAR = "EEEE, "+DATE_FORMAT_MONTH_NAME_FULL;

    public static String changeDateFormat(String initialDate, String previous, String toFormat) {
        if (initialDate == null) {
            return "";
        }
        if (initialDate.equals("0000-00-00") || initialDate.equals("")) {
            return "";
        }
        String convertedDate = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(previous);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(toFormat);

        Date date;

        try {
            date = inputFormat.parse(initialDate);
            convertedDate = outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertedDate + "";
    }

    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(WEB_DATE_TIME_FORMAT);
        return sdf.format(new Date());
    }
    public static String getTodayDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static Date addMonthToDate(Date date, int month) {
        Date dt = date;
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, month);
        dt = c.getTime();
        return dt;
    }

    public static Date convertStringToDate(String dateInString, String initFormat) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat(initFormat);
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
