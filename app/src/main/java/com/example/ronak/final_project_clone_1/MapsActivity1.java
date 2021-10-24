package com.example.ronak.final_project_clone_1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
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

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String entry_cordinates;
    private String exit_cordinates;
    private String entry_gate_name;
    private String entry_g;
    private String exit_gate_name;
    private String name

    String[] entry_gate_name_part;
    String[] exit_gate_name_part;
    String[] entry_cordinates_part;
    String[] exit_cordinates_part;

    private FloatingActionButton floatingActionButton1;
    private FloatingActionButton floatingActionButton2;
    private FloatingActionButton floatingActionButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);


        new A_task_json().execute("http://192.168.43.104:8000/stationbase/?code=GZB");


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

        String cord1 = entry_cordinates_part[0];
        String[] temp1 = cord1.split(",");
        Double lat1 = Double.parseDouble(temp1[0]);
        Double log1 = Double.parseDouble(temp1[1]);
        LatLng pointer = new LatLng(lat1,log1);
        mMap.addMarker(new MarkerOptions().position(pointer).title(entry_gate_name_part[0]));

        String cord2 = entry_cordinates_part[1];
        String[] temp2 = cord2.split(",");
        Double lat2 = Double.parseDouble(temp2[0]);
        Double log2 = Double.parseDouble(temp2[1]);
        LatLng pointer2 = new LatLng(lat2,log2);
        mMap.addMarker(new MarkerOptions().position(pointer2).title(entry_gate_name_part[1]));

        String cord3 = entry_cordinates_part[2];
        String[] temp3 = cord3.split(",");
        Double lat3 = Double.parseDouble(temp3[0]);
        Double log3 = Double.parseDouble(temp3[1]);
        LatLng pointer3 = new LatLng(lat3,log3);
        mMap.addMarker(new MarkerOptions().position(pointer3).title(entry_gate_name_part[2]));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pointer3,18));

    }
    public void satellite(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void type_2(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    public void type_3(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    class A_task_json extends AsyncTask<String,String,String> {
        ProgressDialog progDailog;
        StringBuffer buffer;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String full_json_result;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progDailog = new ProgressDialog(MapsActivity1.this);
            progDailog.setMessage("Loading...");
            progDailog.setIndeterminate(false);
            progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDailog.setCancelable(true);
            progDailog.show();
        }

        int temp=0;
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                buffer = new StringBuffer();

                String line = "";

                while ((line = reader.readLine()) != null)
                {
                    buffer.append(line);
                }
                full_json_result = buffer.toString();

                JSONArray jsonArray = new JSONArray(full_json_result);
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                entry_gate_name = jsonObject.getString("entry_keys");
                entry_cordinates = jsonObject.getString("entry_values");
                exit_gate_name = jsonObject.getString("exit_keys");
                exit_cordinates = jsonObject.getString("exit_values");

                entry_gate_name_part = entry_gate_name.split(",");
                exit_gate_name_part = exit_gate_name.split(",");

                entry_cordinates_part = entry_cordinates.split("\\^");
                exit_cordinates_part = exit_cordinates.split("\\^");


                return  null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(MapsActivity1.this,"Network Error",Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null)
                {
                    connection.disconnect();
                }
                try
                {
                    if(reader != null)
                    {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            progDailog.dismiss();
            Toast.makeText(MapsActivity1.this,entry_gate_name,Toast.LENGTH_LONG).show();
        }
    }

}
