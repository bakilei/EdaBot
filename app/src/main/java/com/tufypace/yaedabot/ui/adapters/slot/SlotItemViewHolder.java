package com.tufypace.yaedabot.ui.adapters.slot;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.utils.DateUtils;

public class SlotItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final TextView tv_open_slot_start_at, tv_open_slot_end_at;
    public final Button bt_open_slot_give;

    public SlotListAdapter.OnClickSlotLictener onClickOrderLictener;

    public SlotItemViewHolder(@NonNull View itemView, SlotListAdapter.OnClickSlotLictener onClickOrderLictener) {
        super(itemView);
        this.onClickOrderLictener = onClickOrderLictener;
        itemView.setOnClickListener(this);
        this.tv_open_slot_start_at = (TextView) itemView.findViewById(R.id.tv_open_slot_start_at);
        this.tv_open_slot_end_at = (TextView) itemView.findViewById(R.id.tv_open_slot_end_at);
        this.bt_open_slot_give = (Button) itemView.findViewById(R.id.bt_open_slot_give);


    }

    private void bindStartAt(String str) {
        this.tv_open_slot_start_at.setText(String.format("%s", str));
    }

    private void bindEndAt(String str) {
        this.tv_open_slot_end_at.setText(String.format("%s", str));
    }

    private void clickGiveButton() {

        onClickOrderLictener.OnClickItemSlot(getAdapterPosition());

    }

    public void onBind(OpenedCourierShift friendship) {
        bindStartAt(DateUtils.parseDateFromServer(friendship.getAttributes().getStartsAt()));
        bindEndAt(DateUtils.parseDateFromServer(friendship.getAttributes().getEndsAt()));
        //     clickGiveButton();
        bt_open_slot_give.setOnClickListener(view -> clickGiveButton());
    }

    @Override
    public void onClick(View v) {
        onClickOrderLictener.OnclickSlot(getAdapterPosition());
        Log.d("ONCLICK ITEM ", String.valueOf(getAdapterPosition()));
    }


}
