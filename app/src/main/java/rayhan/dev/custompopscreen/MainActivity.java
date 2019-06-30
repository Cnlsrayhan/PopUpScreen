package rayhan.dev.custompopscreen;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Dialog epicDialog;
    Button positivePopupBtn, negativePopupBtn,btnAccept,btnRetry;
    TextView titleTv,messageTv;
    ImageView closePopupPositiveImg,closePopupNegativeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epicDialog = new Dialog(this);

        positivePopupBtn = (Button) findViewById(R.id.positivePopupBtn);
        negativePopupBtn = (Button) findViewById(R.id.negativePopupBtn);

        positivePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPositivePopup();
            }
        });

        negativePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowNegativePopup();
            }
        });

    }

    public void negative(View view){
        Intent negativeIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://jualaris.com/"));
        startActivity(negativeIntent);
    }

    public void ShowPositivePopup(){

        epicDialog.setContentView(R.layout.epic_popup_positive);
        closePopupPositiveImg = (ImageView) epicDialog.findViewById(R.id.closePopupPositiveImg);
        btnAccept = (Button) epicDialog.findViewById(R.id.btnAccept);
        titleTv = (TextView) epicDialog.findViewById(R.id.titleTv);
        messageTv = (TextView) epicDialog.findViewById(R.id.messageTv);

        closePopupPositiveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }

    public void ShowNegativePopup(){

        epicDialog.setContentView(R.layout.epic_popup_negative);
        closePopupNegativeImg = (ImageView) epicDialog.findViewById(R.id.closePopupNegativeImg);
        btnRetry = (Button) epicDialog.findViewById(R.id.btnRetry);
        titleTv = (TextView) epicDialog.findViewById(R.id.titleTv);
        messageTv = (TextView) epicDialog.findViewById(R.id.messageTv);

        closePopupNegativeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

}
