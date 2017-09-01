package com.example.ronak.final_project_clone_1;

/**
 * Created by ronak on 3/28/2017.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TabFragment3 extends Fragment{

    private ImageView call_1;
    private ImageView call_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab_fragment_3, container, false);

        call_1 = (ImageView)v.findViewById(R.id.call_button_1);
        call_2 = (ImageView)v.findViewById(R.id.call_button_2);

        call_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:01139340000"));
                startActivity(callIntent);
            }
        });

        call_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:01123340000"));
                startActivity(callIntent);
            }
        });

        return v;
    }
}
