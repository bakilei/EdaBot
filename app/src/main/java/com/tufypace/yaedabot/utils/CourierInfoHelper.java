package com.tufypace.yaedabot.utils;

import android.graphics.Color;

public class CourierInfoHelper {

    public static String courierStatus(String status) {
        switch (status) {
            case "active": {
                return "Активен";
            }
            case "blocked": {
                return "Заблокирован";
            }
            case "ill": {
                return "Болен";
            }

            case "inactive": {
                return "Неактивен";
            }
            case "candidate": {
                return "Кандидат";
            }
            case "on_vacation": {
                return "В отпуске";
            }
            default: {
                return " ";
            }
        }


    }

    public static int colorCourierStatus(String status) {
        switch (status) {
            case "active": {
                return Color.GREEN;
            }
            case "blocked": {
                return Color.RED;
            }
            case "ill": {
                return Color.BLUE;
            }

            case "inactive": {
                return Color.RED;
            }
            case "candidate": {
                return Color.YELLOW;
            }
            case "on_vacation": {
                return Color.CYAN;
            }
            default: {
                return Color.BLACK;
            }
        }
    }

    public static String courierType(String type) {
        switch (type) {
            case "pedestrian": {
                return "Ходит пешком";
            }
            case "bicycle": {
                return "Гоняет на велосипеде";
            }
            case "vehicle": {
                return "Гоняет на машине";
            }

            case "motorcycle": {
                return "Гоняет на мотоцикле";
            }

            default: {
                return "";
            }
        }
    }

    public static String courierBillingType(String type) {
        if (type.equals("courier_service")) {
            return "Курьерская служба";
        } else if (type.equals("self_employed")) {
            return "Самозанятый";
        }
        return "";
    }


}

