package com.myhexaville.androidwebrtc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.myhexaville.androidwebrtc.main.MainActivity;
import com.myhexaville.androidwebrtc.sample.SampleCameraRenderActivity;
import com.myhexaville.androidwebrtc.sample.SampleDataChannelActivity;
import com.myhexaville.androidwebrtc.sample.SamplePeerConnectionActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void openAppRTCActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openSampleActivity(View view) {
        startActivity(new Intent(this, SampleCameraRenderActivity.class));
    }

    public void openSamplePeerConnectionActivity(View view) {
        startActivity(new Intent(this, SamplePeerConnectionActivity.class));
    }

    public void openSampleDataChannelActivity(View view) {
        startActivity(new Intent(this, SampleDataChannelActivity.class));
    }
}
