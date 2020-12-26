package com.tufypace.yaedabot.ui.adapters.slot;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.ui.dashboard.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class SlotListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public SlotListAdapter.OnClickSlotLictener monClickOrderLictener;
    public ArrayList<OpenedCourierShift> mOpenedShiftList = new ArrayList<>();


    public SlotListAdapter(List<OpenedCourierShift> courierShifts, OrderFragment onClickSlotLictener) {

    }

    public SlotListAdapter(ArrayList<OpenedCourierShift> mOpenedShiftList, SlotListAdapter.OnClickSlotLictener onClickOrderLictener) {
        this.mOpenedShiftList = mOpenedShiftList;
        this.monClickOrderLictener = onClickOrderLictener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlotItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_open_slot, parent, false), monClickOrderLictener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SlotItemViewHolder) holder).onBind(this.mOpenedShiftList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mOpenedShiftList.size();
    }


    public void setSlotList(List<OpenedCourierShift> list, SlotListAdapter.OnClickSlotLictener onClickOrderLictener) {
        this.mOpenedShiftList.clear();
        this.mOpenedShiftList.addAll(list);
        this.monClickOrderLictener = onClickOrderLictener;
        notifyDataSetChanged();
    }


    public interface OnClickSlotLictener {
        void OnclickSlot(int position);

        void OnClickItemSlot(int position);
    }
}
