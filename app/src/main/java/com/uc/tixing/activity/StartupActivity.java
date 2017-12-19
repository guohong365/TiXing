package com.uc.tixing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.uc.tixing.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class StartupActivity extends ActivityBase implements Runnable {
    private static final boolean AUTO_HIDE = true;
   private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private static final int UI_ANIMATION_DELAY = 300;
    private static final int MESSAGE_INIT_ERROR=1000;
    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==MESSAGE_INIT_ERROR){
                showError();
                finish();
                return;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        mHandler.postDelayed(this, AUTO_HIDE_DELAY_MILLIS);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
    private void showError() {
        Toast.makeText(this,R.string.init_error, Toast.LENGTH_SHORT);
    }
    @Override
    public void run() {
        try{
            mApp.init();
        }catch (Exception e){
            mHandler.sendEmptyMessage(MESSAGE_INIT_ERROR);
        }
        statrMainActivity();
    }

    private void statrMainActivity() {
        Intent intent=new Intent();
        intent.setClass(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
