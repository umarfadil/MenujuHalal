package dev.nullpointer.menujuhalal;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.fab_location) FloatingActionButton fab_location;
    private GoogleMap mMap;
    private MarkerOptions options = new MarkerOptions();
    private ArrayList<LatLng> latlngs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapFragment.getView().setClickable(false);
    }

    @OnClick(R.id.fab_location) void fab_location() {
        Toast.makeText(this, "Menuju ke Lokasi Resepsi Pernikahan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setAllGesturesEnabled(false);
        LatLng Gujrat = new LatLng(-7.1568118,113.4725494);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Gujrat));
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        float zoomLevel = 15;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gujrat, zoomLevel));

        latlngs.add(new LatLng(-7.1568118,113.4725494));

        //api_key ->  AIzaSyBfaU_nvYFeXhG-OZk4AKHIpdMQPLx4uJg

        for (LatLng point : latlngs) {
            options.position(point);
            options.title("Gedung Serbaguna");
            options.snippet("Lokasi Resepsi Pernikahan");
            options.icon(BitmapDescriptorFactory.fromResource(R.drawable.venue));
            mMap.addMarker(options);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
