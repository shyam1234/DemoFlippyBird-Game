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

public class ActorBackground extends BaseActor implements GameWorldConstants {
    protected int image;

    public ActorBackground(int pImage, int pX, int pY, int pType) {
        image = pImage;
        setX(pX);
        setY(pY);
        setType(pType);
        setW(Utils.getImageWidth(pImage));
        setH(Utils.getImageHeight(pImage));
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void handleEvents() {

    }

    @Override
    public void cycle(float fps) {
        switch (getType()){
            case TYPE_ACTOR_OBSTRACLE_BG:
                setX((int) (getX() + (fps*SCROLL_BG_SPEED)));
                break;
            case TYPE_ACTOR_OBSTRACLE_FOOTER:
                setX((int) (getX() + (fps*SCROLL_OBSTRACLE_N_FOOTER_SPEED)));
                break;
        }

    }

    @Override
    public void renderer(Paint paint, Canvas canvas) {
        canvas.drawBitmap(Utils.getBitMap(image), getX() * AppInfo.getScaleX(), getY() * AppInfo.getScaleY(), paint);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onTouch(MotionEvent v) {

    }
}
