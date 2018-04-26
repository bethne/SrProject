package com.example.bethn.gfree_srproj;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback {
    public final static String MAP_ZIP = "MAP_ZIP";

    private GoogleMap mMap;
    private Address address;
    private Geocoder geocoder;
    private Button listViewButton;
    private Button homeButton;
    private Marker previouslySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this);
        String zip = AppSession.getInstance().getZipSearch();

        try {
            List<Address> addresses = geocoder.getFromLocationName(zip, 1);
            if (!addresses.isEmpty()) {
                address = addresses.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Intent intent = new Intent(this, MainActivity.class);
        homeButton = (Button) findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        listViewButton = (Button) findViewById(R.id.list_view_button);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, SearchActivity.class));
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

/* ONLY MATTERS IF YOU WANT TO USE USER LOCATION
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);



        // Add a marker in Sydney and move the camera
        LatLng myLoc = new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude());

        */
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        if (address != null) {
            LatLng searchLoc = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(searchLoc, 12));
            Log.d("MapsActivity", address.getAdminArea());
        }

        RestaurantDataProvider dataProvider = AppSession.getInstance().getRestaurantDataProvider();
        List<Restaurant> restaurantList = dataProvider.getRestaurants();

        Log.d("MainActivity", String.valueOf(restaurantList.size()));

        for (Restaurant restaurant : restaurantList) {
            if (restaurant != null) {
                try {
                    List<Address> addresses = geocoder.getFromLocationName(restaurant.getAddress(), 1);
                    if (!addresses.isEmpty()) {
                        Address curAddress = addresses.get(0);
                        LatLng latLng = new LatLng(curAddress.getLatitude(), curAddress.getLongitude());
                        //markers should be pulled from the database
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(restaurant.getName());
                        Marker marker = mMap.addMarker(markerOptions);
                        previouslySelected = marker;
                        marker.showInfoWindow();
                        marker.setTag(restaurant);

                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                if (marker.equals(previouslySelected)) {
                                    Restaurant selectedRestaurant = (Restaurant) marker.getTag();

                                    Intent intent = new Intent(MapsActivity.this, RestaurantInfoActivity.class);
                                    intent.putExtra(RestaurantInfoActivity.RESTAURANT_SELECTED, selectedRestaurant);
                                    startActivity(intent);

                                }
                                previouslySelected = marker;

                                return false;
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
