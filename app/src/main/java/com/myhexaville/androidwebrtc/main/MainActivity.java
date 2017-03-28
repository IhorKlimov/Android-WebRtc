/*
 *  Copyright 2014 The WebRTC Project Authors. All rights reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package com.myhexaville.androidwebrtc.main;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.myhexaville.androidwebrtc.R;
import com.myhexaville.androidwebrtc.call.CallActivity;
import com.myhexaville.androidwebrtc.databinding.ActivityMainBinding;

import java.util.Random;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Handles the initial setup where the user selects which room to join.
 */
public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    private static final int CONNECTION_REQUEST = 1;
    private static final int RC_CALL = 111;
    private ActivityMainBinding binding;
    private static boolean commandLineRun = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.connectButton.setOnClickListener(v -> connect());
        binding.roomEdittext.requestFocus();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CONNECTION_REQUEST && commandLineRun) {
            Log.d(LOG_TAG, "Return: " + resultCode);
            setResult(resultCode);
            commandLineRun = false;
            finish();
        }
    }

    @AfterPermissionGranted(RC_CALL)
    private void connect() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO};
        if (EasyPermissions.hasPermissions(this, perms)) {
            connectToRoom(binding.roomEdittext.getText().toString(), false, false);
        } else {
            EasyPermissions.requestPermissions(this, "Need some permissions", RC_CALL, perms);
        }
    }

    private void connectToRoom(String roomId, boolean commandLineRun, boolean loopback) {
        MainActivity.commandLineRun = commandLineRun;

        // roomId is random for loopback.
        if (loopback) {
            roomId = Integer.toString((new Random()).nextInt(100000000));
        }

        String roomUrl = "https://appr.tc";

        // Start AppRTCMobile activity.
        Log.d(LOG_TAG, "Connecting to room " + roomId + " at URL " + roomUrl);
        Uri uri = Uri.parse(roomUrl);
        Intent intent = new Intent(this, CallActivity.class);
        intent.setData(uri);
        intent.putExtra(CallActivity.EXTRA_ROOMID, roomId);
        intent.putExtra(CallActivity.EXTRA_LOOPBACK, loopback);
        intent.putExtra(CallActivity.EXTRA_CMDLINE, commandLineRun);

        startActivityForResult(intent, CONNECTION_REQUEST);
    }
}
