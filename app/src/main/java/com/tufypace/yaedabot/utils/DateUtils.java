package com.tufypace.yaedabot.utils;

import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    public static DateTimeFormatter ISO_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
    public static final String MOSCOW_TZ = "Europe/Moscow";
    private static DateTimeZone RESTAURANT_TIMEZONE = DateTimeZone.forID(MOSCOW_TZ);
    public static final Locale RUSSIAN_LOCALE = new Locale("ru");
    private static long timeDiff;


    public static String ISOCurrentDate() {
        try {
            Log.d("ISOCurrentDate", String.valueOf(ISO_FORMATTER.print(getCorrectTime())));
            return ISO_FORMATTER.print(getCorrectTime());

            //       return d.a(str).d();
        } catch (Exception e2) {
            return "";
        }
    }

    public static String ISODate(DateTime dateTime) {
        try {
            return ISO_FORMATTER.print((ReadableInstant) dateTime);
        } catch (Exception e2) {
            //  h.a.a.b(e2);
            return "";
        }
    }

    public static String dateToString(long j, String str) {
        try {
            return DateTimeFormat.forPattern(str).withLocale(RUSSIAN_LOCALE).print(j);
        } catch (Exception e2) {
            //   h.a.a.b(e2);
            return "";
        }
    }

    public static DateTime getCorrectDateTime() {
        return DateTime.now().minus(timeDiff);
    }

    public static long getCorrectTime() {
        return DateTime.now().getMillis() + timeDiff;
    }

    public static String getCurrentDate(String str) {
        try {
            return DateTimeFormat.forPattern(str).withLocale(RUSSIAN_LOCALE).print(getCorrectTime());
        } catch (Exception e2) {
            //    h.a.a.b(e2);
            return "";
        }
    }

    public static int getDayForDate(long j) {
        try {
            return new DateTime(j).getDayOfMonth();
        } catch (Exception e2) {
            // h.a.a.b(e2);
            return 1;
        }
    }

    public static long getDeviceTime() {
        return DateTime.now().getHourOfDay();
    }

    public static long getTimeDiff() {
        return timeDiff;
    }

    public static String getTimeDiffCoefficient() {
        long abs = Math.abs(timeDiff);
        int i = (int) ((abs / 60000) % 60);
        int i2 = (int) ((abs / 3600000) % 24);
        long days = TimeUnit.MILLISECONDS.toDays(abs);
        return String.format(Locale.ENGLISH, "%d days %02d:%02d:%02d", days, i2, i, ((int) (abs / 1000)) % 60);
    }

    public static long getTimeInMoscow(String str) {
        try {
            return ISO_FORMATTER.parseDateTime(str).getDayOfMonth();
        } catch (Exception unused) {
            return DateTime.now().getCenturyOfEra();
        }
    }

    public static void restoreDefaultTimezone() {
        //      DateTimeZone.setDefault(RESTAURANT_TIMEZONE);
    }

    public static void saveTimezoneOffset(String str) {
        try {
            String[] split = str.split(":");
            if (split.length > 1) {
                String str2 = split[0];
                String str3 = split[1];
                Matcher matcher = Pattern.compile("[-0-9]+").matcher(str2);
                if (matcher.find()) {
                    str2 = matcher.group(0);
                }
                //      RESTAURANT_TIMEZONE = DateTimeZone.forOffsetHoursMinutes(Integer.parseInt(str2), Integer.parseInt(str3));
                //        DateTimeZone.setDefault(RESTAURANT_TIMEZONE);
            }
        } catch (Exception e2) {
            //    h.a.a.b(e2);
        }
    }

    public static void setTimeDiff(long j) {
        timeDiff = j;
    }

    public static String parseDateFromServer(String inputString) {
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Yekaterinburg");


        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        output.setTimeZone(timeZone);
        Date d = null;
        try {
            d = input.parse(inputString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = output.format(d);
        return formatted;
    }


    private static String[] getDaysOfWeek() {
        String[] days = new String[6];
        java.time.format.DateTimeFormatter dayOfMonthFormatter = java.time.format.DateTimeFormatter.ofPattern("dd");
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));
        // go back to Sunday, then forward 1 day to get Monday
        LocalDate day = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
                .plusDays(1);
        days[0] = day.format(dayOfMonthFormatter);
        for (int i = 1; i < 6; i++) {
            day = day.plusDays(1);
            days[i] = day.format(dayOfMonthFormatter);
        }
        return days;
    }

}
