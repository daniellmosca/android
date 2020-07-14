package com.sicsolutions.intelliradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;

public class BluetoothScan extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_scan);

        this.mViewHolder.deviceList = findViewById(R.id.devicesList);
        this.mViewHolder.scanProgress = findViewById(R.id.scanProgressBar);
    }

    private class ViewHolder{
        ProgressBar scanProgress;
        ListView deviceList;
    }
}
