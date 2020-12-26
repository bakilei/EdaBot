package com.tufypace.yaedabot.ui.zakaz.adapters;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.order.ApiOrderModel;
import com.tufypace.yaedabot.model.order.OrderModel;
import com.tufypace.yaedabot.model.order.OrderTransition;
import com.tufypace.yaedabot.utils.DateUtils;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.ZakazHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ZakazItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final TextView statusZakaz, tv_zakaz_adres_restoraunt, tv_delivery_to_restoraunt, tv_zakaz_name_restoran, text_created_at, tv_zakaz_adress_client, tv_delivery_date_time, tv_max_arrive_to_customer_at, tv_max_arrive_to_place_at;
    public final Button buttonStatus;

    public ZakazListAdapter.OnClickZakazLictener onClickZakazLictener;

    public ZakazItemViewHolder(@NonNull View itemView, ZakazListAdapter.OnClickZakazLictener onClickZakazLictener) {
        super(itemView);
        this.onClickZakazLictener = onClickZakazLictener;
        itemView.setOnClickListener(this);
        this.text_created_at = itemView.findViewById(R.id.text_start_at);
        this.tv_zakaz_name_restoran = itemView.findViewById(R.id.tv_zakaz_name_restoran);
        this.statusZakaz = itemView.findViewById(R.id.tv_zakaz_status);
        this.tv_zakaz_adres_restoraunt = itemView.findViewById(R.id.tv_zakaz_adres_restoraunt);
        this.tv_delivery_to_restoraunt = itemView.findViewById(R.id.tv_delivery_to_restoraunt);
        this.buttonStatus = itemView.findViewById(R.id.button_zakaz);
        this.tv_zakaz_adress_client = itemView.findViewById(R.id.tv_zakaz_adress_client);
        this.tv_delivery_date_time = itemView.findViewById(R.id.tv_delivery_date_time);
        this.tv_max_arrive_to_customer_at = itemView.findViewById(R.id.tv_max_arrive_to_customer_at);
        this.tv_max_arrive_to_place_at = itemView.findViewById(R.id.tv_max_arrive_to_place_at);
    }

    private void bindDeliveryToRestoraunt(String str) {
        this.tv_delivery_to_restoraunt.setText(String.format("%s", str));
    }

    private void bindCreatedAt(String str) {
        this.text_created_at.setText(String.format("%s", str));
    }

    private void bindRestaurantName(String str) {
        this.tv_zakaz_name_restoran.setText(String.format("%s", str));
    }

    private void bindRestaurantAdres(String str) {
        this.tv_zakaz_adres_restoraunt.setText(String.format("%s", str));
    }

    private void bindAdressClient(String str) {
        this.tv_zakaz_adress_client.setText(String.format("%s", str));
    }

    private void bindDeliveryDateTime(String str) {
        this.tv_delivery_date_time.setText(String.format("%s", str));
    }

    private void bindtArrivePlace(String str) {
        this.tv_max_arrive_to_place_at.setText(String.format("%s", str));
    }

    private void bindMaxArriveToCustomer(String str) {
        this.tv_max_arrive_to_customer_at.setText(String.format("%s", str));
    }

    private void bindStatus(String str) {
        this.statusZakaz.setText(String.format("%s", str));
    }

    public void onBind(OrderModel orderModel) {
        bindCreatedAt(DateUtils.parseDateFromServer(orderModel.createdAt));
        //bindEndAt(DateUtils.parseDateFromServer(String.valueOf(orderModel.maxArriveToPlaceAt)));
        bindRestaurantName(orderModel.restaurant.name);
        bindStatus(ZakazHelper.zakazStatusString(orderModel.status));

        Log.d(orderModel.restaurant.name, orderModel.createdAt + " к ресторану  " + orderModel.toRestDateTime + " delivery time " + orderModel.deliveryDateTime + " delivery fee " + orderModel.deliveryFee + " maxArriveToCustomerAt " + orderModel.maxArriveToCustomerAt + " maxArriveToPlaceAt " + orderModel.maxArriveToPlaceAt);

        bindRestaurantAdres(orderModel.restaurant.address.title);
        bindDeliveryToRestoraunt(orderModel.toRestDateTime);
        bindAdressClient(orderModel.client.address.title);
        bindDeliveryDateTime(orderModel.deliveryDateTime);
        bindMaxArriveToCustomer(orderModel.maxArriveToCustomerAt);


        this.buttonStatus.setText(ZakazHelper.zakazStatusButton(orderModel.status));

        if (orderModel.status.equals("taken")) {
            this.buttonStatus.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.changeZakaState(orderModel.orderNumber, new OrderTransition(ZakazHelper.zakazChangeState(orderModel.status)), String.valueOf(orderModel.client.address.location.latitude), String.valueOf(orderModel.client.address.location.longitude), new Callback<ApiOrderModel>() {
                    @Override
                    public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                        Log.d("zakaz CHANGE STATUS", response.toString());
                    }

                    @Override
                    public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                        Log.d("zakaz CHANGE STATUS", t.toString());
                    }
                });

            });
        } else if (orderModel.status.equals("arrivedToClient")) {
            this.buttonStatus.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.changeZakaState(orderModel.orderNumber, new OrderTransition(ZakazHelper.zakazChangeState(orderModel.status)), String.valueOf(orderModel.client.address.location.latitude), String.valueOf(orderModel.client.address.location.longitude), new Callback<ApiOrderModel>() {
                    @Override
                    public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                        Log.d("zakaz CHANGE STATUS", response.toString());
                    }

                    @Override
                    public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                        Log.d("zakaz CHANGE STATUS", t.toString());
                    }
                });

            });
        } else if (orderModel.status.equals("new")) {
            this.buttonStatus.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.changeZakaState(orderModel.orderNumber, new OrderTransition(ZakazHelper.zakazChangeState(orderModel.status)), String.valueOf(ZakazHelper.changeLatitudeRestoraunt(orderModel.restaurant.address.location.latitude)), String.valueOf(ZakazHelper.changeLongitudeRestoraunt(orderModel.restaurant.address.location.longitude)), new Callback<ApiOrderModel>() {
                    @Override
                    public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                        Log.d("zakaz CHANGE STATUS", response.toString());
                    }

                    @Override
                    public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                        Log.d("zakaz CHANGE STATUS", t.toString());
                    }
                });

            });
        } else if (orderModel.status.equals("arrivedToRestaurant")) {
            this.buttonStatus.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.changeZakaState(orderModel.orderNumber, new OrderTransition(ZakazHelper.zakazChangeState(orderModel.status)), String.valueOf(ZakazHelper.randomLatitude(orderModel.restaurant.address.location.latitude)), String.valueOf(ZakazHelper.randomLongitude(orderModel.restaurant.address.location.longitude)), new Callback<ApiOrderModel>() {
                    @Override
                    public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                        Log.d("zakaz CHANGE STATUS", response.toString());
                    }

                    @Override
                    public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                        Log.d("zakaz CHANGE STATUS", t.toString());
                    }
                });

            });
        } else if (orderModel.status.equals("accepted")) {
            this.buttonStatus.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.changeZakaState(orderModel.orderNumber, new OrderTransition(ZakazHelper.zakazChangeState(orderModel.status)), String.valueOf(ZakazHelper.randomLatitude(orderModel.restaurant.address.location.latitude)), String.valueOf(ZakazHelper.randomLongitude(orderModel.restaurant.address.location.longitude)), new Callback<ApiOrderModel>() {
                    @Override
                    public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                        Log.d("zakaz CHANGE STATUS", response.toString());
                    }

                    @Override
                    public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                        Log.d("zakaz CHANGE STATUS", t.toString());
                    }
                });

            });
        }


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
        onClickZakazLictener.Onclick(getAdapterPosition());
        Log.d("ONCLICK ITEM ", String.valueOf(getAdapterPosition()));
    }
}
