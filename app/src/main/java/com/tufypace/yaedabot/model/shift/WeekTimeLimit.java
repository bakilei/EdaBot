package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

public class WeekTimeLimit {
    @SerializedName("chosenShiftHours")
    private final double chosenShiftHours;
    @SerializedName("maxShiftHours")
    private final double maxShiftHours;
    @SerializedName("recommendedShiftHours")
    private final double recommendedShiftHours;

    public WeekTimeLimit(double d2, double d3, double d4) {
        this.maxShiftHours = d2;
        this.recommendedShiftHours = d3;
        this.chosenShiftHours = d4;
    }

    public static WeekTimeLimit copy$default(WeekTimeLimit weekTimeLimit, double d2, double d3, double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            d2 = weekTimeLimit.maxShiftHours;
        }
        double d5 = d2;
        if ((i & 2) != 0) {
            d3 = weekTimeLimit.recommendedShiftHours;
        }
        double d6 = d3;
        if ((i & 4) != 0) {
            d4 = weekTimeLimit.chosenShiftHours;
        }
        return weekTimeLimit.copy(d5, d6, d4);
    }

    public final double component1() {
        return this.maxShiftHours;
    }

    public final double component2() {
        return this.recommendedShiftHours;
    }

    public final double component3() {
        return this.chosenShiftHours;
    }

    public final WeekTimeLimit copy(double d2, double d3, double d4) {
        return new WeekTimeLimit(d2, d3, d4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeekTimeLimit)) {
            return false;
        }
        WeekTimeLimit weekTimeLimit = (WeekTimeLimit) obj;
        return Double.compare(this.maxShiftHours, weekTimeLimit.maxShiftHours) == 0 && Double.compare(this.recommendedShiftHours, weekTimeLimit.recommendedShiftHours) == 0 && Double.compare(this.chosenShiftHours, weekTimeLimit.chosenShiftHours) == 0;
    }

    public final double getChosenShiftHours() {
        return this.chosenShiftHours;
    }

    public final double getMaxShiftHours() {
        return this.maxShiftHours;
    }

    public final double getRecommendedShiftHours() {
        return this.recommendedShiftHours;
    }

    @Override
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.maxShiftHours);
        long doubleToLongBits2 = Double.doubleToLongBits(this.recommendedShiftHours);
        long doubleToLongBits3 = Double.doubleToLongBits(this.chosenShiftHours);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    @Override
    public String toString() {
        return "WeekTimeLimit(maxShiftHours=" + this.maxShiftHours + ", recommendedShiftHours=" + this.recommendedShiftHours + ", chosenShiftHours=" + this.chosenShiftHours + ")";
    }
}
