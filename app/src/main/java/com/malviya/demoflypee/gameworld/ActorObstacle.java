package com.malviya.demoflypee.gameworld;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.malviya.demoflypee.application.AppInfo;
import com.malviya.demoflypee.baseclasses.BaseActor;
import com.malviya.demoflypee.constants.GameWorldConstants;
import com.malviya.demoflypee.utils.Utils;


/**
 * Created by 23508 on 8/14/2017.
 */

public class ActorObstacle extends BaseActor implements GameWorldConstants {
    private int image;
    private boolean counted;

    public ActorObstacle(int pImage, int pX, int pY) {
        image = pImage;
        setX(pX);
        setY(pY);
        setW(Utils.getImageWidth(pImage));
        setH(Utils.getImageHeight(pImage));
    }

    @Override
    public void init() {
        setState(STATE_INIT);
        reset();
    }

    @Override
    public void reset() {

    }

    @Override
    public void handleEvents() {

    }

    @Override
    public void cycle(float fps) {
        setX((int) (getX()+(fps* SCROLL_OBSTRACLE_N_FOOTER_SPEED)));
    }


    @Override
    public void renderer(Paint paint, Canvas canvas) {
        canvas.drawBitmap(Utils.getBitMap(image), getX()* AppInfo.getScaleX(), getY()*AppInfo.getScaleY(), paint);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onTouch(MotionEvent v) {

    }

    public void setCounted(boolean counted) {
        this.counted = counted;
    }

    public boolean isCounted() {
        return counted;
    }

  /* switch (getState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_MENU:
                break;
        }*/
}
