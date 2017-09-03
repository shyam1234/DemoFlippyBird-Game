package com.malviya.demoflypee.gameworld;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.malviya.demoflypee.R;
import com.malviya.demoflypee.application.AppInfo;
import com.malviya.demoflypee.baseclasses.BaseGameWorld;
import com.malviya.demoflypee.constants.ActorTypeConstants;
import com.malviya.demoflypee.constants.GameWorldConstants;
import com.malviya.demoflypee.utils.Utils;

import java.util.ArrayList;

/**
 * Created by 23508 on 8/14/2017.
 */

public class GameWorldView extends BaseGameWorld {

    private ActorKrishna mActorKrishna;
    public ArrayList<ActorObstacle> mObstacleArrayList;
    private ArrayList<ActorBackground> arrayListBG;
    public ArrayList<ActorBackground> arrayListFooter;
    private ActorBoard mActorBoard;
    private int mScore;

    public GameWorldView(Context context) {
        super(context);
        setGameState(STATE_INIT);
    }


    @Override
    public void init() {
        initBG();
        initBoard();
        initObstraclers();
        mActorKrishna = new ActorKrishna(this);
        mActorKrishna.init();
    }

    private void initBoard() {
        mActorBoard = new ActorBoard(this, R.drawable.text_game_over, (AppInfo.SCREEN_WIDTH / 2 - Utils.getImageWidth(R.drawable.text_game_over) / 2), (AppInfo.SCREEN_HEIGHT + Utils.getImageHeight(R.drawable.text_game_over)));
    }

