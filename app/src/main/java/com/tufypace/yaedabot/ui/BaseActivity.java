package com.tufypace.yaedabot.ui;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.metrica.MetricaHandler;

public class BaseActivity extends AppCompatActivity {

    MetricaHandler metricaHandler;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

    }

    @Override
    public void onBackPressed() {
        if (!fragmentGoBack()) {
            super.onBackPressed();
        }
    }

    public void showTextToast(final String str) {
        if (!isFinishing()) {
            runOnUiThread(() -> {
                //     Toast.makeText(this, str, 0).show();
            });
        }
    }

    public void showFragment(String str) {
        showFragment(str, true);
    }

    public void showFragment(String str, Bundle bundle) {
        showFragment(str, true, false, bundle);
    }

    public void showFragmentAndClearBackStack(String str, Bundle bundle) {
        showFragment(str, true, true, bundle);
    }

    public void showFragment(String str, boolean z) {
        showFragment(str, z, false, (Bundle) null);
    }

    public void showFragment(String str, boolean z, boolean z2, Bundle bundle) {
        if (!isFinishing()) {
            try {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                if (z2 && supportFragmentManager.getBackStackEntryCount() >= 1) {
                    supportFragmentManager.popBackStack(supportFragmentManager.getBackStackEntryAt(0).getId(), 1);
                }
                BaseFragment fragmentByTag = FragmentFactory.getFragmentByTag(str);
                beginTransaction.replace(R.id.fragment_container_layout, fragmentByTag, str);
                if (bundle != null) {
                    fragmentByTag.setArguments(bundle);
                }
                if (z) {
                    beginTransaction.addToBackStack(str);
                }
                beginTransaction.commitAllowingStateLoss();
            } catch (IllegalStateException unused) {
                recreate();
            }
        }
    }

    public void screenPopBackStack(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (!isFinishing() && supportFragmentManager.getBackStackEntryCount() > 0 && !supportFragmentManager.isStateSaved()) {
            hideKeyboard();
            if (str != null) {
                showFragment(str, false);
            } else {
                supportFragmentManager.popBackStack();
            }
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && (inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private boolean fragmentGoBack() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container_layout);
        return (findFragmentById instanceof BaseFragment) && ((BaseFragment) findFragmentById).onBackPressed();
    }

}
