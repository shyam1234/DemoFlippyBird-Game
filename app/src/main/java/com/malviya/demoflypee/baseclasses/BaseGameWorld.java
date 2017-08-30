package com.malviya.demoflypee.baseclasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.malviya.demoflypee.constants.GameWorldConstants;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 23508 on 8/14/2017.
 */

public abstract class BaseGameWorld extends View implements GameWorldConstants, AbstractGameWorld {
    private Paint drawPaint;
    private TimerTask mTimerTask;
    private Timer mTimer;
    private int mGameState;
    public Context mContext;
    private boolean isComplete = true;

    public BaseGameWorld(Context context) {
        super(context);
        mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }

    public void initialize() {
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (mContext instanceof Activity) {
                    ((Activity) mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (isComplete)
                                invalidate();
                        }
                    });
                }
            }
        };
        mTimer.schedule(mTimerTask, 0, DELAY_TIME);
        init();
    }


    // Setup paint with color and stroke styles
    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawCircle(50, 50, 20, drawPaint);
        //drawPaint.setColor(Color.GREEN);
        isComplete = false;
        handleEvents();
        cycle(FRAME_PER_CYCLE);
        canvas.drawColor(Color.BLACK);
        renderer(drawPaint, canvas);
        isComplete = true;
    }


    public void release() {
        mTimer.cancel();
        mTimerTask.cancel();
        mTimer = null;
        mTimerTask = null;
        destroy();
    }


    public int getGameState() {
        return mGameState;
    }

    public void setGameState(int mGameState) {
        this.mGameState = mGameState;
    }

    public abstract void onTouch(MotionEvent v);

}
