package com.malviya.demoflypee.baseclasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 23508 on 8/11/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
    }


    @Override
    protected void onStart() {
        super.onStart();
        start();
    }


    @Override
    protected void onStop() {
        super.onStop();
        stop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }


    public void navigateActivity(Class pClass, Bundle pBundle) {
        Intent intent = new Intent(BaseActivity.this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected abstract void init();

    protected abstract void initView();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void destroy();
}
