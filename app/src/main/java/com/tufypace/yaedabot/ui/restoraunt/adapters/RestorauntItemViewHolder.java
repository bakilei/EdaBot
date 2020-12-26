package com.tufypace.yaedabot.ui.restoraunt.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.restoraunt.Carousel;

public class RestorauntItemViewHolder extends RecyclerView.ViewHolder {
    public final TextView tv_name_restoraunt;
    public final TextView tv_km_restoraunt;


    public RestorauntItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tv_name_restoraunt = (TextView) itemView.findViewById(R.id.tv_name_restoraunt);
        this.tv_km_restoraunt = (TextView) itemView.findViewById(R.id.tv_km_restoraunt);
    }

    private void bindNameRestoraunt(String str) {
        this.tv_name_restoraunt.setText(String.format("%s", str));
    }

    private void bindKmRestoraunt(String str) {
        this.tv_km_restoraunt.setText(String.format("%s", str));
    }

    public void onBind(Carousel carousel) {
        bindNameRestoraunt(carousel.place.getName());
        bindKmRestoraunt(String.valueOf(carousel.locationParams.distance));

    }


}
