package com.example.ronak.final_project_clone_1;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class Start_tour_Activity extends FragmentActivity implements GoogleMap.OnMarkerDragListener, StreetViewPanorama.OnStreetViewPanoramaChangeListener,OnMapReadyCallback {
    private GoogleMap mMap;

    private static final String MARKER_POSITION_KEY = "MarkerPosition";

    // George St, Sydney
    private static final LatLng SYDNEY = new LatLng(51.60186,-0.029486);

    private StreetViewPanorama mStreetViewPanorama;

    private Marker mMarker;

    String lat;
    String log;

    private Button button_details;

    public  Double pt_1_lat = 51.601527;
    public  Double pt_1_log = -0.029658;
    public  Double pt_2_lat = 51.601515;
    public  Double pt_2_log = -0.030028;
    public  Double pt_3_lat = 51.601432;
    public  Double pt_3_log = -0.030661;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tour_);

        final LatLng markerPosition;
        if (savedInstanceState == null) {
            markerPosition = SYDNEY;
        } else {
            markerPosition = savedInstanceState.getParcelable(MARKER_POSITION_KEY);
        }

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                        mStreetViewPanorama = panorama;
                        mStreetViewPanorama.setOnStreetViewPanoramaChangeListener(
                                Start_tour_Activity.this);
                        // Only need to set the position once as the streetview fragment will maintain
                        // its state.
                        if (savedInstanceState == null) {
                            mStreetViewPanorama.setPosition(SYDNEY);
                        }
                    }
                });

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                map.setOnMarkerDragListener(Start_tour_Activity.this);
                // Creates a draggable marker. Long press to drag.
                mMarker = map.addMarker(new MarkerOptions()
                        .position(markerPosition)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman))
                        .draggable(true));
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(MARKER_POSITION_KEY, mMarker.getPosition());
    }

    @Override
    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {

        button_details = (Button) findViewById(R.id.button_snackbar);

        button_details.setVisibility(View.GONE);

        if (location != null) {

            mMarker.setPosition(location.position);
            LatLng latLng = mMarker.getPosition();
            String s = latLng.toString();
            String[] cord  = s.split("\\(");
            String part_1 = cord[1];
            cord  = part_1.split("\\)");
            part_1 =cord[0];
            cord = part_1.split(",");
            lat = cord[0];
            log = cord[1];

            double _pt_1_d = pt_1_lat;
            String _pt_1_string = String.format("%1.5f", _pt_1_d);

            double _pt_1_d2 = pt_1_log;
            String _pt_1_string2 = String.format("%1.5f", _pt_1_d2);

            if( lat.contains(_pt_1_string) || log.contains(_pt_1_string2))
            {
                button_details.setVisibility(View.VISIBLE);
                button_details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ViewDialog_box alert = new ViewDialog_box();
                        alert.showDialog(Start_tour_Activity.this, "YOU ARE AT PLATFROM 1 ");
                    }
                });
            }

            double _pt_2_d = pt_2_lat;
            String _pt_2_string = String.format("%1.4f", _pt_2_d);

            double _pt_2_d2 = pt_2_log;
            String _pt_2_string2 = String.format("%1.4f", _pt_2_d2);

            if( lat.contains(_pt_2_string) || log.contains(_pt_2_string2))
            {
                button_details.setVisibility(View.VISIBLE);
                button_details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ViewDialog_box alert = new ViewDialog_box();
                        alert.showDialog(Start_tour_Activity.this, "YOU ARE AT PLATFROM 2 ");
                    }
                });
            }

            double _pt_3_d = pt_3_lat;
            String _pt_3_string = String.format("%1.4f", _pt_3_d);

            double _pt_3_d3 = pt_3_log;
            String _pt_3_string3 = String.format("%1.4f", _pt_3_d3);

            if( lat.contains(_pt_3_string) || log.contains(_pt_3_string3))
            {
                button_details.setVisibility(View.VISIBLE);
                button_details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ViewDialog_box alert = new ViewDialog_box();
                        alert.showDialog(Start_tour_Activity.this, "YOU ARE AT PLATFROM 3 ");
                    }
                });
            }

        }
    }


    @Override
    public void onMarkerDragStart(Marker marker) {
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        mStreetViewPanorama.setPosition(marker.getPosition(), 150);
    }

    @Override
    public void onMarkerDrag(Marker marker) {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng platfrom_1 = new LatLng(pt_1_lat,pt_1_log);
        mMap.addMarker(new MarkerOptions().position(platfrom_1).title("PLATFORM-1").snippet("platfrom - 1 of station ON"));

        LatLng platfrom_2 = new LatLng(pt_2_lat,pt_2_log);
        mMap.addMarker(new MarkerOptions().position(platfrom_2).title("PLATFORM-2").snippet("platfrom - 2 of station ON"));

        LatLng platfrom_3 = new LatLng(pt_3_lat,pt_3_log);
        mMap.addMarker(new MarkerOptions().position(platfrom_3).title("PLATFORM-3").snippet("platfrom - 3 of station ON"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(platfrom_1, 18));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            Toast.makeText(this,"Turn on permission Settings-> App-> TouRail-> Permission",Toast.LENGTH_LONG).show();
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
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
}
