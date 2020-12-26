package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public class ShiftSettingsAttributes {
    @SerializedName("shiftPullToRefreshCacheTime")
    private final long shiftPullToRefreshCacheTime;
    @SerializedName("shiftRefuseMaxTime")
    private final String shiftRefuseMaxTime;
    @SerializedName("shiftsMinInterval")
    private final int shiftsMinInterval;
    @SerializedName("workTimeLimit")
    private final WorkTimeLimit workTimeLimit;

    public ShiftSettingsAttributes(int i, String timeModel, long j, WorkTimeLimit workTimeLimit2) {
        Intrinsics.checkNotNull(timeModel, "shiftRefuseMaxTime");
        Intrinsics.checkNotNull(workTimeLimit2, "workTimeLimit");
        this.shiftsMinInterval = i;
        this.shiftRefuseMaxTime = timeModel;
        this.shiftPullToRefreshCacheTime = j;
        this.workTimeLimit = workTimeLimit2;
    }

    public static ShiftSettingsAttributes copy$default(ShiftSettingsAttributes shiftSettingsAttributes, int i, String timeModel, long j, WorkTimeLimit workTimeLimit2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shiftSettingsAttributes.shiftsMinInterval;
        }
        if ((i2 & 2) != 0) {
            timeModel = shiftSettingsAttributes.shiftRefuseMaxTime;
        }
        String timeModel2 = timeModel;
        if ((i2 & 4) != 0) {
            j = shiftSettingsAttributes.shiftPullToRefreshCacheTime;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            workTimeLimit2 = shiftSettingsAttributes.workTimeLimit;
        }
        return shiftSettingsAttributes.copy(i, timeModel2, j2, workTimeLimit2);
    }

    public final int component1() {
        return this.shiftsMinInterval;
    }

    public final String component2() {
        return this.shiftRefuseMaxTime;
    }

    public final long component3() {
        return this.shiftPullToRefreshCacheTime;
    }

    public final WorkTimeLimit component4() {
        return this.workTimeLimit;
    }

    public final ShiftSettingsAttributes copy(int i, String timeModel, long j, WorkTimeLimit workTimeLimit2) {
        Intrinsics.checkNotNull(timeModel, "shiftRefuseMaxTime");
        Intrinsics.checkNotNull(workTimeLimit2, "workTimeLimit");
        return new ShiftSettingsAttributes(i, timeModel, j, workTimeLimit2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ShiftSettingsAttributes) {
                ShiftSettingsAttributes shiftSettingsAttributes = (ShiftSettingsAttributes) obj;
                if ((this.shiftsMinInterval == shiftSettingsAttributes.shiftsMinInterval) && Intrinsics.areEqual(this.shiftRefuseMaxTime, shiftSettingsAttributes.shiftRefuseMaxTime)) {
                    if (!(this.shiftPullToRefreshCacheTime == shiftSettingsAttributes.shiftPullToRefreshCacheTime) || !Intrinsics.areEqual(this.workTimeLimit, shiftSettingsAttributes.workTimeLimit)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getShiftPullToRefreshCacheTime() {
        return this.shiftPullToRefreshCacheTime;
    }

    public final String getShiftRefuseMaxTime() {
        return this.shiftRefuseMaxTime;
    }

    public final int getShiftsMinInterval() {
        return this.shiftsMinInterval;
    }

    public final WorkTimeLimit getWorkTimeLimit() {
        return this.workTimeLimit;
    }

    @Override
    public int hashCode() {
        int i = this.shiftsMinInterval * 31;
        String timeModel = this.shiftRefuseMaxTime;
        int i2 = 0;
        int hashCode = timeModel != null ? timeModel.hashCode() : 0;
        long j = this.shiftPullToRefreshCacheTime;
        int i3 = (((i + hashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        WorkTimeLimit workTimeLimit2 = this.workTimeLimit;
        if (workTimeLimit2 != null) {
            i2 = workTimeLimit2.hashCode();
        }
        return i3 + i2;
    }

    @Override
    public String toString() {
        return "ShiftSettingsAttributes(shiftsMinInterval=" + this.shiftsMinInterval + ", shiftRefuseMaxTime=" + this.shiftRefuseMaxTime + ", shiftPullToRefreshCacheTime=" + this.shiftPullToRefreshCacheTime + ", workTimeLimit=" + this.workTimeLimit + ")";
    }
}
