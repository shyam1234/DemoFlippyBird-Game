package com.malviya.demoflypee.gameworld;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

import com.malviya.demoflypee.R;
import com.malviya.demoflypee.application.AppInfo;
import com.malviya.demoflypee.baseclasses.BaseGameWorld;
import com.malviya.demoflypee.utils.Utils;

import java.util.ArrayList;

/**
 * Created by 23508 on 8/14/2017.
 */

public class GameWorldView extends BaseGameWorld {

    private ActorKrishna mActorKrishna;
    private ArrayList<ActorObstacle> mObstacleArrayList;
    private ArrayList<Background> arrayListBG;
    private ArrayList<Background> arrayListFooter;

    public GameWorldView(Context context) {
        super(context);
        setGameState(STATE_INIT);
    }


    @Override
    public void init() {
        initBG();
        initObstraclers();
        mActorKrishna = new ActorKrishna();
        mActorKrishna.init();
    }

    private void initBG() {
        arrayListBG = new ArrayList<Background>();
        Background obj = new Background(R.drawable.bg_day, 0, 0);
        arrayListBG.add(obj);
        obj = new Background(R.drawable.bg_day, (obj.x + obj.w), 0);
        arrayListBG.add(obj);
        obj = new Background(R.drawable.bg_night, (obj.x + obj.w), 0);
        arrayListBG.add(obj);

        arrayListFooter = new ArrayList<Background>();
        obj = new Background(R.drawable.land, 0, (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.land)));
        arrayListFooter.add(obj);
        obj = new Background(R.drawable.land, (obj.x + obj.w), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.land));
        arrayListFooter.add(obj);
        obj = new Background(R.drawable.land, (obj.x + obj.w), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.land));
        arrayListFooter.add(obj);

    }


    private void initObstraclers() {
        mObstacleArrayList = new ArrayList<ActorObstacle>();
    }

    private void generateObstracles(float fps) {
        if (mObstacleArrayList.size() < 5) {
            int index = (int) ((Math.random() * 10) % 9);
            ActorObstacle obj = null;
            int tempNum = 0;
            int init_x = 0;
            Log.d("malviya", "++++mObstacleArrayList.size() init_x+++ " + mObstacleArrayList.size());
            if (mObstacleArrayList.size() > 0) {
                init_x = (((int) mObstacleArrayList.get(mObstacleArrayList.size() - 1).getX() + AppInfo.WIDTH / 2));
                Log.d("malviya", "++++init_x init_x+++ " + init_x);
            } else {
                init_x = AppInfo.WIDTH;
            }
            switch (index) {
                case 0:
                    tempNum = (int) ((Math.random() * 10) % 4);
                    if (tempNum >= 2) {
                        tempNum = -tempNum;
                    }

                    obj = new ActorObstacle(R.drawable.pipe2_down, init_x + Utils.getImageWidth(R.drawable.pipe2_down), -PIPE_GAP + (tempNum * 50));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), (tempNum * 50) + PIPE_GAP + (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up)));
                    mObstacleArrayList.add(obj);
                    break;
                case 1:
                    tempNum = (int) ((Math.random() * 10) % 4);
                    if (tempNum >= 2) {
                        tempNum = -tempNum;
                    }
                    obj = new ActorObstacle(R.drawable.pipe_down, init_x + Utils.getImageWidth(R.drawable.pipe_down), -SMALL_PIPE_GAP + (tempNum * 50));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), (tempNum * 50) + SMALL_PIPE_GAP + (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe_up)));
                    mObstacleArrayList.add(obj);
