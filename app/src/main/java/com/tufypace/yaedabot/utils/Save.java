package com.tufypace.yaedabot.utils;

import com.tufypace.yaedabot.model.Coordinate;
import com.tufypace.yaedabot.model.courierinfo.CourierInfo;
import com.tufypace.yaedabot.model.request.ShiftLocation;

public class Save {
    public static String api = "";

    public static String getApi() {
        if (api != null) {
            return api;

        }
        return "";
    }

    public static void setApi(String api) {
        Save.api = api;
    }

    public static final String APP_METRICA_KEY = "d98c2558-1e7f-4c41-84bd-a3425ca99d3f";
    public static final String HISTOGRAM_PULSE = "AEDACOURIER";
//    public static final double sleep_latitude = 57.114561;

    //вернуть
    // public static final double sleep_latitude = 57.122811;

    //ухм
    public static final double sleep_latitude = 57.196995;

//    public static final double sleep_longitude = 65.636479;

    //вернуть
    // public static final double sleep_longitude = 65.654510;

    //ухм
    public static final double sleep_longitude = 65.581274;


    public static int code_centr = 5801;
    public static int code_uhm = 5822;
    public static int code_kpd = 5804;
    public static int code_vostok = 5810;
    public static final ShiftLocation un_eye = new ShiftLocation(57.120523, 65.610119);

    public static CourierInfo courier;


    public enum LocationDelayStatus {
        COURIER_ONLINE,
        COURIER_OFFLINE
    }


    public static Coordinate shaurma_na_fabrichnoj = new Coordinate(57.147277, 65.56002, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate bk_repub155 = new Coordinate(57.138042, 65.570287, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate subway_tul = new Coordinate(57.133324, 65.580169, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate balkangril_50_let_oktyabrya_3k1 = new Coordinate(57.153102, 65.568922, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate desert_oktyabrya = new Coordinate(57.141295, 65.590706, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate stolovaya_borshh_melnikajte_101a = new Coordinate(57.139048, 65.572075, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate pecarnya_mamin_xleb = new Coordinate(57.136631, 65.571051, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate kaco_gercena = new Coordinate(57.146051, 65.541946, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate mcd_tore4 = new Coordinate(57.14694, 65.549231, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate restoranchik_tandyr = new Coordinate(57.139849, 65.547389, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate bk_gor70 = new Coordinate(57.148849, 65.559867, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate mcd_leni54 = new Coordinate(57.152077, 65.537463, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate subway_res = new Coordinate(57.16079, 65.524779, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate sluzhba_dostavki_maksim_respubliki_129 = new Coordinate(57.161083, 65.492799, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate andersontumen = new Coordinate(57.157134, 65.559031, Utils.randFloat(1, 99), false, "fused");

    public static Coordinate shaurma_na_fabrichnoj_fabrichnaya_1 = new Coordinate(57.147277, 65.56002, Utils.randFloat(1, 99), false, "fused");
    //
    public static Coordinate kofejnya_redberry_ordzhonikidze_63a = new Coordinate(57.148674, 65.541416, Utils.randFloat(1, 99), false, "fused");

    //Кофейня максим на семакова
    public static Coordinate coffemaxim_resp = new Coordinate(57.157915, 65.530465, Utils.randFloat(1, 99), false, "fused");

    // Харьковская 57
    public static Coordinate aleksandr_xarkovskaya_57 = new Coordinate(57.150099, 65.583043, Utils.randFloat(1, 99), false, "fused");

    // 50 лет октября 44
    public static Coordinate vilki_net = new Coordinate(57.144591, 65.581822, Utils.randFloat(1, 99), false, "fused");


}
