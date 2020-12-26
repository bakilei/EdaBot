package com.tufypace.yaedabot.model.order;

import java.util.Objects;

public class Time {

    public long time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time1 = (Time) o;
        return time == time1.time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Time() {

    }


    public Time(long j) {
        this.time = j;
    }
}
