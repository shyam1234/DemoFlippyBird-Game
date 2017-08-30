package com.malviya.demoflypee.baseclasses;

import android.view.MotionEvent;

import com.malviya.demoflypee.constants.ActorConstants;

/**
 * Created by 23508 on 8/14/2017.
 */

public abstract class BaseActor implements AbstractGameWorld, ActorConstants {
    private float x;
    private float y;
    private float w;
    private float h;
    private int state;
    private int type;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
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
