package com.tufypace.yaedabot.ui;

import com.tufypace.yaedabot.ui.dashboard.OrderFragment;
import com.tufypace.yaedabot.ui.getslots.GetslotsFragment;
import com.tufypace.yaedabot.ui.hunter.HunterFragment;
import com.tufypace.yaedabot.ui.login.LoginFragment;
import com.tufypace.yaedabot.ui.nakrutka.NakrutkaFragment;
import com.tufypace.yaedabot.ui.profile.ProfileFragment;
import com.tufypace.yaedabot.ui.restoraunt.RestorauntFragment;
import com.tufypace.yaedabot.ui.zakaz.ZakazFragment;

public class FragmentFactory {
    static BaseFragment getFragmentByTag(String str) {
        switch (str) {
            case "OrderFragment":
                return new OrderFragment();
            case "LoginFragment":
                return new LoginFragment();
            case "ZakazFragment":
                return new ZakazFragment();
            case "ProfileFragment":
                return new ProfileFragment();
            case "GetslotsFragment":
                return new GetslotsFragment();
            case "HunterFragment":
                return new HunterFragment();
            case "RestorauntFragment":
                return new RestorauntFragment();
            case "NakrutkaFragment":
                return new NakrutkaFragment();
            default:
                throw new IllegalArgumentException("You are trying to get undefined fragment");

        }

    }
}
