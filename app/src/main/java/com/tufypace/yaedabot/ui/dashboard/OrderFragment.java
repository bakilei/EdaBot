package com.tufypace.yaedabot.ui.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ApiEndpoints;
import com.tufypace.yaedabot.api.ShiftService;
import com.tufypace.yaedabot.model.order.OrdersResponse;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.FlatOpenedCourierShift;
import com.tufypace.yaedabot.model.request.StartUnplannedShiftOperation;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.model.responses.ShiftsResponse;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.model.shift.CourierShiftsActive;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.model.shift.ShiftSettingsResponse;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.ui.ToolbarState;
import com.tufypace.yaedabot.ui.adapters.order.OrderListAdapter;
import com.tufypace.yaedabot.ui.adapters.slot.SlotListAdapter;
import com.tufypace.yaedabot.ui.dialog.DialogHours;
import com.tufypace.yaedabot.ui.dialog.DialogOpenSlot;
import com.tufypace.yaedabot.ui.dialog.DialogOrder;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends BaseFragment implements OrderListAdapter.OnClickOrderLictener, SlotListAdapter.OnClickSlotLictener {
    public final OrderListAdapter orderListAdapter;
    public final SlotListAdapter slotListAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public List<CourierShift> courierShifts;
    public List<OpenedCourierShift> openedCourierShifts = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public Timer mTimer;
    public TimerTask checkFreeOrder;
    public Handler mTimerHandler = new Handler();

    public OrderFragment() {
        // Required empty public constructor
        orderListAdapter = new OrderListAdapter(this.courierShifts, this);
        slotListAdapter = new SlotListAdapter(this.openedCourierShifts, this);
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    ShiftService clientctt = ApiClient.getClientCtt();

    ApiEndpoints client = ApiClient.getClientEda();
    public List<String> listLocation;


    public List<FlatOpenedCourierShift> listFlatOpenedCourierShift = new ArrayList<>();
    public String[] arrDates = {"09.05.2020", "10.05.2020", "11.05.2020"};
    public CourierShiftSaveRequest courierShiftSaveRequest;


    public void getOpenSlots(View inflate) {
        OrderUtils orderUtils = new OrderUtils();

        for (int i = 0; i < arrDates.length; i++) {
            String data = arrDates[i];
            orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    if (response.isSuccessful()) {

                        ShiftsResponse shiftsResponse = response.body();
                        if (shiftsResponse != null) {
                            if (!shiftsResponse.getData().getOpened().isEmpty()) {
                                openedCourierShifts.addAll(shiftsResponse.getData().getOpened());
                                showSlotList(openedCourierShifts);
                            }

                            //     OrderFragment.this.slotListAdapter.setSlotList(shiftsResponse.getData().getOpened(),OrderFragment.this);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {
                    Log.d("EROR SHIFT ", t.getMessage());
                }
            }, data, listLocation);


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_order, container, false);

        final Button smeni = inflate.findViewById(R.id.button);
        //      final Button start = inflate.findViewById(R.id.button2);
        final Button info_hours = inflate.findViewById(R.id.info_hours_order);
        final Button order_free_slots = inflate.findViewById(R.id.order_free_slots);
        //    final Button order_give_slots = inflate.findViewById(R.id.order_give_slots);
        final Button unplanned_slot = inflate.findViewById(R.id.unplanned_slot);
        //  final RecyclerView rv = inflate.findViewById(R.id.fragment_orders_list_view);
        //   startTimer();
        setToolbarState(ToolbarState.SHOW_NAV_MENU);
        //    rv.setAdapter(orderListAdapter);

        listLocation = new ArrayList<>();

        listLocation.add("5810");
        listLocation.add("5804");
        listLocation.add("5822");
        listLocation.add("5801");

        order_free_slots.setOnClickListener(

                view -> {
                    RecyclerView recyclerView = inflate.findViewById(R.id.fragment_zakaz_list_view);
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
                    recyclerView.setAdapter(OrderFragment.this.slotListAdapter);
                    if (!openedCourierShifts.isEmpty()) {
                        openedCourierShifts.clear();
                    }
                    getOpenSlots(inflate);
                });


        unplanned_slot.setOnClickListener(v -> {
            OrderUtils orderUtils = new OrderUtils();
            String uuid = UUID.randomUUID().toString();
            orderUtils.startUnplannedShift(new StartUnplannedShiftOperation(uuid, Save.un_eye, 6000, true), new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("UNPLANNED SLOTS onResp", response.toString());
                    Log.d("UNPLANNED SLOTS body", response.message());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("UNPLANNED SLOTS onFail", t.toString());
                }
            });
        });
        info_hours.setOnClickListener(v -> {
            OrderUtils orderUtils = new OrderUtils();
            orderUtils.sendGetSettings(new Callback<ShiftSettingsResponse>() {
                @Override
                public void onResponse(Call<ShiftSettingsResponse> call, Response<ShiftSettingsResponse> response) {
                    ShiftSettingsResponse shiftSettingsResponse = response.body();
                    DialogHours dialogHours = new DialogHours(getContext(), shiftSettingsResponse);
                    dialogHours.show();
                }

                @Override
                public void onFailure(Call<ShiftSettingsResponse> call, Throwable t) {

                }
            });
        });

  /*      order_give_slots.setOnClickListener(v->{
            OrderUtils orderUtils = new OrderUtils();
            String uuid = UUID.randomUUID().toString();
            courierShiftSaveRequest = new CourierShiftSaveRequest(uuid,listFlatOpenedCourierShift);

            orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    try {
                        Log.d("SAVE SHIFT", Objects.requireNonNull(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("SAVE SHIFT", Objects.requireNonNull(t.getMessage()));
                }
            });
        });*/



   /*    start.setOnClickListener(v -> {

           for (CourierShift courierShift:courierShifts
           ) {

               OrderUtils orderUtils = new OrderUtils();
               orderUtils.sendStartShift(courierShift, new Callback<String>() {
                   @Override
                   public void onResponse(Call<String> call, Response<String> response) {
                       Log.d("ПРИШЕЛ ОТВЕ","ФРАГМЕНТУ ОРДЕРА!!!");
                   }

                   @Override
                   public void onFailure(Call<String> call, Throwable t) {
                       Log.d("ПРИШЕЛ ОТВЕТ ОШИБКА","ФРАГМЕНТУ ОРДЕРА!!!");
                   }
               });

               }

      });*/
        smeni.setOnClickListener(v -> {
            clientctt.getShiftsActive().enqueue(new Callback<CourierShiftsActive>() {
                @Override
                public void onResponse(Call<CourierShiftsActive> call, Response<CourierShiftsActive> response) {
                    if (response.isSuccessful()) {
                        RecyclerView recyclerView = inflate.findViewById(R.id.fragment_zakaz_list_view);
                        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
                        recyclerView.setAdapter(OrderFragment.this.orderListAdapter);
                        CourierShiftsActive courierShiftsActive = response.body();
                        showOrderList(courierShiftsActive.getData());
                        //      CourierShift courierShift= courierShiftsActive.data
                        courierShifts = courierShiftsActive.getData();
                        for (CourierShift courierShift : courierShiftsActive.getData()
                        ) {

                            if (courierShift.attributes.startPoint.getId().equals(5801)) {
                                //    shiftLocation = new ShiftLocation(57.148526,65.541244);

                            }

                            Log.d("Order", " CourierShift " + response.toString() + response.code() + courierShift.getAttributes().startPoint.getId() + courierShift.getAttributes().startsAt);


                        }
                        Log.d("Order", " on response " + response.toString() + response.code() + courierShiftsActive.getData());

                    } else {
                        Log.d("Order", " on response " + response.toString() + response.code() + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<CourierShiftsActive> call, Throwable t) {
                    Log.d("Order", " on failyre " + t.getMessage());
                }
            });
        });
        Log.d("Oerder", " get api " + Save.api);

        OrderUtils orderUtils = new OrderUtils();
        orderUtils.getZakazi(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                Log.d("Order", " on response " + response.toString() + response.code() + response.errorBody());
                OrdersResponse ordersResponse = response.body();
                if (ordersResponse != null) {
                    Log.d("Order", " on response " + response.toString() + response.code() + response.errorBody());
                    //      SharedPreferencesUtils.save(getContext(), "api_key", ordersResponse.getPayload().getContent());

                }
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {
                Log.d("Order", " on failyre " + t.getMessage());
            }
        }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));

        return inflate;
    }

    public void getCourierInfo() {
        OrderUtils orderUtils = new OrderUtils();
        orderUtils.getCourierInfo(new Callback<CourierInfoResponse>() {
            @Override
            public void onResponse(Call<CourierInfoResponse> call, Response<CourierInfoResponse> response) {
                Log.d("onResponse", response.toString());
                if (response.body() != null) {
                    CourierInfoResponse courierInfoResponse = response.body();
                    Save.courier = courierInfoResponse.payload;
                    //       initMetricaProfile(courierInfoResponse.payload);
                    Log.d("onResponse balance ", String.valueOf(Save.courier.encashmentAmount));
                }

            }

            @Override
            public void onFailure(Call<CourierInfoResponse> call, Throwable t) {
                Log.d("onResponse", t.toString());
            }
        }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);


        setToolbarState(ToolbarState.SHOW_FILTER_BUTTON);
        getCourierInfo();
        //    OverScrollDecoratorHelper.setUpOverScroll(recyclerView, 0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void showOrderList(final List<CourierShift> list) {
        /* class com.tokarev.mafia.friendslist.presentation.FriendsListFragment.AnonymousClass1 */
        requireActivity().runOnUiThread(() -> {
            OrderFragment.this.orderListAdapter.setoRDERList(list, this);
            //    OrderFragment.this.mEmptyListView.setVisibility(list.isEmpty() ? 0 : 8);
        });
    }

    public void showSlotList(List<OpenedCourierShift> list) {
        requireActivity().runOnUiThread(() -> {
            OrderFragment.this.slotListAdapter.setSlotList(list, this);

            //    OrderFragment.this.mEmptyListView.setVisibility(list.isEmpty() ? 0 : 8);

        });


    }

    @Override
    public void Onclick(int position) {
        CourierShift courierShift = courierShifts.get(position);

        DialogOrder dialogOrder = new DialogOrder(requireContext(), courierShift);
        dialogOrder.show();
        Log.d(courierShift.getAttributes().status, " ");

    }

    @Override
    public void OnclickSlot(int position) {
        OpenedCourierShift openedCourierShift = openedCourierShifts.get(position);
        DialogOpenSlot dialogOrder = new DialogOpenSlot(requireContext(), openedCourierShift);
        dialogOrder.show();
    }

    @Override
    public void OnClickItemSlot(int position) {
        OrderUtils orderUtils = new OrderUtils();
        OpenedCourierShift openedCourierShift = openedCourierShifts.get(position);
        List<FlatOpenedCourierShift> listFlatOpenedCourierShift = new ArrayList<>();

        String format = openedCourierShift.getAttributes().getStartsAt();
        String format2 = openedCourierShift.getAttributes().getEndsAt();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.areEqual(uuid, "UUID.randomUUID().toString()");
        Intrinsics.areEqual(format, "startsAt");
        Intrinsics.areEqual(format2, "endsAt");

        listFlatOpenedCourierShift.add(new FlatOpenedCourierShift(uuid, format, format2, openedCourierShift.getAttributes().getStartPoint().getId()));
        String uuid2 = UUID.randomUUID().toString();
        CourierShiftSaveRequest courierShiftSaveRequest = new CourierShiftSaveRequest(uuid2, listFlatOpenedCourierShift);
        orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() != null) {
                    Log.d("ПРИШЕЛ ОТВЕ", response.body());
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ПРИШЕЛ ОТВЕТ ОШИБКА", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}

