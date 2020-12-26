package com.tufypace.yaedabot.ui.zakaz.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.order.OrderModel;

import java.util.ArrayList;
import java.util.List;


public class ZakazListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ZakazListAdapter.OnClickZakazLictener monClickZakazListener;
    public ArrayList<OrderModel> mOrderList = new ArrayList<>();

    public ZakazListAdapter(OnClickZakazLictener monClickZakazListener, List<OrderModel> mOrderList) {
        //      this.monClickZakazListener = monClickZakazListener;
        //      this.mOrderList = mOrderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ZakazItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zakaz, parent, false), monClickZakazListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ZakazItemViewHolder) holder).onBind(this.mOrderList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mOrderList.size();
    }

    public void setZakazList(List<OrderModel> list, ZakazListAdapter.OnClickZakazLictener onClickOrderLictener) {
        this.mOrderList.clear();
        this.mOrderList.addAll(list);
        this.monClickZakazListener = onClickOrderLictener;
        notifyDataSetChanged();
    }


    public interface OnClickZakazLictener {
        void Onclick(int position);
    }
}
