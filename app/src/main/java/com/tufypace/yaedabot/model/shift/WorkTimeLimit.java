package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public class WorkTimeLimit {
    @SerializedName("currentWeek")
    private final WeekTimeLimit currentWeek;
    @SerializedName("nextWeek")
    private final WeekTimeLimit nextWeek;

    public WorkTimeLimit(WeekTimeLimit weekTimeLimit, WeekTimeLimit weekTimeLimit2) {
        Intrinsics.checkNotNull(weekTimeLimit, "currentWeek");
        Intrinsics.checkNotNull(weekTimeLimit2, "nextWeek");
        this.currentWeek = weekTimeLimit;
        this.nextWeek = weekTimeLimit2;
    }

    public static WorkTimeLimit copy$default(WorkTimeLimit workTimeLimit, WeekTimeLimit weekTimeLimit, WeekTimeLimit weekTimeLimit2, int i, Object obj) {
        if ((i & 1) != 0) {
            weekTimeLimit = workTimeLimit.currentWeek;
        }
        if ((i & 2) != 0) {
            weekTimeLimit2 = workTimeLimit.nextWeek;
        }
        return workTimeLimit.copy(weekTimeLimit, weekTimeLimit2);
    }

    public final WeekTimeLimit component1() {
        return this.currentWeek;
    }

    public final WeekTimeLimit component2() {
        return this.nextWeek;
    }

    public final WorkTimeLimit copy(WeekTimeLimit weekTimeLimit, WeekTimeLimit weekTimeLimit2) {
        Intrinsics.checkNotNull(weekTimeLimit, "currentWeek");
        Intrinsics.checkNotNull(weekTimeLimit2, "nextWeek");
        return new WorkTimeLimit(weekTimeLimit, weekTimeLimit2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkTimeLimit)) {
            return false;
        }
        WorkTimeLimit workTimeLimit = (WorkTimeLimit) obj;
        return Intrinsics.areEqual(this.currentWeek, workTimeLimit.currentWeek) && Intrinsics.areEqual(this.nextWeek, workTimeLimit.nextWeek);
    }

    public final WeekTimeLimit getCurrentWeek() {
        return this.currentWeek;
    }

    public final WeekTimeLimit getNextWeek() {
        return this.nextWeek;
    }

    @Override
    public int hashCode() {
        WeekTimeLimit weekTimeLimit = this.currentWeek;
        int i = 0;
        int hashCode = (weekTimeLimit != null ? weekTimeLimit.hashCode() : 0) * 31;
        WeekTimeLimit weekTimeLimit2 = this.nextWeek;
        if (weekTimeLimit2 != null) {
            i = weekTimeLimit2.hashCode();
        }
        return hashCode + i;
    }

    @Override
    public String toString() {
        return "WorkTimeLimit(currentWeek=" + this.currentWeek + ", nextWeek=" + this.nextWeek + ")";
    }
}
