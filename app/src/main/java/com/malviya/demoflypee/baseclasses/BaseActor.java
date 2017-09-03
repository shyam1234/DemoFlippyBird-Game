package com.malviya.demoflypee.baseclasses;

import android.view.MotionEvent;

import com.malviya.demoflypee.constants.ActorTypeConstants;

/**
 * Created by 23508 on 8/14/2017.
 */

public abstract class BaseActor implements AbstractGameWorld, ActorTypeConstants {
    private int x;
    private int y;
    private int w;
    private int h;
    private int state;
    private int type;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public abstract void onTouch(MotionEvent v);

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
