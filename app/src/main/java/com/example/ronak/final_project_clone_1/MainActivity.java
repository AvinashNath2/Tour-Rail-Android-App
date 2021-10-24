package com.example.ronak.final_project_clone_1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayAdapter<String> arrayAdapter ;
    private String json_code;
    private String json_entry_key;
    private String json_exit_key;
    private String json_pf_number;
    private String ds;
    private String json_pf_type;
    private String stares;

    public static String public_entry_name;
    public static String public_entry_cordinates;
    public static String public_exit_name;
    public static String public_exit_cordinates;
    public static String enquiry_cordinates;
    public static String rpf_office_cordinates;

    public static ArrayList<String> list_of_all_tea_commodity;

    private TextView station_name;
    private TextView station_code;
    private TextView station_district;
    private TextView entry;
    private TextView exit;
    private TextView platform;

    private TextView stairs;
    private TextView underpass;
    private TextView esclator;;
    private TextView slope;
    private TextView restroom;

    private Button at_station;
    private Button get_direction;
    private String hand_restroom;

    private Button hotels;
    private Button hospitals;
    private Button eateries;
    private Button restaurent;
    private Button pharmacy;
    private Button atm;
    private Button auto_stand;
    private Button bus_stand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView  = (ListView)findViewById(R.id.train_station_nanme);
        TextView station_name = (TextView)findViewById(R.id.station_name);

        hotels = (Button)findViewById(R.id.hotels);
        hospitals = (Button)findViewById(R.id.hospital);
        eateries = (Button)findViewById(R.id.eateries);
        restaurent = (Button)findViewById(R.id.restaurent);
        pharmacy = (Button)findViewById(R.id.pharmacy);
        atm = (Button)findViewById(R.id.atm);
        auto_stand = (Button)findViewById(R.id.auto_stand);
        bus_stand = (Button)findViewById(R.id.bus_stand);

        station_name = (TextView)findViewById(R.id.station_name);
        station_code = (TextView)findViewById(R.id.station_code);
        station_district = (TextView)findViewById(R.id.station_district);
        entry = (TextView)findViewById(R.id.entry);
        exit = (TextView)findViewById(R.id.exit);
        platform = (TextView)findViewById(R.id.platfrom);

        stairs = (TextView)findViewById(R.id.text_vw_stares);
        underpass = (TextView)findViewById(R.id.text_vw_underpass);
        esclator = (TextView)findViewById(R.id.text_vw_escalator);
        slope = (TextView)findViewById(R.id.text_vw_slope);
        restroom = (TextView)findViewById(R.id.text_vw_handi);

        final EditText editText = (EditText)findViewById(R.id.search_box);

        final LinearLayout linearlayout = (LinearLayout)findViewById(R.id.relative_layout_invisible);

        final View myView = findViewById(R.id.text_view_listview);
        final View myView1 = findViewById(R.id.relative_layout_invisible);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        at_station = (Button)findViewById(R.id.at_station);
        get_direction = (Button)findViewById(R.id.get_direction);

        at_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i =  new Intent(MainActivity.this,Activity_3.class);
                startActivity(i);
            }
        });

        get_direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this,MapsActivity1.class);
                startActivity(i);
            }
        });


        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","Hotel");
                startActivity(i);
            }
        });

        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","Hospitals");
                startActivity(i);
            }
        });

        eateries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","eateries");
                startActivity(i);
            }
        });

        restaurent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","restaurent");
                startActivity(i);
            }
        });

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","pharmacy");
                startActivity(i);
            }
        });
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","atm");
                startActivity(i);
            }
        });
        auto_stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","autostand");
                startActivity(i);
            }
        });
        bus_stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Near_by_Activity.class);
                i.putExtra("KEY","busstand");
                startActivity(i);
            }
        });


        final TextView finalStation_name = station_name;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String text = listView.getItemAtPosition(i).toString();
                if(text.contains("Ghaziabad")) {
                    finalStation_name.setText("Ghaziabad");

                    if (Build.VERSION.SDK_INT >= 21) {

                        // get the center for the clipping circle
                        int cx = myView.getWidth() / 2;
                        int cy = myView.getHeight() / 2;

                        // get the initial radius for the clipping circle
                        float initialRadius = (float) Math.hypot(cx, cy);

                        // create the animation (the final radius is zero)
                        Animator anim =
                                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

                        // make the view invisible when the animation is done
                        anim.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                myView.setVisibility(View.GONE);
                                myView1.setVisibility(View.VISIBLE);
                                fab.setVisibility(View.VISIBLE);
                            }
                        });

                        // start the animation
                        anim.start();
                    } else {
                        myView.setVisibility(View.GONE);
                        myView1.setVisibility(View.VISIBLE);
                    }


                    try {
                        new A_task_json().execute("http://192.168.43.104:8000/stationbase/?code=GZB");
                        // new Allstation_facility().execute("http://192.168.0.12:8000/commoditybase/?code=ON&name=tea&pf=x");
                    } catch (Exception e) {

                        Toast.makeText(MainActivity.this, "No risponce", Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_LONG).show();
                }

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.array_station)));

        arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                R.layout.list_item,
                R.id.product_name,
                arrayList);

        listView.setAdapter(arrayAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearlayout.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= 21) {

                   // get the center for the clipping circle
                    int cx = myView.getWidth();
                    int cy = myView.getHeight();

                   // get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

                  // create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

                  // make the view visible and start the animation
                    myView.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.GONE);
                    anim.start();
                }
                else {
                    myView.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.GONE);
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this,Settings_activity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.pnr_status) {
            Intent i = new Intent(MainActivity.this,PNR_status_navigation.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.train_between_station) {

        } else if (id == R.id.train_route) {

        } else if (id == R.id.availability) {

        } else if (id == R.id.fare) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
            progDailog = new ProgressDialog(MainActivity.this);
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

                json_code = jsonObject.getString("code");
                public_entry_name  = jsonObject.getString("entry_keys");
                public_entry_cordinates = jsonObject.getString("entry_values");
                public_exit_name = jsonObject.getString("exit_keys");
                public_exit_cordinates = jsonObject.getString("exit_values");
                enquiry_cordinates = jsonObject.getString("enquiry_office");

                rpf_office_cordinates = jsonObject.getString("rpf_office");

                stares = jsonObject.getString("pf_stair_entries");
                hand_restroom = jsonObject.getString("divyang_keys");


                int count = 1;
                for( int i=0; i<public_entry_name.length(); i++ ) {
                    if( public_entry_name.charAt(i) == ',' ) {
                        count++;
                    }
                }
                json_entry_key= Integer.toString(count);


                count = 1;
                for( int i=0; i<public_exit_name.length(); i++ ) {
                    if( public_exit_name.charAt(i) == ',' ) {
                        count++;
                    }
                }
                json_exit_key= Integer.toString(count);


                json_pf_number = jsonObject.getString("pf_number");
                json_pf_type = jsonObject.getString("pf_types");
                temp = Integer.parseInt(json_pf_type);
                return  null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this,"Network Error",Toast.LENGTH_LONG).show();
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
            station_code.setText(json_code);
            entry.setText(json_entry_key);
            exit.setText(json_exit_key);
            platform.setText(json_pf_number);

            if((temp % 10)==1)
            {
                slope.setText("YES");
            }
            temp=temp/10;
            if((temp % 10)==1)
            {
                esclator.setText("YES");
            }
            temp=temp/10;
            if((temp % 10)==1)
            {
                underpass.setText("YES");
            }
            temp=temp/10;
            if((temp % 10)==1)
            {
                stairs.setText("YES");
            }
            if(hand_restroom.isEmpty())
            {
                restroom.setText("NO");
            }else {
                restroom.setText("YES");
            }
            progDailog.dismiss();
            Toast.makeText(MainActivity.this,json_code,Toast.LENGTH_LONG).show();
        }
    }

   /* class Allstation_facility extends AsyncTask<String,String,String> {
        ProgressDialog progDailog;
        StringBuffer buffer;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String full_json_result;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progDailog = new ProgressDialog(MainActivity.this);
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
                for(int i=0;i<=jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    list_of_all_tea_commodity = new ArrayList<>();
                    list_of_all_tea_commodity.add(jsonObject.getString("latlngid"));
                }

                return  null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this,"Network Error",Toast.LENGTH_LONG).show();
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
            Toast.makeText(MainActivity.this,json_code,Toast.LENGTH_LONG).show();
        }
    }*/


}
