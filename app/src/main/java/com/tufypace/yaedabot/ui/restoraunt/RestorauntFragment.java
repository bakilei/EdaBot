package com.tufypace.yaedabot.ui.restoraunt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.restoraunt.Carousel;
import com.tufypace.yaedabot.model.restoraunt.PersonalPlaces;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.ui.restoraunt.adapters.RestorauntListAdapter;
import com.tufypace.yaedabot.ui.restoraunt.orders.PersonalPlacesOrder;
import com.tufypace.yaedabot.utils.RestarauntUtils;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.location.Location;
import com.yandex.mapkit.location.LocationListener;
import com.yandex.mapkit.location.LocationManager;
import com.yandex.mapkit.location.LocationStatus;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestorauntFragment extends BaseFragment {
    public final RestorauntListAdapter restorauntListAdapter;

    public MapView mapView;
    public RestarauntUtils restarauntUtils = new RestarauntUtils();

    public RestorauntFragment() {
        this.restorauntListAdapter = new RestorauntListAdapter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private UserLocationLayer userLocationLayer;

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void showRestorauntList(final List<Carousel> list) {
        requireActivity().runOnUiThread(() -> {
            RestorauntFragment.this.restorauntListAdapter.setRestorauntList(list);

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private final Point TARGET_LOCATION = new Point(57.144591, 65.581822);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) inflate.findViewById(R.id.mapview);
        RecyclerView recyclerView = inflate.findViewById(R.id.restoraunt_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(RestorauntFragment.this.restorauntListAdapter);


        mapView.getMap().getMapObjects().addPlacemark(new Point(57.133324, 65.580169));

        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 11.5f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 4),
                null);

        MapKit mapKit = MapKitFactory.getInstance();
        LocationManager locationManager = MapKitFactory.getInstance().createLocationManager();

        locationManager.requestSingleUpdate(new LocationListener() {
            @Override
            public void onLocationUpdated(@NonNull Location location) {
                Log.d("LOCATIONACCURACY " + location.getAccuracy(), "Latitude " + location.getPosition().getLatitude() + " Longitude " + location.getPosition().getLongitude());
                getListRestoraunt(location.getPosition().getLatitude(), location.getPosition().getLongitude());
            }

            @Override
            public void onLocationStatusUpdated(@NonNull LocationStatus locationStatus) {
                Log.d("LOCATIONSTATUS" + locationStatus.name(), String.valueOf(locationStatus));
            }
        });
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    ArrayList<Carousel> carousels = new ArrayList<>();

    public void getListRestoraunt(double latitude, double longitude) {
        restarauntUtils.getCatalogRestoraunt(57.148528, 65.541246, "default", new Callback<PersonalPlacesOrder>() {
            @Override
            public void onResponse(Call<PersonalPlacesOrder> call, Response<PersonalPlacesOrder> response) {
                PersonalPlacesOrder personalPlacesOrder = response.body();
                PersonalPlaces personalPlaces = personalPlacesOrder.payload;
                int i = 0;
                if (!personalPlaces.foundPlaces.isEmpty()) {
                    carousels.addAll(personalPlaces.foundPlaces);
                    carousels.sort(new CustomComparator());
                    showRestorauntList(carousels);
              /*      for (Carousel carousel:carousels) {
                        PlaceRestoraunt placeRestoraunt = carousel.place;
                        if(!placeRestoraunt.isMarket()){
                            Log.d(placeRestoraunt.getName()," slug "+ placeRestoraunt.getSlug() );
                            Log.d("РАсстояние ",""+carousel.locationParams.distance );
                            i++;
                            Log.d("I= ",String.valueOf(i));
                       //     mapView.getMap().getMapObjects().addPlacemark(new Point(carousel.locationParams..))
                        }

                    }*/

                }
            }

            @Override
            public void onFailure(Call<PersonalPlacesOrder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}

class CustomComparator implements Comparator<Carousel> {

    @Override
    public int compare(Carousel o1, Carousel o2) {
        return o1.locationParams.distance.compareTo(o2.locationParams.distance);
    }
}