//                    if (tempNum > 0) {
//                        obj = new ActorObstacle(R.drawable.pipe_up, init_x + AppInfo.WIDTH / 2 + Utils.getImageWidth(R.drawable.pipe_up), (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe_up)));
//                        mObstacleArrayList.add(obj);
//                    } else {
//                        obj = new ActorObstacle(R.drawable.pipe_down, init_x + AppInfo.WIDTH / 2 + Utils.getImageWidth(R.drawable.pipe_down), 0);
//                        mObstacleArrayList.add(obj);
//                    }obj
                    break;
                case 2:
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up));
                    mObstacleArrayList.add(obj);
                    break;
                case 3:
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe_up));
                    mObstacleArrayList.add(obj);
                    break;
                case 4:
                    obj = new ActorObstacle(R.drawable.pipe2_down, init_x + Utils.getImageWidth(R.drawable.pipe2_down), 0);
                    mObstacleArrayList.add(obj);
                    break;
                case 5:
                    obj = new ActorObstacle(R.drawable.pipe_down, init_x + Utils.getImageWidth(R.drawable.pipe_down), 0);
                    mObstacleArrayList.add(obj);
                    break;
                case 6:
                    obj = new ActorObstacle(R.drawable.hundi, init_x + Utils.getImageWidth(R.drawable.hundi), 0);
                    mObstacleArrayList.add(obj);
                    break;

                case 7:
                    obj = new ActorObstacle(R.drawable.pipe2_down, init_x + Utils.getImageWidth(R.drawable.pipe2_down), -PIPE_GAP + (-300));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), (-300) + PIPE_GAP + (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up)));
                    mObstacleArrayList.add(obj);
                    break;
                case 8:
                    obj = new ActorObstacle(R.drawable.pipe_down, init_x + Utils.getImageWidth(R.drawable.pipe_down), -SMALL_PIPE_GAP + (-300));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), (-300) + SMALL_PIPE_GAP + (AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.pipe_up)));
                    mObstacleArrayList.add(obj);
                    break;
            }
        }
        //ConcurrentModificationException
        for (int index = 0; index < mObstacleArrayList.size(); index++) {
            mObstacleArrayList.get(index).cycle(fps);
            if (mObstacleArrayList.get(index).getX() < -mObstacleArrayList.get(index).getW()) {
                mObstacleArrayList.remove(mObstacleArrayList.get(index));
            }
        }
        //-------------------------------------------------
    }

    @Override
    public void reset() {

    }

    @Override
    public void handleEvents() {
        mActorKrishna.handleEvents();
        switch (getGameState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_STOP:
                if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();
                }
                break;
        }
    }

    @Override
    public void cycle(float fps) {
        mActorKrishna.cycle(fps);
        if (mActorKrishna.getState() == STATE_STOP) {
            setGameState(STATE_STOP);
        }
        switch (getGameState()) {
            case STATE_INIT:
            case STATE_RUNNING:
                cycleBG(fps);
                generateObstracles(fps);
                break;
            case STATE_PAUSE:
                break;
            case STATE_STOP:
                break;
        }
    }


    private void cycleBG(float fps) {
        Background obj1 = null;
        for (Background obj : arrayListBG) {
            obj.x = obj.x + SCROLL_BG_SPEED;
            if ((obj.x + obj.w) < SCROLL_BG_SPEED) {
                obj1 = obj;
            }
        }
        if (obj1 != null) {
            arrayListBG.remove(obj1);
            if (Math.random() < 0.5)
                arrayListBG.add(new Background(R.drawable.bg_day, (arrayListBG.get(arrayListBG.size() - 1).x + arrayListBG.get(arrayListBG.size() - 1).w), 0));
            else
                arrayListBG.add(new Background(R.drawable.bg_night, (arrayListBG.get(arrayListBG.size() - 1).x + arrayListBG.get(arrayListBG.size() - 1).w), 0));
        }

        //for footer
        obj1 = null;
        for (Background obj : arrayListFooter) {
            obj.x = obj.x + SCROLL_FOOTER_SPEED;
            if ((obj.x + obj.w) < SCROLL_FOOTER_SPEED) {
                obj1 = obj;
            }
        }
        if (obj1 != null) {
            arrayListFooter.remove(obj1);
            if (Math.random() < 0.5)
                arrayListFooter.add(new Background(R.drawable.land, (arrayListFooter.get(arrayListFooter.size() - 1).x + arrayListFooter.get(arrayListFooter.size() - 1).w), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.land)));
            else
                arrayListFooter.add(new Background(R.drawable.land, (arrayListFooter.get(arrayListFooter.size() - 1).x + arrayListFooter.get(arrayListFooter.size() - 1).w), AppInfo.HEIGHT - Utils.getImageHeight(R.drawable.land)));
        }
        //-----------------------------------
    }

    @Override
    public void renderer(Paint paint, Canvas canvas) {
        for (Background obj : arrayListBG) {
            canvas.drawBitmap(Utils.getBitMap(obj.image), obj.x * AppInfo.getScaleX(), obj.y * AppInfo.getScaleY(), paint);
        }
        mActorKrishna.renderer(paint, canvas);
        for (ActorObstacle obj : mObstacleArrayList) {
            obj.renderer(paint, canvas);
        }
        for (Background obj : arrayListFooter) {
            canvas.drawBitmap(Utils.getBitMap(obj.image), obj.x * AppInfo.getScaleX(), obj.y * AppInfo.getScaleY(), paint);
        }
    }

    @Override
    public void onTouch(MotionEvent v) {
        mActorKrishna.onTouch(v);
    }


    @Override
    public void destroy() {
        mActorKrishna = null;
    }

    private class Background {
        int x;
        int y;
        int w;
        int h;
        int image;

        public Background(int pImage, int pX, int pY) {
            image = pImage;
            x = pX;
            y = pY;
            w = (int) Utils.getImageWidth(pImage);
            h = (int) Utils.getImageHeight(pImage);
        }

    }
}
