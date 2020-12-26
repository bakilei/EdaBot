package com.tufypace.yaedabot.model.shift;

import kotlin.jvm.internal.Intrinsics;

public class StartPointAttributes {
    private final String name;

    public StartPointAttributes(String str) {
        Intrinsics.checkFieldIsNotNull(str, "name");
        this.name = str;
    }

    public static StartPointAttributes copy$default(StartPointAttributes startPointAttributes, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = startPointAttributes.name;
        }
        return startPointAttributes.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final StartPointAttributes copy(String str) {
        Intrinsics.checkFieldIsNotNull(str, "name");
        return new StartPointAttributes(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StartPointAttributes) && Intrinsics.areEqual((Object) this.name, (Object) ((StartPointAttributes) obj).name);
        }
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "StartPointAttributes(name=" + this.name + ")";
    }
}
