package com.tufypace.yaedabot.model.assigment;

import java.util.Objects;

public class AutoAssignmentStatus {
    public final boolean isAvailable;
    public final String reason;
    public final String typeName;

    public AutoAssignmentStatus(boolean isAvailable, String reason, String typeName) {
        this.isAvailable = isAvailable;
        this.reason = reason;
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoAssignmentStatus that = (AutoAssignmentStatus) o;
        return isAvailable == that.isAvailable &&
                reason.equals(that.reason) &&
                typeName.equals(that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAvailable, reason, typeName);
    }


}
