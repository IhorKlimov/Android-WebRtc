package com.myhexaville.androidwebrtc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.myhexaville.androidwebrtc.app_rtc_sample.main.AppRTCMainActivity;
import com.myhexaville.androidwebrtc.tutorial.CameraRenderActivity;
import com.myhexaville.androidwebrtc.tutorial.CompleteActivity;
import com.myhexaville.androidwebrtc.tutorial.DataChannelActivity;
import com.myhexaville.androidwebrtc.tutorial.MediaStreamActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void openAppRTCActivity(View view) {
        startActivity(new Intent(this, AppRTCMainActivity.class));
    }

    public void openSampleActivity(View view) {
        startActivity(new Intent(this, CameraRenderActivity.class));
    }

    public void openSamplePeerConnectionActivity(View view) {
        startActivity(new Intent(this, MediaStreamActivity.class));
    }

    public void openSampleDataChannelActivity(View view) {
        startActivity(new Intent(this, DataChannelActivity.class));
    }

    public void openSampleSocketActivity(View view) {
        startActivity(new Intent(this, CompleteActivity.class));

    }
}
