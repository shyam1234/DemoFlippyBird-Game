package com.malviya.demoflypee.gamemenu;

import android.view.View;
import android.widget.ImageButton;

import com.malviya.demoflypee.R;
import com.malviya.demoflypee.baseclasses.BaseActivity;
import com.malviya.demoflypee.gameworld.GameWorldActivity;

/**
 * Created by 23508 on 8/11/2017.
 */

public class GameMenuActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton mBtnPlay;


    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_game_menu);
        mBtnPlay = (ImageButton) findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                navigateActivity(GameWorldActivity.class, null);
                break;
        }
    }
}
