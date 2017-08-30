package com.malviya.demoflypee.gameworld;

import android.view.MotionEvent;
import android.view.View;

import com.malviya.demoflypee.baseclasses.BaseActivity;

/**
 * Created by 23508 on 8/11/2017.
 */

public class GameWorldActivity extends BaseActivity implements View.OnClickListener  {
    private GameWorldView mGameWorldView;

    @Override
    protected void init() {
        mGameWorldView = new GameWorldView(GameWorldActivity.this);
        //always call initialize mehtod of base class
        mGameWorldView.initialize();
    }

    @Override
    protected void initView() {
        setContentView(mGameWorldView);
        mGameWorldView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGameWorldView.onTouch(event);
                return true;
            }
        });
    }

    @Override
    protected void start() {

    }

    @Override
    protected void stop() {

    }

    @Override
    protected void destroy() {
        //always call release mehtod of base class
        mGameWorldView.release();
        mGameWorldView = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }


}
