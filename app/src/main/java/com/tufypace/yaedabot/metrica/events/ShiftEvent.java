package com.tufypace.yaedabot.metrica.events;

import java.util.HashMap;

import kotlin.jvm.internal.Intrinsics;

public final class ShiftEvent implements Event {
    private final int shiftId;
    private final String title;

    public ShiftEvent(String str, int i) {
        Intrinsics.checkNotNull(str, "title");
        this.title = str;
        this.shiftId = i;
    }

    public String getTitle() {
        return this.title;
    }

    public HashMap<String, Object> getAttrs() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("shiftId", this.shiftId);
        return hashMap;
    }
}
