package com.tufypace.yaedabot.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    protected String mToolbarSubtitle;
    protected String mToolbarTitle;

    public boolean onBackPressed() {
        return false;
    }


    public BaseFragment() {
    }

    public BaseFragment(int i) {
        super(i);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //     this.mToolbarSubtitle = null;
        //    this.mToolbarTitle = getString(2131689509);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        //    setToolbarTitle(this.mToolbarTitle);
        //    setToolbarSubTitle(this.mToolbarSubtitle);
        //    setToolbarState(ToolbarState.SHOW_NAVIGATION_BACK);
        //   setToolbarState(ToolbarState.HIDE_ALL_BUTTONS);
        //    ImageView imageView = (ImageView) view.findViewById(2131296561);
        //   if (imageView != null) {
        //       ImageUtils.loadImage(getContext(), 2131230830, imageView);
        //   }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    public void showFragment(String str) {
        showFragment(str, true);
    }

    public void showFragment(String str, Bundle bundle) {
        showFragment(str, true, false, bundle);
    }

    public void showFragment(String str, boolean z) {
        showFragment(str, z, false, (Bundle) null);
    }

    public void showFragment(String str, boolean z, boolean z2) {
        showFragment(str, z, z2, (Bundle) null);
    }

    public void showFragment(String str, boolean z, boolean z2, Bundle bundle) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showFragment(str, z, z2, bundle);
        }
    }

    public void screenPopBackStack(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.screenPopBackStack(str);
        }
    }

    public void hideKeyboard() {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.hideKeyboard();
        }
    }

    public void setToolbarState(ToolbarState toolbarState) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.setToolbarState(toolbarState);
        }
    }
}

