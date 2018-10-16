package com.save.test.openlaw;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private FusedLocationProviderClient mFusedLocationClient;
    private Location location;
    private LatLng destinationLocation = null;

    public static final int ACCESSLOCATION=123;

    public static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();



    }

    public void getLocation(){
        if(Build.VERSION.SDK_INT >= 23){
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                String[] permissions = { android.Manifest.permission.ACCESS_COARSE_LOCATION};
                requestPermissions(permissions, ACCESSLOCATION);
                return;
            }
        }

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            MapsActivity.this.location = location;
                            LatLng sydney = new LatLng(location.getLatitude(),location.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(sydney).title("Position actuelle")
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.me)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                            mMap.animateCamera(
                                    CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),
                                            location.getLongitude()), 12.0f));


                            mMap.addMarker(new MarkerOptions().position(new LatLng(36.7347299, 3.0320814))
                                    .title("Avocat "+String.valueOf(0))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ava)));

                            mMap.addMarker(new MarkerOptions().position(new LatLng(36.731764, 3.1333328))
                                    .title("Avocat "+String.valueOf(1))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ava)));

                            mMap.addMarker(new MarkerOptions().position(new LatLng(36.7376634, 3.081258))
                                    .title("Avocat "+String.valueOf(3))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ava)));

                            mMap.addMarker(new MarkerOptions().position(new LatLng(36.7569686, 3.0517904))
                                    .title("Avocat "+String.valueOf(4))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ava)));
                        }
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
    }
}
