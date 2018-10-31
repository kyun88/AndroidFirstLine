package com.example.android.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MyIntentService","Thread id is" + Thread.currentThread().getId());
    }

    @Override
     public void onDestroy() {
         super.onDestroy();
         Log.d("MyIntentService","onDestroy executed");
     }
}
