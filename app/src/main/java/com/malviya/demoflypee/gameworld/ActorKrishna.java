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
    private static final int ACTOR_KRISHNA_INIT_POSI = -150;
    private final GameWorldView mGameWorldView;
    private float gravity;
    private int score;
    private int mHealth;
    private int[] birdFrames = {R.drawable.bird0_0, R.drawable.bird0_1, R.drawable.bird0_2};
    private int frame;
    private float deltaTime;
    private boolean isTouch;

    public ActorKrishna(GameWorldView gameWorldView) {
        mGameWorldView = gameWorldView;
    }

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
        mHealth = 0;
        setW(Utils.getImageWidth(R.drawable.bird0_0));
        setH(Utils.getImageHeight(R.drawable.bird0_0));
        setX((AppInfo.SCREEN_WIDTH / 2 - getW() / 2) + ACTOR_KRISHNA_INIT_POSI);
        setY((AppInfo.SCREEN_HEIGHT / 2 - getW() / 2));
    }

    @Override
    public void handleEvents() {
    }

    @Override
    public void cycle(float fps) {
        frameCycle(fps);
        checkGravity(fps);
        if (getY() < getH()) {
            setY(getH());
        }
        checkCollisionWithObstraclesAndOthers(fps);
    }

    private void checkCollisionWithObstraclesAndOthers(float fps) {
        for (ActorObstacle obj : mGameWorldView.mObstacleArrayList) {
            boolean isCollide = Utils.isCollide(getX() + 10, getY() + 10,
                    getW() - 30, getH() - 30, obj.getX(), obj.getY(), obj.getW(), obj.getH());
            if (isCollide) {
                calculateHealth();
            }else{
                countPassedPipe();
            }
        }
        for (ActorBackground obj : mGameWorldView.arrayListFooter) {
            boolean isCollide = Utils.isCollide(getX() + 10, getY() + 10,
                    getW() - 30, getH() - 30, obj.getX(), obj.getY(), obj.getW(), obj.getH());
            if (isCollide) {
                calculateHealth();
            }
        }
    }

    private void countPassedPipe() {
        for(ActorObstacle obstacle : mGameWorldView.mObstacleArrayList){
            if((obstacle.getX()+obstacle.getW())<getX() && !obstacle.isCounted()){
                obstacle.setCounted(true);
                setScore(score+=1);
            }
        }
    }

    private void calculateHealth() {
        if ((getY() >= (AppInfo.SCREEN_HEIGHT - Utils.getImageHeight(R.drawable.land))) || MAX_HEALTH - getHealth() <= 0) {
            setHealth(MAX_HEALTH);
            mGameWorldView.setGameState(STATE_GAMEOVER);
        } else {
            setHealth(mHealth += 1);
        }
    }

    private void checkGravity(float fps) {
        if (isTouch) {
            gravity = -(2 * GRAVITY);
        } else {
            gravity = GRAVITY;
        }
        gravity += (gravity * fps);
        setY((int) ((getY()) + gravity));
        isTouch = false;
    }

    private void frameCycle(float fps) {
        deltaTime = deltaTime + HERO_ANIMATION_SPEED;
        deltaTime += (deltaTime * fps);
        frame = (int) deltaTime;
        if (frame >= birdFrames.length) {
            frame = 0;
            deltaTime = 0;
        }
    }

    @Override
    public void renderer(Paint paint, Canvas canvas) {
        canvas.drawBitmap(Utils.getBitMap(birdFrames[frame]), getX() * AppInfo.getScaleX(), getY() * AppInfo.getScaleY(), paint);

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onTouch(MotionEvent v) {
        isTouch = true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return mHealth;
    }

    public void setHealth(int life) {
        this.mHealth = life;
    }


}
