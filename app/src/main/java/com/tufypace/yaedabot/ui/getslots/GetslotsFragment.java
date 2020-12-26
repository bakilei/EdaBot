package com.tufypace.yaedabot.ui.getslots;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.FlatOpenedCourierShift;
import com.tufypace.yaedabot.model.responses.ShiftsResponse;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.model.shift.CourierShiftsActive;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetslotsFragment extends BaseFragment {
    public String TAG = GetslotsFragment.this.getTag();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public List<CourierShift> listShiftsActive = new ArrayList<>();

    public OrderUtils orderUtils = new OrderUtils();

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        orderUtils.getShiftActive(new Callback<CourierShiftsActive>() {
            @Override
            public void onResponse(Call<CourierShiftsActive> call, Response<CourierShiftsActive> response) {
                CourierShiftsActive courierShiftsActive = response.body();
                if (courierShiftsActive != null) {
                    if (!listShiftsActive.isEmpty()) {
                        listShiftsActive.clear();
                    }
                    listShiftsActive.addAll(courierShiftsActive.data);
                }
            }

            @Override
            public void onFailure(Call<CourierShiftsActive> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public LocalDate today;
    public List<String> listLocation = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_getslots, container, false);

        EditText eTDMonday = inflate.findViewById(R.id.eTDMonday);
        EditText eTDTuesday = inflate.findViewById(R.id.eTDTuesday);
        EditText eTDWednesday = inflate.findViewById(R.id.eTDWednesday);
        EditText eTDThursday = inflate.findViewById(R.id.eTDThursday);
        EditText eTDFriday = inflate.findViewById(R.id.eTDFriday);
        EditText eTDSaturday = inflate.findViewById(R.id.eTDSaturday);
        EditText eTDSunday = inflate.findViewById(R.id.eTDSunday);

        Button bt_uhm_monday = inflate.findViewById(R.id.bt_uhm_monday);
        Button bt_uhm_tuesday = inflate.findViewById(R.id.bt_uhm_tuesday);
        Button bt_uhm_wednesday = inflate.findViewById(R.id.bt_uhm_wednesday);
        Button bt_uhm_thursday = inflate.findViewById(R.id.bt_uhm_thursday);
        Button bt_uhm_friday = inflate.findViewById(R.id.bt_uhm_friday);
        Button bt_uhm_saturday = inflate.findViewById(R.id.bt_uhm_saturday);
        Button bt_uhm_sunday = inflate.findViewById(R.id.bt_uhm_sunday);

        Button bt_kpd_monday = inflate.findViewById(R.id.bt_kpd_monday);
        Button bt_kpd_tuesday = inflate.findViewById(R.id.bt_kpd_tuesday);
        Button bt_kpd_wednesday = inflate.findViewById(R.id.bt_kpd_wednesday);
        Button bt_kpd_thursday = inflate.findViewById(R.id.bt_kpd_thursday);
        Button bt_kpd_friday = inflate.findViewById(R.id.bt_kpd_friday);
        Button bt_kpd_saturday = inflate.findViewById(R.id.bt_kpd_saturday);
        Button bt_kpd_sunday = inflate.findViewById(R.id.bt_kpd_sunday);

        Button bt_centr_monday = inflate.findViewById(R.id.bt_centr_monday);
        Button bt_centr_tuesday = inflate.findViewById(R.id.bt_centr_tuesday);
        Button bt_centr_wednesday = inflate.findViewById(R.id.bt_centr_wednesday);
        Button bt_centr_thursday = inflate.findViewById(R.id.bt_centr_thursday);
        Button bt_centr_friday = inflate.findViewById(R.id.bt_centr_friday);
        Button bt_centr_saturday = inflate.findViewById(R.id.bt_centr_saturday);
        Button bt_centr_sunday = inflate.findViewById(R.id.bt_centr_sunday);

        Button bt_vostok_monday = inflate.findViewById(R.id.bt_vostok_monday);
        Button bt_vostok_tuesday = inflate.findViewById(R.id.bt_vostok_tuesday);
        Button bt_vostok_wednesday = inflate.findViewById(R.id.bt_vostok_wednesday);
        Button bt_vostok_thursday = inflate.findViewById(R.id.bt_vostok_thursday);
        Button bt_vostok_friday = inflate.findViewById(R.id.bt_vostok_friday);
        Button bt_vostok_saturday = inflate.findViewById(R.id.bt_vostok_saturday);
        Button bt_vostok_sunday = inflate.findViewById(R.id.bt_vostok_sunday);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DayOfWeek thisDayOfWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).getDayOfWeek();
        if (thisDayOfWeek == DayOfWeek.FRIDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(3);
        } else if (thisDayOfWeek == DayOfWeek.SATURDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(2);
        } else if (thisDayOfWeek == DayOfWeek.SUNDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(1);
        } else if (thisDayOfWeek == DayOfWeek.MONDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(7);
        } else if (thisDayOfWeek == DayOfWeek.TUESDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(6);
        } else if (thisDayOfWeek == DayOfWeek.WEDNESDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(5);
        } else if (thisDayOfWeek == DayOfWeek.THURSDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(4);
        }

        String nextMonday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
        String nextTuesday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
        String nextWednesday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
        String nextThursday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
        String nextFriday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
        String nextSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
        String nextSunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

      /*  String dateMonday = output.format(nextMonday);
        String dateTuesday = output.format(nextTuesday);
        String dateWednesday = output.format(nextWednesday);
        String dateThursday = output.format(nextThursday);
        String dateFriday = output.format(nextFriday);
        String dateSaturday = output.format(nextSaturday);
        String dateSunday = output.format(nextSunday);*/
        eTDMonday.setText(nextMonday);
        eTDTuesday.setText(nextTuesday);
        eTDWednesday.setText(nextWednesday);
        eTDThursday.setText(nextThursday);
        eTDFriday.setText(nextFriday);
        eTDSaturday.setText(nextSaturday);
        eTDSunday.setText(nextSunday);

        OrderUtils orderUtils = new OrderUtils();
        bt_vostok_sunday.setOnClickListener(view -> {
            new Thread(() -> {

            }).start();

            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }
            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSunday.getText().toString().trim(), listLocation)).start();

        });

        bt_centr_monday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDMonday.getText().toString().trim(), listLocation)).start();

        });
        bt_centr_tuesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDTuesday.getText().toString().trim(), listLocation)).start();
        });
        bt_centr_wednesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDWednesday.getText().toString().trim(), listLocation)).start();
        });
        bt_centr_thursday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDThursday.getText().toString().trim(), listLocation)).start();
        });
        bt_centr_friday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDFriday.getText().toString().trim(), listLocation)).start();
        });
        bt_centr_saturday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSaturday.getText().toString().trim(), listLocation)).start();
        });
        bt_centr_sunday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_centr));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSunday.getText().toString().trim(), listLocation)).start();
        });

        bt_uhm_monday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDMonday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_tuesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDTuesday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_wednesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDWednesday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_thursday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDThursday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_friday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDFriday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_saturday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSaturday.getText().toString().trim(), listLocation)).start();
        });
        bt_uhm_sunday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_uhm));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSunday.getText().toString().trim(), listLocation)).start();
        });

        bt_kpd_monday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDMonday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_tuesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDTuesday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_wednesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDWednesday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_thursday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDThursday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_friday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDFriday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_saturday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSaturday.getText().toString().trim(), listLocation)).start();
        });
        bt_kpd_sunday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_kpd));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSunday.getText().toString().trim(), listLocation)).start();
        });

        bt_vostok_monday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDMonday.getText().toString().trim(), listLocation)).start();
        });
        bt_vostok_tuesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDTuesday.getText().toString().trim(), listLocation)).start();
        });
        bt_vostok_wednesday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDWednesday.getText().toString().trim(), listLocation)).start();
        });
        bt_vostok_thursday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDThursday.getText().toString().trim(), listLocation)).start();
        });
        bt_vostok_friday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDFriday.getText().toString().trim(), listLocation)).start();
        });
        bt_vostok_saturday.setOnClickListener(view -> {
            if (!listLocation.isEmpty()) {
                listLocation.clear();
            }

            listLocation.add(String.valueOf(Save.code_vostok));
            new Thread(() -> orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                @Override
                public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                    ShiftsResponse shiftsResponse = response.body();
                    Log.d(TAG, response.toString());
                    if (shiftsResponse != null) {
                        if (shiftsResponse.getData() != null) {
                            if (shiftsResponse.getData().getOpened() != null) {
                                new Thread(() -> sendSaveListSlots(shiftsResponse.getData().getOpened())).start();

                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ShiftsResponse> call, Throwable t) {

                }
            }, eTDSaturday.getText().toString().trim(), listLocation)).start();
        });

        return inflate;
    }


    public void sendSaveListSlots(List<OpenedCourierShift> openedCourierShifts) {
        List<FlatOpenedCourierShift> listFlatOpenedCourierShift = new ArrayList<>();
        for (OpenedCourierShift openCourierShift : openedCourierShifts) {
            String format = openCourierShift.getAttributes().getStartsAt();
            String format2 = openCourierShift.getAttributes().getEndsAt();
            String uuid = UUID.randomUUID().toString();
            Intrinsics.areEqual(uuid, "UUID.randomUUID().toString()");
            Intrinsics.areEqual(format, "startsAt");
            Intrinsics.areEqual(format2, "endsAt");
            //    FlatOpenedCourierShift flatOpenedCourierShift ="2020-03-29T08:00:00+05:00"
            Log.d("FORMAT ", format);
            listFlatOpenedCourierShift.add(new FlatOpenedCourierShift(uuid, format, format2, openCourierShift.getAttributes().getStartPoint().getId()));
            if (listFlatOpenedCourierShift.size() == openedCourierShifts.size()) {
                String uuid2 = UUID.randomUUID().toString();
                CourierShiftSaveRequest courierShiftSaveRequest = new CourierShiftSaveRequest(uuid2, listFlatOpenedCourierShift);
                OrderUtils orderUtils = new OrderUtils();
                orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        Log.d("SAVE SHIFT", Objects.requireNonNull(response.toString()));
                        listFlatOpenedCourierShift.clear();

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("SAVE SHIFT", Objects.requireNonNull(t.getMessage()));
                    }
                });
            }
        }
        if (!listFlatOpenedCourierShift.isEmpty()) {
            String uuid2 = UUID.randomUUID().toString();
            CourierShiftSaveRequest courierShiftSaveRequest = new CourierShiftSaveRequest(uuid2, listFlatOpenedCourierShift);
            OrderUtils orderUtils = new OrderUtils();
            orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    Log.d("SAVE SHIFT", Objects.requireNonNull(response.toString()));
                    listFlatOpenedCourierShift.clear();

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("SAVE SHIFT", Objects.requireNonNull(t.getMessage()));
                }
            });

        }

    }


    public List<OpenedCourierShift> openedCourierShifts;
}
