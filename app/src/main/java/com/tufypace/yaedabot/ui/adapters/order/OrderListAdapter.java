package com.tufypace.yaedabot.ui.adapters.order;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.ui.dashboard.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public OnClickOrderLictener monClickOrderLictener;
    public ArrayList<CourierShift> mFriendshipList = new ArrayList<>();

    public OrderListAdapter(ArrayList<CourierShift> mFriendshipList, OnClickOrderLictener onClickOrderLictener) {
        this.mFriendshipList = mFriendshipList;
        this.monClickOrderLictener = onClickOrderLictener;
    }

    public OrderListAdapter(List<CourierShift> courierShifts, OrderFragment onClickOrderLictener) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false), monClickOrderLictener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((OrderItemViewHolder) holder).onBind(this.mFriendshipList.get(position));


    }

    @Override
    public int getItemCount() {
        return this.mFriendshipList.size();
    }

    public void setoRDERList(List<CourierShift> list, OnClickOrderLictener onClickOrderLictener) {
        this.mFriendshipList.clear();
        this.mFriendshipList.addAll(list);
        this.monClickOrderLictener = onClickOrderLictener;
        notifyDataSetChanged();
    }


    public interface OnClickOrderLictener {
        void Onclick(int position);
    }
}
