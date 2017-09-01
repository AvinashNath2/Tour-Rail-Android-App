package com.example.ronak.final_project_clone_1;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ronak on 3/29/2017.
 */

public class View_Dialog_box_Customized {

    public void showDialog(Activity activity, String storename_code, String price, String rating, String platform){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_box_customized);

        TextView store_code = (TextView) dialog.findViewById(R.id.store_code_box);
        store_code.setText(storename_code);

        TextView rupee_text = (TextView) dialog.findViewById(R.id.price_box);
        rupee_text.setText(price);

        TextView rating_text = (TextView) dialog.findViewById(R.id.rating_box);
        rating_text.setText(rating);

        TextView platform_text = (TextView) dialog.findViewById(R.id.platform_box);
        platform_text.setText(platform);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}