    private void initBG() {
        arrayListBG = new ArrayList<ActorBackground>();
        ActorBackground obj = new ActorBackground(R.drawable.bg_day, 0, 0, ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_BG);
        arrayListBG.add(obj);
        obj = new ActorBackground(R.drawable.bg_day, (obj.getX() + obj.getW()), 0, ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_BG);
        arrayListBG.add(obj);
        obj = new ActorBackground(R.drawable.bg_night, (obj.getX() + obj.getW()), 0, ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_BG);
        arrayListBG.add(obj);

        arrayListFooter = new ArrayList<ActorBackground>();
        obj = new ActorBackground(R.drawable.land, 0, (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land)), ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_FOOTER);
        arrayListFooter.add(obj);
        obj = new ActorBackground(R.drawable.land, (obj.getX() + obj.getW()), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land), ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_FOOTER);
        arrayListFooter.add(obj);
        obj = new ActorBackground(R.drawable.land, (obj.getX() + obj.getW()), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land), ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_FOOTER);
        arrayListFooter.add(obj);
    }


    private void initObstraclers() {
        mObstacleArrayList = new ArrayList<ActorObstacle>();
    }

    private void generateObstraclesCycle(float fps) {
        if (mObstacleArrayList.size() < 5) {
            int index = (int) ((Math.random() * 10) % 9);
            ActorObstacle obj = null;
            int tempNum = 0;
            int init_x = 0;
            if (mObstacleArrayList.size() > 0) {
                init_x = (((int) mObstacleArrayList.get(mObstacleArrayList.size() - 1).getX() + AppInfo.SCREEN_WIDTH / 2));
            } else {
                init_x = AppInfo.SCREEN_WIDTH;
            }
            switch (index) {
                case 0:
                    tempNum = (int) ((Math.random() * 10) % 4);
                    if (tempNum >= 2) {
                        tempNum = -tempNum;
                    }

                    obj = new ActorObstacle(R.drawable.pipe2_down, init_x + Utils.getImageWidth(R.drawable.pipe2_down), -PIPE_GAP + (tempNum * 50));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), (tempNum * 50) + PIPE_GAP + (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up)));
                    mObstacleArrayList.add(obj);
                    break;
                case 1:
                    tempNum = (int) ((Math.random() * 10) % 4);
                    if (tempNum >= 2) {
                        tempNum = -tempNum;
                    }
                    obj = new ActorObstacle(R.drawable.pipe_down, init_x + Utils.getImageWidth(R.drawable.pipe_down), -SMALL_PIPE_GAP + (tempNum * 50));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), (tempNum * 50) + SMALL_PIPE_GAP + (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe_up)));
                    mObstacleArrayList.add(obj);
                    break;
                case 2:
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up));
                    mObstacleArrayList.add(obj);
                    break;
                case 3:
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe_up));
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
//                case 6:
//                    obj = new ActorObstacle(R.drawable.hundi, init_x + Utils.getImageWidth(R.drawable.hundi), 0);
//                    mObstacleArrayList.add(obj);
//                    break;
                case 6:
                case 7:
                    obj = new ActorObstacle(R.drawable.pipe2_down, init_x + Utils.getImageWidth(R.drawable.pipe2_down), -PIPE_GAP + (-300));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe2_up, init_x + Utils.getImageWidth(R.drawable.pipe2_up), (-300) + PIPE_GAP + (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe2_up)));
                    mObstacleArrayList.add(obj);
                    break;
                case 8:
                    obj = new ActorObstacle(R.drawable.pipe_down, init_x + Utils.getImageWidth(R.drawable.pipe_down), -SMALL_PIPE_GAP + (-300));
                    mObstacleArrayList.add(obj);
                    obj = new ActorObstacle(R.drawable.pipe_up, init_x + Utils.getImageWidth(R.drawable.pipe_up), (-300) + SMALL_PIPE_GAP + (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.pipe_up)));
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
        switch (getGameState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                mActorKrishna.handleEvents();
                break;
            case STATE_PAUSE:
                break;
            case STATE_GAMEOVER:
                break;
            case STATE_MENU:
                if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();
                }
                break;
        }
    }

    @Override
    public void cycle(float fps) {
        switch (getGameState()) {
            case STATE_INIT:
                break;
            case STATE_RUNNING:
                generateObstraclesCycle(fps);
                mActorKrishna.cycle(fps);
                cycleBG(fps);
                break;
            case STATE_PAUSE:
                break;
            case STATE_GAMEOVER:
                mActorBoard.cycle(fps);
                break;
            case STATE_MENU:
                break;
        }
    }


    private void cycleBG(float fps) {
        ActorBackground obj1 = null;
        for (ActorBackground obj : arrayListBG) {
            obj.cycle(fps);
            if ((obj.getX() + obj.getW()) < SCROLL_BG_SPEED) {
                obj1 = obj;
            }
        }
        if (obj1 != null) {
            arrayListBG.remove(obj1);
            if (Math.random() < 0.5)
                arrayListBG.add(new ActorBackground(R.drawable.bg_day, (arrayListBG.get(arrayListBG.size() - 1).getX() + arrayListBG.get(arrayListBG.size() - 1).getW()), 0, ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_BG));
            else
                arrayListBG.add(new ActorBackground(R.drawable.bg_night, (arrayListBG.get(arrayListBG.size() - 1).getX() + arrayListBG.get(arrayListBG.size() - 1).getW()), 0, ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_BG));
        }

        //for footer
        obj1 = null;
        for (ActorBackground obj : arrayListFooter) {
            obj.cycle(fps);
            if ((obj.getX() + obj.getW()) < SCROLL_OBSTRACLE_N_FOOTER_SPEED) {
                obj1 = obj;
            }
        }
        if (obj1 != null) {
            arrayListFooter.remove(obj1);
            if (Math.random() < 0.5)
                arrayListFooter.add(new ActorBackground(R.drawable.land, (arrayListFooter.get(arrayListFooter.size() - 1).getX() + arrayListFooter.get(arrayListFooter.size() - 1).getW()), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land), ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_FOOTER));
            else
                arrayListFooter.add(new ActorBackground(R.drawable.land, (arrayListFooter.get(arrayListFooter.size() - 1).getX() + arrayListFooter.get(arrayListFooter.size() - 1).getW()), AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land), ActorTypeConstants.TYPE_ACTOR_OBSTRACLE_FOOTER));
        }
        //-----------------------------------
    }

    @Override
    public void renderer(Paint paint, Canvas canvas) {
        for (ActorBackground obj : arrayListBG) {
            obj.renderer(paint, canvas);
        }
        if (getGameState() != STATE_INIT) {
            mActorKrishna.renderer(paint, canvas);
        }
        for (ActorObstacle obj : mObstacleArrayList) {
            obj.renderer(paint, canvas);
        }
        for (ActorBackground obj : arrayListFooter) {
            obj.renderer(paint, canvas);
        }
        showScoreAndLife(paint, canvas);
        //---------------------------------------

        switch (getGameState()) {
            case STATE_INIT:
                canvas.drawBitmap(Utils.getBitMap(R.drawable.tutorial), (AppInfo.SCREEN_WIDTH / 2 - Utils.getImageWidth(R.drawable.tutorial) / 2), (AppInfo.SCREEN_HEIGHT / 2 - Utils.getImageHeight(R.drawable.tutorial) / 2), paint);
                break;
            case STATE_RUNNING:
                break;
            case STATE_PAUSE:
                break;
            case STATE_GAMEOVER:
                mActorBoard.renderer(paint, canvas);
                break;
            case STATE_MENU:
                break;
        }

    }

    private void showScoreAndLife(Paint paint, Canvas canvas) {
        //for health bar
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        float left = canvas.getWidth() / 2 - (GameWorldConstants.HEALTH_HUD_W / 2);
        float top = GameWorldConstants.HUD_HEIGHT;
        canvas.drawRect(left, top, left + GameWorldConstants.HEALTH_HUD_W, top + GameWorldConstants.HEALTH_HUD_H, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(left, top, left + Utils.getPercentage(mActorKrishna.getHealth(), GameWorldConstants.HEALTH_HUD_W), top + GameWorldConstants.HEALTH_HUD_H, paint);
        //for score
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        String score = "Score " + mActorKrishna.getScore();
        canvas.drawText(score, canvas.getWidth() / 2 - score.length() / 2 - 45, GameWorldConstants.HUD_HEIGHT + GameWorldConstants.HUD_HEIGHT_DIFF + 30, paint);
        String value = 2 * (mActorKrishna.getHealth()) + "%";
        canvas.drawText(value, left + GameWorldConstants.HEALTH_HUD_W + 10, top + 20, paint);

    }


    @Override
    public void onTouch(MotionEvent v) {
        switch (getGameState()) {
            case STATE_INIT:
                setGameState(STATE_RUNNING);
                break;
            case STATE_RUNNING:
                mActorKrishna.onTouch(v);
                break;
            case STATE_PAUSE:
                break;
            case STATE_GAMEOVER:
                break;
            case STATE_MENU:
                break;
        }

    }


    @Override
    public void destroy() {
        mActorKrishna = null;
    }


}

