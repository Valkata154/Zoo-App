/*
 * MAPS ACTIVITY
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.r0adkll.slidr.Slidr;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // Create the map variable
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Swipe to go back
        Slidr.attach(this);

        // Create the map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        // Set coordinates for the map marker
        LatLng Cult = new LatLng(43.204546, 27.926273);
        map.addMarker(new MarkerOptions().position(Cult).title("ZOO"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Cult));
    }
}
