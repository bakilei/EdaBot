package com.tufypace.yaedabot.utils;


import android.util.Log;

import java.util.Locale;
import java.util.Random;

public class Utils {

    public static Double getFormattedDouble(Double d2, int i) {
        if (d2 == null) {
            return null;
        }
        try {
            Locale locale = Locale.ENGLISH;
            return Double.valueOf(String.format(locale, "%." + i + "f", d2));
        } catch (NumberFormatException e2) {
            Log.d(e2.getMessage(), " getFormattedDouble");
            return null;
        }
    }

    public static Float getFormattedFloat(Float d2, int i) {
        if (d2 == null) {
            return null;
        }
        try {
            Locale locale = Locale.ENGLISH;
            return Float.valueOf(String.format(locale, "%." + i + "f", d2));
        } catch (NumberFormatException e2) {
            Log.d(e2.getMessage(), " getFormattedFloat");
            return null;
        }
    }

    public static Random r = new Random();

    public static Float randFloat(float bound1, float bound2) {
        float rand = getFormattedFloat(bound1 + r.nextFloat() * (bound2 - bound1), 2);
        Log.d("RANDOM FLOAT", String.valueOf(rand));
        return rand;
    }

    public static double randDouble(double bound1, double bound2) {
        double rand = getFormattedDouble(bound1 + r.nextFloat() * (bound2 - bound1), 2);
        //     Log.d("RANDOM FLOAT", String.valueOf(rand));
        return rand;
    }
}

