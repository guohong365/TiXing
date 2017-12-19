package com.uc.tixing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.uc.tixing.app.TiXingApp;

/**
 * Created by guoho on 2017/9/18.
 */

public abstract class ActivityBase extends AppCompatActivity  {
    protected TiXingApp mApp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (TiXingApp) getApplication();
    }
}
