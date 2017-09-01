package com.example.ronak.final_project_clone_1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
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

public class Station_Facility_Enquiry extends FragmentActivity implements GoogleMap.OnMarkerDragListener, StreetViewPanorama.OnStreetViewPanoramaChangeListener,OnMapReadyCallback {

    private static final String MARKER_POSITION_KEY = "MarkerPosition";

    // George St, TEMP
    LatLng cord_stairs = new LatLng(46.9878167,3.1504499);
    LatLng cord_underpass = new LatLng(46.9878863,3.1503734);
    LatLng cord_ticket_counter = new LatLng(46.9872584,3.1508021);
    LatLng cord_atm = new LatLng(46.9873726,3.1506475);
    LatLng cord_waiting_room = new LatLng(46.9874541,3.1507049);
    LatLng cord_snacks = new LatLng(46.9874489,3.1506658);
    LatLng cord_chairs1 = new LatLng(46.9875229,3.1504981);
    LatLng cord_chairs2 = new LatLng(46.9871976,3.150645);
    LatLng cord_parking = new LatLng(46.9868606,3.150768);
    LatLng cord_enquiry = new LatLng(46.9873983,3.1506405);
    LatLng cord_drinkingwater = new LatLng(46.9873272,3.1505994);


    private StreetViewPanorama mStreetViewPanorama;

    private Marker mMarker;

    private GoogleMap mMap;


    String value;

    LatLng TEMP;
    LatLng TEMP2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station__facility);

        Intent intent = getIntent();
        value = intent.getExtras().getString("KEY");

        if(value.contains("Drinkingwater"))
        {
            TEMP = cord_drinkingwater;
        }
        if(value.contains("Snacks"))
        {
            TEMP = cord_snacks;
        }
        if(value.contains("Stairs"))
        {
            TEMP = cord_stairs;
        }
        if(value.contains("Underpass"))
        {
            TEMP = cord_underpass;
        }
        if(value.contains("Ticketcounter"))
        {
            TEMP = cord_ticket_counter;
        }
        if(value.contains("Atm"))
        {
            TEMP = cord_atm;
        }
        if(value.contains("Waitingroom"))
        {
            TEMP = cord_waiting_room;
        }
        if(value.contains("Chairs"))
        {
            TEMP = cord_chairs1;
            TEMP2 = cord_chairs2;
        }
        if(value.contains("Enquiry"))
        {
            TEMP = cord_enquiry;

        }
        if(value.contains("Parking"))
        {
            TEMP = cord_parking;

        }


        final LatLng markerPosition;
        if (savedInstanceState == null) {
            markerPosition = TEMP;
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
                                Station_Facility_Enquiry.this);
                        // Only need to set the position once as the streetview fragment will maintain
                        // its state.
                        if (savedInstanceState == null) {
                            mStreetViewPanorama.setPosition(TEMP);
                        }
                    }
                });

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                map.setOnMarkerDragListener(Station_Facility_Enquiry.this);
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
        if (location != null) {
            mMarker.setPosition(location.position);
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



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near TEMP, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(value.contains("Enquiry")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Enquery").snippet("enquery office at gate 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Underpass")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Underpass").snippet("Underpass at pt-1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }

        if(value.contains("Ticketcounter")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Ticketcounter"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Atm")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Atm").snippet("Atm office at gate 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Waitingroom")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Waitingroom").snippet("Waitingroom at pt-1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Chairs")) {
            LatLng enq_gate_1 = cord_chairs1;
            LatLng eng_gate_2 = cord_chairs2;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Chairs").snippet("Chairs at pt 1"));
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Chairs").snippet("Chairs at pt 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Parking")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Parking").snippet("parking at station "));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Drinkingwater")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Drinking water").snippet("Drinking water at pt1 "));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }
        if(value.contains("Snacks")) {
            LatLng enq_gate_1 = cord_stairs;
            mMap.addMarker(new MarkerOptions().position(enq_gate_1).title("Snacks").snippet("Snacks at station"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(enq_gate_1, 18));

        }


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
}
