package com.codelabs.konspirasisnack.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static void setNoStatusBar(Window window) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }


    public static void showToast(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static void changeVisibility(View v) {
        v.setVisibility(v.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    public static String toCurrency(String price) {
        price = price.replace(".00","");
        if (TextUtils.isEmpty(price)) {
            price = "0";
        }


        Locale locale = new Locale("in", "ID");
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        //format.setCurrency(Currency.getInstance(currency));
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("");
        formatRp.setDecimalSeparator('.');
        formatRp.setGroupingSeparator(',');


        kursIndonesia.setMinimumFractionDigits(0);
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(Double.parseDouble(price)).replace(",", ".");
    }
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


}
