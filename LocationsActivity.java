package com.example.hp.tacle;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        LatLng property1 = new LatLng(23.001481,72.5344073);
        googleMap.addMarker(new MarkerOptions().position(property1).title("Property 1"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(property1));
/*
        LatLng property2 = new LatLng(23.001481,72.5344073);
        mMap.addMarker(new MarkerOptions().position(property2).title("Property 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(property2));*/

        LatLng property3 = new LatLng(22.999851, 72.540453);
        googleMap.addMarker(new MarkerOptions().position(property3).title("Property 3"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(property3));

        LatLng property4 = new LatLng(23.002359, 72.539552);
        googleMap.addMarker(new MarkerOptions().position(property4).title("Property 4"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(property4));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(property4,12.0f));

    }
}
