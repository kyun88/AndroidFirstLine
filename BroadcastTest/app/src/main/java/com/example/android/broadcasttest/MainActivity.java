package com.example.android.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter mIntentFilter;
    private LocalReceiver mLocalReceiver;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent("MyBroadcastReceiver");
//                sendOrderedBroadcast(intent,null);
                Intent intent =new Intent("LOCAL_BROADCAST");
                mLocalBroadcastManager.sendBroadcast(intent);
            }
        });
        mIntentFilter = new IntentFilter(); 
        mIntentFilter.addAction("LOCAL_BROADCAST");
        mLocalReceiver = new LocalReceiver();
        mLocalBroadcastManager.registerReceiver(mLocalReceiver,mIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
