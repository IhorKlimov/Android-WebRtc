package com.myhexaville.androidwebrtc.app_rtc_sample.util;

public class Constants {
    public static final String EXTRA_ROOMID = "org.appspot.apprtc.ROOMID";
    public static final int CAPTURE_PERMISSION_REQUEST_CODE = 1;

    // List of mandatory application permissions.
    public static final String[] MANDATORY_PERMISSIONS = {"android.permission.MODIFY_AUDIO_SETTINGS",
            "android.permission.RECORD_AUDIO", "android.permission.INTERNET"};

    // Peer connection statistics callback period in ms.
    public static final int STAT_CALLBACK_PERIOD = 1000;
    // Local preview screen position before call is connected.
    public static final int LOCAL_X_CONNECTING = 0;
    public static final int LOCAL_Y_CONNECTING = 0;
    public static final int LOCAL_WIDTH_CONNECTING = 100;
    public static final int LOCAL_HEIGHT_CONNECTING = 100;
    // Local preview screen position after call is connected.
    public static final int LOCAL_X_CONNECTED = 72;
    public static final int LOCAL_Y_CONNECTED = 72;
    public static final int LOCAL_WIDTH_CONNECTED = 25;
    public static final int LOCAL_HEIGHT_CONNECTED = 25;
    // Remote video screen position
    public static final int REMOTE_X = 0;
    public static final int REMOTE_Y = 0;
    public static final int REMOTE_WIDTH = 100;
    public static final int REMOTE_HEIGHT = 100;
}
