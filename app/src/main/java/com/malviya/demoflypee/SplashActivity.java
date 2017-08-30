package com.malviya.demoflypee;

import android.os.Handler;

import com.malviya.demoflypee.baseclasses.BaseActivity;
import com.malviya.demoflypee.gamemenu.GameMenuActivity;

/**
 * Created by 23508 on 8/11/2017.
 */

public class SplashActivity extends BaseActivity {

    private static final long TIME_DELAYED = 4000;
    private Handler mHandler;
    private Runnable mRunnable;


    @Override
    protected void init() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                navigateActivity(GameMenuActivity.class, null);
                finish();
            }
        };
        mHandler.postDelayed(mRunnable, TIME_DELAYED);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void start() {

    }

    @Override
    protected void stop() {

    }

    @Override
    protected void destroy() {

    }


}
