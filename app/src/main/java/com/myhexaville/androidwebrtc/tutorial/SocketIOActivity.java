package com.myhexaville.androidwebrtc.tutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.myhexaville.androidwebrtc.R;

import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

import static io.socket.client.Socket.EVENT_CONNECT;
import static io.socket.client.Socket.EVENT_DISCONNECT;

public class SocketIOActivity extends AppCompatActivity {
    private static final String TAG = "SocketIOActivity";

    private Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_io);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        connectToSignallingServer();
    }

    private void connectToSignallingServer() {
        try {
            socket = IO.socket("http://178.150.29.167:8080/");

            socket.on(EVENT_CONNECT, args -> {
                Log.d(TAG, "connectToSignallingServer: connect");
                socket.emit("create or join", "Demo");
            }).on("ipaddr", args -> {
                Log.d(TAG, "connectToSignallingServer: ipaddr");
            }).on("created", args -> {
                Log.d(TAG, "connectToSignallingServer: created");
            }).on("event", args -> {
                Log.d(TAG, "connectToSignallingServer: full");
            }).on("joined", args -> {
                Log.d(TAG, "connectToSignallingServer: joined");
            }).on("log", args -> {
                for (Object arg : args) {
                    Log.d(TAG, "connectToSignallingServer: "+ String.valueOf(arg));
                }
            }).on(EVENT_DISCONNECT, args -> {
                Log.d(TAG, "connectToSignallingServer: disconnect");
            });
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (socket != null) {
            socket.disconnect();
        }
        super.onDestroy();
    }
}
