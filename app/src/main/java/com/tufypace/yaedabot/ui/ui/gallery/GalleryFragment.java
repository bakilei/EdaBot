package com.tufypace.yaedabot.ui.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ShiftService;
import com.tufypace.yaedabot.ui.BaseFragment;

public class GalleryFragment extends BaseFragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ShiftService clientctt = ApiClient.getClientCtt();
}