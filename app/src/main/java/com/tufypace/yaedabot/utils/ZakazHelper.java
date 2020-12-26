package com.tufypace.yaedabot.utils;

public class ZakazHelper {

    public static String zakazChangeState(String status) {
        switch (status) {
            case "taken": {
                return "arriveToClient";
            }
            case "arrivedToClient": {
                return "deliver";
            }
            case "new": {
                return "accept";
            }

            case "arrivedToRestaurant": {
                return "take";
            }
            case "accepted": {
                return "arriveToRestaurant";
            }

            default: {
                return " ";
            }
        }


    }

    public static String zakazStatusButton(String status) {
        switch (status) {
            case "taken": {
                return "Прибыл к клиенту";
            }
            case "arrivedToClient": {
                return "Отдал заказ";
            }
            case "new": {
                return "Принять в работу";
            }

            case "arrivedToRestaurant": {
                return "Забрал заказ";
            }
            case "accepted": {
                return "Прибыл в ресторан";
            }

            default: {
                return " ";
            }
        }


    }

    public static String zakazStatusString(String status) {
        if (status.equals("taken")) {
            return "Прибыть к клиенту";
        } else if (status.equals("new") || status.equals("accepted")) {
            return "Прибыть в ресторан";
        } else if (status.equals("arrivedToRestaurant")) {
            return "Забрать заказ";
        } else if (status.equals("arrivedToClient")) {
            return "Передать заказ";
        } else {
            return "";
        }


    }

    public static double changeLatitudeRestoraunt(double latitude) {

        double change = latitude + 0.135;

        return change;
    }

    public static double changeLongitudeRestoraunt(double longitude) {

        double change = longitude + 0.135;

        return change;
    }

    public static double randomLongitude(double longitude) {
        double change = longitude + 0.000006;
        return change;
    }

    public static double randomLatitude(double latitude) {
        double change = latitude + 0.000006;
        return change;
    }
}
