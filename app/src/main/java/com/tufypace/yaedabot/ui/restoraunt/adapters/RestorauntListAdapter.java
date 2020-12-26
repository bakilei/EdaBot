package com.tufypace.yaedabot.ui.restoraunt.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.restoraunt.Carousel;

import java.util.ArrayList;
import java.util.List;

public class RestorauntListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<Carousel> carousels = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RestorauntItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restoraunt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RestorauntItemViewHolder) holder).onBind(this.carousels.get(position));
    }

    @Override
    public int getItemCount() {
        return this.carousels.size();
    }

    public void setRestorauntList(List<Carousel> list) {
        this.carousels.clear();
        this.carousels.addAll(list);
        notifyDataSetChanged();
    }
}
