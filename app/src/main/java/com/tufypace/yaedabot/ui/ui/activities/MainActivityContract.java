package com.tufypace.yaedabot.ui.ui.activities;

import com.tufypace.yaedabot.model.assigment.AutoAssignmentStatus;
import com.tufypace.yaedabot.ui.ui.activities.mvp.MvpPresenter;
import com.tufypace.yaedabot.ui.ui.activities.mvp.MvpView;

import java.util.List;

public class MainActivityContract {
    public interface Presenter extends MvpPresenter<View> {
        void acceptChangingShift(String str);

        void acceptChangingShiftIgnoringWarnings(String str);

        void allowPermissions(String str);

        void changeCourierState(String str);

        void clickGoToMyTaxApp();

        void clickUpdateAssignmentReasons();

        void loadDrawerPages(int i);

        void onBalanceClicked();

        void onClickNotifications();

        void onDebugClicked();

        void onDynamicItemClicked(int i);

        void onForegroundNotificationClicked();

        void onGpsResolutionResult(boolean z);

        void onInfoPagesClicked();

        void onLogoutClicked();

        void onNotificationOrderClicked(String str, String str2);

        void onNotificationShiftChangesClicked(String str, List<Integer> list);

        void onNotificationShiftClicked();

        void onOrdersClicked();

        void onPreferencesClicked();

        void onProfileClicked();

        void onShiftsClicked();

        void stopLocationAnnounce();
    }

    public interface View extends MvpView {
        void hideBlockView();

        void hideSelfEmployedPermissionDenied();

        void hideShiftConfirmationDialog();

        void initPausedMenu(boolean z, boolean z2);

        void initStartedMenu(boolean z, boolean z2);

        void initStoppedMenu(boolean z);

        void requestCameraPermission();

        void selectNotificationDrawerItem();

        void selectOrdersDrawerItem();

        void selectShiftsDrawerItem();

        void showBlockView(int i);

        void showInternetConnectionError(boolean z);

        void showLocationAnnouncement();

        void showLogoutError();

        void showProfile(String str, String str2);

        void showSelfEmployedPermissionDenied(AutoAssignmentStatus autoAssignmentStatus);

        void showServerError();

        void showShiftConfirmationDialog(String str);

        void showStartShiftConfirmationDialog(String str, String str2, String str3, int i);

        //    void showStaticPagesInDrawer(List<DrawerItem> list);

        void showStopShiftSuccess();

        void showTimezoneAlertView();

        void showUnplannedDialog();

        void showWarningMessage(String str);

        void showWarningShiftConfirmationDialog(String str, String str2);
    }
}
