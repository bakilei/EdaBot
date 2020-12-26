package com.tufypace.yaedabot.ui;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.joanfuentes.hintcase.HintCase;
import com.joanfuentes.hintcaseassets.hintcontentholders.SimpleHintContentHolder;
import com.joanfuentes.hintcaseassets.shapeanimators.RevealCircleShapeAnimator;
import com.joanfuentes.hintcaseassets.shapeanimators.UnrevealCircleShapeAnimator;
import com.joanfuentes.hintcaseassets.shapes.CircularShape;
import com.tufypace.yaedabot.Application;
import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.metrica.MetricaHandler;
import com.tufypace.yaedabot.metrica.MetricaHandlerImpl;
import com.tufypace.yaedabot.metrica.MetricaParams;
import com.tufypace.yaedabot.model.Coordinate;
import com.tufypace.yaedabot.model.CurrentUser;
import com.tufypace.yaedabot.model.balance.BalanceHistory;
import com.tufypace.yaedabot.model.courierinfo.CourierInfo;
import com.tufypace.yaedabot.model.order.OrdersResponse;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.FlatOpenedCourierShift;
import com.tufypace.yaedabot.model.request.LocationPushRequest;
import com.tufypace.yaedabot.model.responses.BalanceHistoryModels;
import com.tufypace.yaedabot.model.responses.BalanceHistoryResponse;
import com.tufypace.yaedabot.model.responses.ChangesListResponse;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.model.responses.ShiftsResponse;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.net.LocationProvider;
import com.tufypace.yaedabot.ui.dialog.DialogSettings;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;
import com.tufypace.yaedabot.utils.Utils;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, Application.ActivityLifecycleCallbacks {
    public final SharedPreferencesProvider mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(this);
    public Toolbar toolbar;
    public TextView mTextToolbarTitle;
    public TextView mTextToolbarSubTitle;
    public Timer mTimer, hunterTimer;
    public TimerTask checkFreeOrder, timetTaskHunter;
    public Handler mTimerHandler = new Handler();
    public ImageView mRoomsFilterButton;
    public HintCase mHintCase;
    public List<String> listLocationUhm;
    public List<String> listLocation;
    public List<String> listLocationCentr;
    public List<String> listLocationVostok;
    public List<String> listLocationKpd;
    public static String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HintCase hintCase = this.mHintCase;
        if (hintCase != null) {
            hintCase.hide();
            this.mHintCase = null;
        }
    }

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle toggle;
    public NavigationView navigationView;


    private void initAppMetrica() {
        YandexMetricaConfig newInternalConfigBuilder = YandexMetricaConfig.newConfigBuilder(Save.APP_METRICA_KEY).build();
        //     newInternalConfigBuilder.withPulseConfig(PulseConfig.newBuilder(this, BuildConfig.HISTOGRAM_PULSE).build());
        YandexMetrica.activate(getApplicationContext(), newInternalConfigBuilder);
        //      YandexMetrica.activate(this, newInternalConfigBuilder);
        YandexMetrica.enableActivityAutoTracking(getApplication());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  metricaHandler
        setContentView(R.layout.activity_main);
        metricaHandler.setOnlineStatus(true);

        CurrentUser.init(this.mSharedPreferencesProvider);
        showFragment("LoginFragment");
        this.toolbar = findViewById(R.id.toolbar);
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setTitle(null);
            this.toolbar.setSubtitle(null);
            /* class com.tokarev.mafia.main.MainActivity.AnonymousClass2 */
            this.toolbar.setNavigationOnClickListener(view -> MainActivity.this.onBackPressed());
        }
        this.mTextToolbarTitle = this.toolbar.findViewById(R.id.text_toolbar_title);
        this.mTextToolbarSubTitle = this.toolbar.findViewById(R.id.text_toolbar_subtitle);
        this.mRoomsFilterButton = this.toolbar.findViewById(R.id.activity_main_room_filter_button);
        this.mRoomsFilterButton.setOnClickListener(v -> {
            DialogSettings dialogSettings = new DialogSettings(MainActivity.this);
            dialogSettings.show();
        });
        setSupportActionBar(this.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setToolbarTitle(getString(R.string.app_name));
        MapKitFactory.setApiKey("1dd8003d-8df1-4fee-9685-6128460d662e");
        MapKitFactory.initialize(this);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listLocation = new ArrayList<>();
        listLocationKpd = new ArrayList<>();
        listLocationCentr = new ArrayList<>();
        listLocationUhm = new ArrayList<>();
        listLocationVostok = new ArrayList<>();
        listLocationKpd.add(String.valueOf(Save.code_kpd));
        listLocationCentr.add(String.valueOf(Save.code_centr));
        listLocationUhm.add(String.valueOf(Save.code_uhm));
        listLocationVostok.add(String.valueOf(Save.code_vostok));


        setToolbarSubTitle("Маленький помощник курьера");
        //   updateZakazi();
        updateLocation();
        new Thread(this::generateDayWeek).start();
        startHunterSlots();
        initAppMetrica();
        getCourierInfo();
        initMetrica();
        getBalanceHistory();
        generateLocation();
    }


    public void setToolbarTitle(String str) {
        if (str == null) {
            this.mTextToolbarTitle.setVisibility(View.GONE);
            return;
        }
        this.mTextToolbarTitle.setVisibility(View.VISIBLE);
        this.mTextToolbarTitle.setText(str);
    }

    public void setToolbarSubTitle(String str) {
        if (str == null) {
            this.mTextToolbarSubTitle.setVisibility(View.GONE);
            return;
        }
        this.mTextToolbarSubTitle.setVisibility(View.VISIBLE);
        this.mTextToolbarSubTitle.setText(str);
    }

    public void setToolbarState(ToolbarState toolbarState) {
        switch (toolbarState) {
            case SHOW_NAVIGATION_BACK:
                this.toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_arrow_back_white));
                return;
            case HIDE_NAVIGATION_BACK:
                this.toolbar.setNavigationIcon(null);
                return;
            case SHOW_SEARCH_BUTTON:
                this.toolbar.setVisibility(View.VISIBLE);
                //       showSearchFriendsHint();
                return;
            case SHOW_FILTER_BUTTON:
                this.mRoomsFilterButton.setVisibility(View.VISIBLE);
                showRoomsFilterHint();
                return;
            case HIDE_ALL_BUTTONS:
                //            this.mSearchButton.setVisibility(8);
                this.mRoomsFilterButton.setVisibility(View.GONE);
                return;
            case SHOW_NAV_MENU:
                navigationView.setVisibility(View.VISIBLE);
                return;
            case HIDE_NAV_MENU:
                navigationView.setVisibility(View.GONE);
            default:
                return;
        }
    }

    private void showRoomsFilterHint() {
        if (!this.mSharedPreferencesProvider.getBoolean("rooms_filter_hint_hide")) {
            /* class com.tokarev.mafia.main.MainActivity.AnonymousClass11 */
            showCircularHint(this.mRoomsFilterButton, R.string.rooms_filter, R.string.rooms_filter_description, () -> MainActivity.this.mSharedPreferencesProvider.save("rooms_filter_hint_hide", true));
        }
    }


    private void showCircularHint(View view, int i, int i2, HintCase.OnClosedListener onClosedListener) {
        final View view2 = view;
        final int i3 = i;
        final int i4 = i2;
        final HintCase.OnClosedListener onClosedListener2 = onClosedListener;

        new Handler().postDelayed(() -> {
            HintCase unused = MainActivity.this.mHintCase = new HintCase(view2.getRootView()).setTarget(view2, new CircularShape(), true).setShapeAnimators(new RevealCircleShapeAnimator(), new UnrevealCircleShapeAnimator()).setHintBlock(new SimpleHintContentHolder.Builder(view2.getContext()).setContentTitle(i3).setContentText(i4).setTitleStyle(R.style.HintTitle).setContentStyle(R.style.HintContent).setMarginByResourcesId(R.dimen.layout_spacing_16dp, R.dimen.layout_spacing_16dp, R.dimen.layout_spacing_16dp, R.dimen.layout_spacing_16dp).build()).setCloseOnTouchView(true).setOnClosedListener(onClosedListener2);
            unused.show();
        }, 200);
    }


    public OrderUtils orderUtils = new OrderUtils();

    public void getBalanceHistory() {
        orderUtils.getBalanceHistory(new Callback<BalanceHistoryResponse>() {
            @Override
            public void onResponse(Call<BalanceHistoryResponse> call, Response<BalanceHistoryResponse> response) {
                Log.d("getBalanceHistory", response.toString());
                if (response.body() != null) {
                    if (response.body().payload != null) {
                        BalanceHistoryModels balanceHistoryResponse = response.body().payload;
                        Log.d("getBalanceHistory", String.valueOf(response.body().payload.getContent().size()));
                        for (int i = 0; i < balanceHistoryResponse.getContent().size(); i++) {
                            BalanceHistory balanceHistory = balanceHistoryResponse.getContent().get(i);
                            Log.d("getBalanceHistory", String.valueOf(balanceHistory.balance));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BalanceHistoryResponse> call, Throwable t) {
                Log.d("getBalanceHistory", t.toString());
            }
        });
    }

    public void updateZakazi() {

        checkFreeOrder = new TimerTask() {
            @Override
            public void run() {
                mTimerHandler.post(() -> {
                    //TODO
                    OrderUtils orderUtils = new OrderUtils();
                    orderUtils.getZakazi(new Callback<OrdersResponse>() {
                        @Override
                        public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                            OrdersResponse ordersResponse = response.body();
                            if (ordersResponse != null && ordersResponse.isSuccess) {
                                Log.d("ORDER RESPONSE ", " SUCCES");
                                Log.d(ordersResponse.payload.toString() + " ", ordersResponse.meta.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdersResponse> call, Throwable t) {
                            Log.d("ORDER RESPONSE ", Objects.requireNonNull(t.getMessage()));
                        }
                    }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));

                });
            }
        };
        if (CurrentUser.getInt("etn_hunter_time") != 0) {
            int time = CurrentUser.getInt("etn_hunter_time") * 1000;
            mTimer.schedule(checkFreeOrder, 0, time);
        } else {
            mTimer.schedule(checkFreeOrder, 0, 60000);
        }

    }

    public Random r;

    public void coordinatesAdd(Coordinate coordinate) {
        if (!coordinates.isEmpty()) {
            coordinates.clear();
        }
        coordinates.add(0, coordinate);
    }

    public ArrayList<Coordinate> coordinates = new ArrayList<>(1);
    MetricaHandler metricaHandler = new MetricaHandlerImpl(new LocationProvider(new Location("fused")));


    public void initMetrica() {

        metricaHandler.publishEvent(MetricaParams.EventTitles.EVENT_BACKGROUND_MODE_OFF, Save.sleep_latitude, Save.sleep_longitude);

        //MetricaHandlerImpl_Factory.create();

    }


    public void eventClickShiftsDate() {
        metricaHandler.publishEvent(MetricaParams.EventTitles.EVENT_CLICK_SHIFTS_DATE, Save.sleep_latitude, Save.sleep_longitude);
    }


    public void initMetricaProfile(CourierInfo courierInfo) {
        metricaHandler.initProfile("Олег Куракин", courierInfo);
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
                    Save.courier.setBalance(4550);
                    initMetricaProfile(Save.courier);
                    Log.d("onResponse balance ", String.valueOf(Save.courier.encashmentAmount));
                }

            }

            @Override
            public void onFailure(Call<CourierInfoResponse> call, Throwable t) {
                Log.d("onResponse", t.toString());
            }
        }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));
    }

    public void generateLocation() {
/*for (int i=0;i<120000;i++){
    coordinatesAdd(new Coordinate(Utils.randDouble(57.190000,57.199000),Utils.randDouble(65.570000,65.599999), Utils.randFloat(1,99),false,"fused"));
    }*/

    }

    public void updateLocation() {
        mTimer = new Timer();
        checkFreeOrder = new TimerTask() {
            @Override
            public void run() {
                mTimerHandler.post(() -> {

                    coordinatesAdd(new Coordinate(Save.sleep_latitude, Save.sleep_longitude, Utils.randFloat(1, 99), false, "fused"));
                    orderUtils.sendLocation(new LocationPushRequest(coordinates), new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.d("UPDATE LOCATION ", response.toString());
                            Log.d("UPDATE LOCATION ", response.message());
                            if (response.body() != null) {
                                Log.d("UPDATE LOCATION ", response.body());
                            }

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("UPDATE LOCATION ", t.getMessage());
                        }
                    }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));
                    //     shiftsChangesUpdate();

                });

            }
        };

        mTimer.schedule(checkFreeOrder, 0, 125000);
    }

    public void shiftsChangesUpdate() {
        orderUtils.sendShiftsChanges(new Callback<ChangesListResponse>() {
            @Override
            public void onResponse(Call<ChangesListResponse> call, Response<ChangesListResponse> response) {
                Log.d("SHIFT CHANGES ", response.toString());
            }

            @Override
            public void onFailure(Call<ChangesListResponse> call, Throwable t) {
                Log.d("SHIFT CHANGES eRRor ", t.getMessage());
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            Log.d("onNavigationItemSelted ", "nav_gallery");
            showFragment("ZakazFragment");
        } else if (id == R.id.nav_home) {
            Log.d("onNavigationItemSelted ", "nav_home");
            showFragment("OrderFragment");
        } else if (id == R.id.nav_profile) {
            showFragment("ProfileFragment");
        } else if (id == R.id.nav_slideshow) {
            showFragment("GetslotsFragment");
        } else if (id == R.id.nav_ohotnik) {
            showFragment("HunterFragment");
        } else if (id == R.id.nav_restoraunt) {
            showFragment("RestorauntFragment");
        } else if (id == R.id.nav_nakrutka) {
            showFragment("NakrutkaFragment");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public List<FlatOpenedCourierShift> listFlatOpenedCourierShift = new ArrayList<>();
    public ArrayList<String> arrDates = new ArrayList<>();

    private void stopHunterSlots() {
        hunterTimer.cancel();
    }


    private void startHunterSlots() {
        hunterSlots();
    }


    public List<CourierShift> closedCourierShifts;
    public List<OpenedCourierShift> openedCourierShifts;


    public LocalDate today;


    public void generateDayWeek() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DayOfWeek thisDayOfWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).getDayOfWeek();
        if (thisDayOfWeek == DayOfWeek.FRIDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));


            String fridayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(3);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);


            arrDates.add(fridayThisWeek);
            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        } else if (thisDayOfWeek == DayOfWeek.SATURDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));


            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(2);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);


            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        } else if (thisDayOfWeek == DayOfWeek.SUNDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));


            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(1);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);


            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        } else if (thisDayOfWeek == DayOfWeek.MONDAY) {


            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));
            String mondayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(7);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            arrDates.add(mondayThisWeek);
            arrDates.add(tuesdayThisWeek);
            arrDates.add(wednesdayThisWeek);
            arrDates.add(thursThisWeek);
            arrDates.add(fridayThisWeek);
            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());

        } else if (thisDayOfWeek == DayOfWeek.TUESDAY) {

            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));

            String tuesdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(6);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            arrDates.add(tuesdayThisWeek);
            arrDates.add(wednesdayThisWeek);
            arrDates.add(thursThisWeek);
            arrDates.add(fridayThisWeek);
            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        } else if (thisDayOfWeek == DayOfWeek.WEDNESDAY) {

            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));

            String wednesdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(5);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);


            arrDates.add(wednesdayThisWeek);
            arrDates.add(thursThisWeek);
            arrDates.add(fridayThisWeek);
            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        } else if (thisDayOfWeek == DayOfWeek.THURSDAY) {
            today = LocalDate.now(ZoneId.of("Asia/Yekaterinburg"));

            String thursThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayThisWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);

            LocalDate dayNextWeek = LocalDate.now(ZoneId.of("Asia/Yekaterinburg")).plusDays(4);

            String mondayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).format(formatter);
            String tuesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).format(formatter);
            String wednesdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).format(formatter);
            String thursNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)).format(formatter);
            String fridayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).format(formatter);
            String saturdayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).format(formatter);
            String sundayNextWeek = dayNextWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).format(formatter);


            arrDates.add(thursThisWeek);
            arrDates.add(fridayThisWeek);
            arrDates.add(saturdayThisWeek);
            arrDates.add(sundayThisWeek);
            arrDates.add(mondayNextWeek);
            arrDates.add(tuesdayNextWeek);
            arrDates.add(wednesdayNextWeek);
            arrDates.add(thursNextWeek);
            arrDates.add(fridayNextWeek);
            arrDates.add(saturdayNextWeek);
            arrDates.add(sundayNextWeek);
            Log.d("DayOfWeek.MONDAY ", arrDates.toString());
        }

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


    private void hunterSlots() {
        hunterTimer = new Timer();

        new Thread(() -> {
            timetTaskHunter = new TimerTask() {
                @Override
                public void run() {
                    mTimerHandler.post(() -> {

                        initMetrica();
                        if (mSharedPreferencesProvider.getBoolean("hunter_slots")) {
                            OrderUtils orderUtils = new OrderUtils();

                            for (int i = 0; i < arrDates.size(); i++) {
                                String data = arrDates.get(i);
                                if (CurrentUser.getBoolean("cb_center_monday")) {
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
                                    }, data, listLocationCentr)).start();

                                }
                                if (CurrentUser.getBoolean("cb_uhm_monday")) {
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
                                    }, data.trim(), listLocationUhm)).start();
                                }
                                if (CurrentUser.getBoolean("cb_kpd_monday")) {
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
                                    }, data, listLocationKpd)).start();
                                }
                                if (CurrentUser.getBoolean("cb_vostok_monday")) {
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
                                    }, data, listLocationVostok)).start();
                                }

