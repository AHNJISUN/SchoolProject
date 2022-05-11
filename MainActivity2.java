package com.example.location_ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    SupportMapFragment mapFragment;
    GoogleMap map;
    TextView tv;
    GroundOverlayOptions marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                tv.setText("지도로드");
                map=googleMap;
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                map.getUiSettings().setZoomControlsEnabled(true);
                LatLng curPoint = new LatLng(34.665394, 135.432526);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 12));
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        MarkerOptions makerOptions=new MarkerOptions();
                        makerOptions.position(latLng);
                        map.addMarker(makerOptions);
//                        marker= new GroundOverlayOptions()
//                                .image(BitmapDescriptorFactory.fromResource(R.drawable.map_icon))
//                                .position(latLng,  300f, 300f);
//                        map.addGroundOverlay(marker);
                    }
                });
            }
        });
    }
}