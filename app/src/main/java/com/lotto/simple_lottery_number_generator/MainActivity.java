package com.lotto.simple_lottery_number_generator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn = (Button) findViewById(R.id.randomBtn);
        btn.setOnClickListener(this);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }
    @Override
    public void onClick(View v) {
        String arr[] = new String[7];
        TextView txt1 = (TextView) findViewById(R.id.num1);
        TextView txt2 = (TextView) findViewById(R.id.num2);
        TextView txt3 = (TextView) findViewById(R.id.num3);
        TextView txt4 = (TextView) findViewById(R.id.num4);
        TextView txt5 = (TextView) findViewById(R.id.num5);
        TextView txt6 = (TextView) findViewById(R.id.num6);
        TextView txt7 = (TextView) findViewById(R.id.num7);

        ArrayList<Integer> a = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++){
            a.add(i);
        }

        Collections.shuffle(a);
        Collections.shuffle(a);
        Collections.shuffle(a);
        Collections.shuffle(a);
        Collections.shuffle(a);

        for(int j=0; j<7; j++){
            arr[j] = String.valueOf(a.get(j));
        }

        txt1.setText(arr[0]);
        txt2.setText(arr[1]);
        txt3.setText(arr[2]);
        txt4.setText(arr[3]);
        txt5.setText(arr[4]);
        txt6.setText(arr[5]);
        txt7.setText(arr[6]);

    }
}