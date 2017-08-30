package com.malviya.demoflypee.gameworld;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.malviya.demoflypee.R;
import com.malviya.demoflypee.application.AppInfo;
import com.malviya.demoflypee.baseclasses.BaseActor;
import com.malviya.demoflypee.constants.GameWorldConstants;
import com.malviya.demoflypee.utils.Utils;


/**
 * Created by 23508 on 8/14/2017.
 */

public class ActorKrishna extends BaseActor implements GameWorldConstants {
    private static final float ACTOR_KRISHNA_INIT_POSI = -150;
    private float gravity;
    private int score;
    private int life;
    private int bullet_count;
    private int[] birdFrames = {R.drawable.bird0_0, R.drawable.bird0_1, R.drawable.bird0_2};
    private int frame;
    private float deltaTime;
    private boolean isTouch;

    @Override
    public void init() {
        setState(STATE_INIT);
        reset();
    }

    @Override
    public void reset() {
        isTouch = false;
        frame = 0;
        deltaTime = 0;
        score = 0;
        life = 0;
        bullet_count = 0;
        setW(Utils.getImageWidth(R.drawable.bird0_0));
        setW(Utils.getImageHeight(R.drawable.bird0_0));
        setX((AppInfo.WIDTH / 2 - getW() / 2) + ACTOR_KRISHNA_INIT_POSI);
        setY((AppInfo.HEIGHT / 2 - getW() / 2));
    }

    @Override
    public void handleEvents() {
        switch (getState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_STOP:
                break;
        }
    }

    @Override
    public void cycle(float fps) {
        frameCycle(fps);
        checkGravity(fps);
        if (getY() >= (AppInfo.HEIGHT-getH())) {
            setState(STATE_STOP);
        } else if (getY() < getH()) {
            setY(getH());
        }
        switch (getState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_STOP:

                break;
        }
    }

    private void checkGravity(float fps) {
        if (isTouch) {
            gravity = -(2 * GRAVITY);
        } else {
            gravity = GRAVITY;
        }
        gravity +=(gravity*fps);
        setY(((int) (getY()) + gravity));
        isTouch = false;
    }

    private void frameCycle(float fps) {
        deltaTime = deltaTime + ANIMATION_SPEED;
        deltaTime +=(deltaTime*fps);
        frame = (int) deltaTime;
        if (frame >= birdFrames.length) {
            frame = 0;
            deltaTime = 0;
        }
    }

    @Override
    public void renderer(Paint paint, Canvas canvas) {
        canvas.drawBitmap(Utils.getBitMap(birdFrames[frame]), getX()*AppInfo.getScaleX(), getY()*AppInfo.getScaleY(), paint);

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onTouch(MotionEvent v) {
        isTouch = true;
        //Log.d("malviya","time "+ v.getEventTime());
    }

  /* switch (getState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_STOP:
                break;
        }*/
}
