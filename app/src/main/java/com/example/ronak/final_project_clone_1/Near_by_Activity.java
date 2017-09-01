package com.example.ronak.final_project_clone_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Near_by_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String json_name;
    private String json_latlng;

    ArrayList<String> arrayList_cordinates;
    ArrayList<String> arrayList_name;

    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);

        Intent intent = getIntent();
        value = intent.getExtras().getString("KEY");

        arrayList_name = new ArrayList<String>();
        arrayList_cordinates = new ArrayList<String>();

        if (value.contains("Hotel")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=hotels");
            Toast.makeText(Near_by_Activity.this, "Hotel", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("Hospitals")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=hospital");
            Toast.makeText(Near_by_Activity.this, "Hospital", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("eateries")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=eateries");
            Toast.makeText(Near_by_Activity.this, "eateries", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("restaurent")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=restaurant");
            Toast.makeText(Near_by_Activity.this, "restaurent", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("pharmacy")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=pharmacy");
            Toast.makeText(Near_by_Activity.this, "pharmacy", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("atm")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=atm");
            Toast.makeText(Near_by_Activity.this, "atm", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("autostand")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=auto%20stand");
            Toast.makeText(Near_by_Activity.this, "autostand", Toast.LENGTH_SHORT).show();
        }
        if (value.contains("busstand")) {
            new near_by_station().execute("http://192.168.43.104:8000/nearbybase/?code=GZB&name=bus%20stand");
            Toast.makeText(Near_by_Activity.this, "busstand", Toast.LENGTH_SHORT).show();
        }

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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        LatLng marker = null;

        if (value.contains("Hotel")) {

            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));
        }
        if (value.contains("Hospitals")) {

            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));


        }
        if (value.contains("eateries")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));

        }
        if (value.contains("restaurent")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));

        }
        if (value.contains("pharmacy")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));

        }
        if (value.contains("atm")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));

        }
        if (value.contains("autostand")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));

        }
        if (value.contains("busstand")) {
            for (int i = 0; i < arrayList_name.size(); i++) {
                String cord = arrayList_cordinates.get(i);
                String[] temp = cord.split(",");
                Double lat = Double.parseDouble(temp[0]);
                Double log = Double.parseDouble(temp[1]);

                marker = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(marker).title(arrayList_name.get(i)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17));
        }
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
    }

    class near_by_station extends AsyncTask<String,String,String>
    {

        ProgressDialog progDailog ;
        private String full_json;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progDailog = new ProgressDialog(Near_by_Activity.this);
            progDailog.setMessage("Loading...");
            progDailog.setIndeterminate(false);
            progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDailog.setCancelable(true);
            progDailog.show();
        }

        BufferedReader reader;
        StringBuffer buffer;
        InputStream stream;
        int temp;

        String json_entry_count;
        String json_exit_count;

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url =  new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                buffer = new StringBuffer();

                String line = "";

                while ((line = reader.readLine()) != null)
                {
                    buffer.append(line);
                }

                full_json = buffer.toString();

                JSONArray jsonArray = new JSONArray(full_json);

                for(int i=0;i<=jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    json_name = jsonObject.getString("name");
                    arrayList_name.add(json_name);
                    json_latlng = jsonObject.getString("latlng");
                    arrayList_cordinates.add(json_latlng);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                Toast.makeText(Near_by_Activity.this,"NO JSON",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(Near_by_Activity.this,arrayList_name.toString(),Toast.LENGTH_LONG).show();
            progDailog.dismiss();
        }
    }

}
