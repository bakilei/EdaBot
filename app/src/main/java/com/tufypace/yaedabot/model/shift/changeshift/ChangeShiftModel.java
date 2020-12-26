package com.tufypace.yaedabot.model.shift.changeshift;

import com.tufypace.yaedabot.model.shift.OpenedCourierShift;

public final class ChangeShiftModel {
    public final boolean isChecked;
    public final OpenedCourierShift openedCourierShift;

    public ChangeShiftModel(boolean isChecked, OpenedCourierShift openedCourierShift) {
        this.isChecked = isChecked;
        this.openedCourierShift = openedCourierShift;
    }
}
