package com.example.ronak.final_project_clone_1;

/**
 * Created by ronak on 3/28/2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Tabfragment2 extends Fragment{

    private Button button;

    private ImageView enquiry;

    private Button stairs;
    private Button underpass;
    private Button slope;
    private Button lift;

    private ImageView ticket_counter;
    private  ImageView atm;
    private ImageView chairs;
    private ImageView parking;
    private ImageView drinking_water;
    private ImageView snacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View subview = inflater.inflate(R.layout.tab_fragment_2, container, false);

        enquiry = (ImageView)subview.findViewById(R.id.rail_enquiry);
        stairs = (Button) subview.findViewById(R.id.stares);
        underpass = (Button)subview.findViewById(R.id.undergroung);
        slope = (Button)subview.findViewById(R.id.slope);
        lift = (Button)subview.findViewById(R.id.lift);

        ticket_counter = (ImageView)subview.findViewById(R.id.ticket_counter);
        atm = (ImageView)subview.findViewById(R.id.atm);
        chairs  =(ImageView)subview.findViewById(R.id.chairs);
        parking = (ImageView)subview.findViewById(R.id.parking);
        drinking_water = (ImageView)subview.findViewById(R.id.drinking_water);
        snacks = (ImageView)subview.findViewById(R.id.snacks);

        drinking_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Drinkingwater");
                startActivity(i);

            }
        });

        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Snacks");
                startActivity(i);

            }
        });

        enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Enquiry");
                startActivity(i);
            }
        });


        underpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Underpass");
                startActivity(i);
            }
        });

        slope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"NO DATA",Toast.LENGTH_SHORT).show();
            }
        });

        lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(getContext(),"NO DATA",Toast.LENGTH_SHORT).show();
            }
        });

        ticket_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Ticketcounter");
                startActivity(i);
            }
        });

        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Atm");
                startActivity(i);
            }
        });

        chairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Chairs");
                startActivity(i);
            }
        });

        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Station_Facility_Enquiry.class);
                i.putExtra("KEY","Parking");
                startActivity(i);
            }
        });




        return subview;
    }
}
