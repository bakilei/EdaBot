package com.tufypace.yaedabot.model.order;

import kotlin.jvm.internal.Intrinsics;

public class OrdersMeta {

    public int count;

    public Time courierBlockedUntil;


    public final int component1() {
        return this.count;
    }

    public final Time component2() {
        return this.courierBlockedUntil;
    }


    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OrdersMeta) {
                OrdersMeta ordersMeta = (OrdersMeta) obj;
                if (!(this.count == ordersMeta.count) || !Intrinsics.areEqual((Object) this.courierBlockedUntil, (Object) ordersMeta.courierBlockedUntil)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final Time getCourierBlockedUntil() {
        return this.courierBlockedUntil;
    }

    @Override
    public int hashCode() {
        int i = this.count * 31;
        Time time = this.courierBlockedUntil;
        return i + (time != null ? time.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "OrdersMeta(count=" + this.count + ", courierBlockedUntil=" + this.courierBlockedUntil + ")";
    }
}
