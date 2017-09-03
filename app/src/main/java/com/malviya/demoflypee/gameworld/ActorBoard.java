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

public class ActorBoard extends BaseActor implements GameWorldConstants {
    private final GameWorldView mGameWorldObj;
    protected final int image;

    public ActorBoard(GameWorldView pObj, int pImage, int pX, int pY) {
        image = pImage;
        mGameWorldObj = pObj;
        setX(pX);
        setY(pY);
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
        int targetY = AppInfo.SCREEN_HEIGHT / 2 - getH() / 2;
        if (getY() <= targetY) {
            try {
                Thread.sleep(HOLD_BOARD_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mGameWorldObj.setGameState(STATE_MENU);
        } else {
            setY((int) (getY() + (fps*BOARD_SCROLLUP_SPEED)));
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
