package com.tufypace.yaedabot.ui.adapters.order;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.utils.DateUtils;

public class OrderItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView text_start_at;
    public final TextView text_end_at;
    OrderListAdapter.OnClickOrderLictener onClickOrderLictener;

    public OrderItemViewHolder(@NonNull View itemView, OrderListAdapter.OnClickOrderLictener onClickOrderLictener) {
        super(itemView);
        this.onClickOrderLictener = onClickOrderLictener;
        itemView.setOnClickListener(this);
        this.text_start_at = (TextView) itemView.findViewById(R.id.text_start_at);
        this.text_end_at = (TextView) itemView.findViewById(R.id.tv_zakaz_name_restoran);

    }

    private void bindStartAt(String str) {
        this.text_start_at.setText(String.format("%s", str));
    }

    private void bindEndAt(String str) {
        this.text_end_at.setText(String.format("%s", str));
    }

    public void onBind(CourierShift friendship) {
        bindStartAt(DateUtils.parseDateFromServer(friendship.getAttributes().startsAt));
        bindEndAt(DateUtils.parseDateFromServer(friendship.getAttributes().endsAt));

     /*   User friendUser = friendship.getFriendUser(this.currentUser);
        if (friendUser != null) {
            setupListeners(friendship);
            boolean z = true;
            bindOnlineIndicator(friendUser.getIsOnline().intValue() != 0);
            bindProfilePic(friendUser);
            bindUserName(friendUser.getUsername());
            bindRoomUserPlaying(friendship.getRoomUserPlaying(), friendship.getAccepted().intValue() != 0);
            bindLastMessageTime(friendship.getUpdated().longValue());
            if (friendship.getAccepted().intValue() == 0) {
                z = false;
            }
            bindAddFriendButton(z);
            bindNewMessagesLabel(friendship.getNewMessages().intValue());
        }*/
    }

    @Override
    public void onClick(View v) {
        onClickOrderLictener.Onclick(getAdapterPosition());
        Log.d("ONCLICK ITEM ", String.valueOf(getAdapterPosition()));
    }
}
