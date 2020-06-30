package com.codelabs.konspirasisnack.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
}
