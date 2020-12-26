package com.tufypace.yaedabot.ui.zakaz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.order.OrderModel;
import com.tufypace.yaedabot.model.order.OrdersResponse;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.ui.ToolbarState;
import com.tufypace.yaedabot.ui.zakaz.adapters.ZakazListAdapter;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ZakazFragment extends BaseFragment implements ZakazListAdapter.OnClickZakazLictener {
    public final ZakazListAdapter orderListAdapter;
    public List<OrderModel> orderModelsList;

    public List<OrderModel> getOrderModelsList() {
        return orderModelsList;
    }

    public void setOrderModelsList(ArrayList<OrderModel> orderModelsList) {
        if (!this.orderModelsList.isEmpty()) {
            this.orderModelsList.clear();
        }
        this.orderModelsList = orderModelsList;
    }

    public ZakazFragment() {
        this.orderListAdapter = new ZakazListAdapter(this, this.orderModelsList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_gallery, container, false);


        final Button get_zakaz = inflate.findViewById(R.id.get_zakaz);

        get_zakaz.setOnClickListener(v -> {

//           orderModelsList.addAll(modelObject.payload.orders);
            OrderUtils orderUtils = new OrderUtils();

            orderUtils.getZakazi(new Callback<OrdersResponse>() {
                @Override
                public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                    Log.d("ORDER RESPONSE ", response.toString());
                    if (response.body() != null) {
                        OrdersResponse ordersResponse = response.body();
                        if (!ordersResponse.payload.orders.isEmpty()) {
//                            orderModelsList.addAll(ordersResponse.payload.orders);
                            showOrderList(ordersResponse.payload.getContent());
                            orderListAdapter.notifyDataSetChanged();
                            if (ordersResponse.isSuccess) {
                                Log.d("ORDER RESPONSE ", " SUCCES");
                                Log.d(ordersResponse.payload.toString() + " ", ordersResponse.meta.toString());
                            }
                        }

                    }


                }

                @Override
                public void onFailure(Call<OrdersResponse> call, Throwable t) {
                    Log.d("ORDER RESPONSE ", Objects.requireNonNull(t.getMessage()));
                }
            }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));


        });

        return inflate;
    }


    public void showOrderList(final List<OrderModel> list) {
        /* class com.tokarev.mafia.friendslist.presentation.FriendsListFragment.AnonymousClass1 */
        requireActivity().runOnUiThread(() -> {
            ZakazFragment.this.orderListAdapter.setZakazList(list, this);
            //    OrderFragment.this.mEmptyListView.setVisibility(list.isEmpty() ? 0 : 8);
        });
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_zakaz_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(this.orderListAdapter);
        setToolbarState(ToolbarState.SHOW_FILTER_BUTTON);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void Onclick(int position) {

    }
}
