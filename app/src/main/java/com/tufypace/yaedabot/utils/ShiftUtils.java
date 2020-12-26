package com.tufypace.yaedabot.utils;

import android.util.Log;

import com.tufypace.yaedabot.model.request.ShiftLocation;
import com.tufypace.yaedabot.model.request.ShiftOperation;
import com.tufypace.yaedabot.model.shift.CourierShift;

import java.util.Random;
import java.util.UUID;

public class ShiftUtils {
    public ShiftOperation shiftOperation;


    public ShiftOperation getShiftOperationByRegionWork(CourierShift courierShift) {
        String uuid = UUID.randomUUID().toString();
        switch (courierShift.getAttributes().startPoint.getId()) {
            case "5801":
                Log.d("РАЙОН", "цЕНТР");
                double rangeLongitudeMinCentr = 65.541230;
                double rangeLongitudeMaxCentr = 65.541261;

                double rangeLatitudeMinCent = 57.148510;
                double rangeLatitudeMaxCentr = 57.148544;
                Random r = new Random();
                double randomLatitudeCentr = rangeLatitudeMinCent + (rangeLatitudeMaxCentr - rangeLatitudeMinCent) * r.nextDouble();
                double randomLongitudeCentr = rangeLongitudeMinCentr + (rangeLongitudeMaxCentr - rangeLongitudeMinCentr) * r.nextDouble();


                Log.d(String.valueOf(randomLatitudeCentr), String.valueOf(randomLongitudeCentr));
                shiftOperation = new ShiftOperation(uuid, new ShiftLocation(randomLatitudeCentr, randomLongitudeCentr), true);
                return shiftOperation;
            case "5804":
                Log.d("РАЙОН", "КПД");
                double rangeLongitudeMinKpd = 65.549221;
                double rangeLongitudeMaxKpd = 65.549241;

                double rangeLatitudeMinKpd = 57.146930;
                double rangeLatitudeMaxKpd = 57.146950;
                r = new Random();
                double randomLatitudeKpd = rangeLatitudeMinKpd + (rangeLatitudeMaxKpd - rangeLatitudeMinKpd) * r.nextDouble();
                double randomLongitudeKpd = rangeLongitudeMinKpd + (rangeLongitudeMaxKpd - rangeLongitudeMinKpd) * r.nextDouble();


                Log.d(String.valueOf(randomLatitudeKpd), String.valueOf(randomLongitudeKpd));
                shiftOperation = new ShiftOperation(uuid, new ShiftLocation(randomLatitudeKpd, randomLongitudeKpd), true);
                return shiftOperation;
            case "5822":
                Log.d("Район", "УХМ");

                Random random = new Random();
                double randomLatitudeUhm = 57.172824 + (57.172849 - 57.172824) * random.nextDouble();
                double randomLongitudeUhm = 65.566901 + (65.566925 - 65.566901) * random.nextDouble();
                Log.d(String.valueOf(randomLatitudeUhm), String.valueOf(randomLongitudeUhm));
                shiftOperation = new ShiftOperation(uuid, new ShiftLocation(randomLatitudeUhm, randomLongitudeUhm), true);
                return shiftOperation;
            case "5810":
                Log.d("Район", "Восточка");
                random = new Random();
                double randomLatitudeVost = 57.120172 + (57.120192 - 57.120172) * random.nextDouble();
                double randomLongitudeVost = 65.578003 + (65.578023 - 65.578003) * random.nextDouble();
                Log.d(String.valueOf(randomLatitudeVost), String.valueOf(randomLongitudeVost));
                shiftOperation = new ShiftOperation(uuid, new ShiftLocation(randomLatitudeVost, randomLongitudeVost), true);
                return shiftOperation;
            default:
                return shiftOperation;
        }
    }


}