/*
                                orderUtils.sendGetFreeSlots(new Callback<ShiftsResponse>() {
                                    @Override
                                    public void onResponse(Call<ShiftsResponse> call, Response<ShiftsResponse> response) {
                                        ShiftsResponse shiftsResponse = response.body();
                                        Log.d("HUNTER GET Slots",response.toString());
                                        if (shiftsResponse!=null){

                                            if (shiftsResponse.getData()!=null){
                                                if (shiftsResponse.getData().getOpened()!=null){
                                                    openedCourierShifts = Objects.requireNonNull(shiftsResponse).getData().getOpened();
                                                }
                                                if (shiftsResponse.getData().getClosed()!=null){
                                                    closedCourierShifts = Objects.requireNonNull(shiftsResponse).getData().getClosed();
                                                }
                                            }


                                            for (OpenedCourierShift openShift : openedCourierShifts
                                            ) {
                                                //    OpenedCourierShift openedCourierShift = new OpenedCourierShift(openShift.getId(),openShift.getType(),new OpenedCourierShiftAttributes("2020-03-29T07:00:00+03:00",openShift.getAttributes().getEndsAt(),openShift.getAttributes().getStartPoint()));
                                                //    String format= "2020-03-29T06:00:00+03:00";
                                                String format= openShift.getAttributes().getStartsAt();
                                                String format2 = openShift.getAttributes().getEndsAt();
                                                String uuid = UUID.randomUUID().toString();
                                                Intrinsics.areEqual(uuid, "UUID.randomUUID().toString()");
                                                Intrinsics.areEqual(format, "startsAt");
                                                Intrinsics.areEqual(format2, "endsAt");
                                                //    FlatOpenedCourierShift flatOpenedCourierShift ="2020-03-29T08:00:00+05:00"
                                                Log.d("FORMAT ", format);
                                                listFlatOpenedCourierShift.add(new FlatOpenedCourierShift(uuid,format,format2,openShift.getAttributes().getStartPoint().getId()) );

                                                Log.d("OPEN SHIFT ", openShift.toString());
                                            }
                                            for (CourierShift courierShift : closedCourierShifts
                                            ) {
                                                Log.d("Closed SHIFT ", courierShift.toString());
                                            }
                                        }




                                        //   setListFlatOpenedCourierShift(list);
                                    }

                                    @Override
                                    public void onFailure(Call<ShiftsResponse> call, Throwable t) {
                                        Log.d("EROR SHIFT ", t.getMessage());
                                    }
                                }, data, listLocation);

                                if (i==arrDates.size()-1){
                                    String uuid = UUID.randomUUID().toString();
                                    CourierShiftSaveRequest  courierShiftSaveRequest = new CourierShiftSaveRequest(uuid,listFlatOpenedCourierShift);

                                    orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
                                        @Override
                                        public void onResponse(Call<String> call, Response<String> response) {

                                            Log.d("SAVE SHIFT", Objects.requireNonNull(response.toString()));


                                        }

                                        @Override
                                        public void onFailure(Call<String> call, Throwable t) {
                                            Log.d("SAVE SHIFT", Objects.requireNonNull(t.getMessage()));
                                        }
                                    });
                                };*/
                            }

                        } else {

                            Log.d("Режим охотника", " Отключен!");
                        }

                    });
                }
            };


            if (CurrentUser.getInt("etn_hunter_time") != 0) {
                int time = CurrentUser.getInt("etn_hunter_time") * 1000;
                hunterTimer.schedule(timetTaskHunter, 100, time);
            } else {
                hunterTimer.schedule(timetTaskHunter, 100, 35000);
            }


        }).start();


    }

    @Override
    protected void onStop() {
        super.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}