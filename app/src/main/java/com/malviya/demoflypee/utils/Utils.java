package com.malviya.demoflypee.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.Log;

import com.malviya.demoflypee.application.AppInfo;
import com.malviya.demoflypee.constants.GameWorldConstants;

import static com.malviya.demoflypee.constants.GameWorldConstants.MAX_HEALTH;

/**
 * Created by 23508 on 8/14/2017.
 */

public class Utils {
    public static Bitmap getBitMap(int drawable) {
        return BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(), drawable);
    }

    public static int getImageWidth(int drawable) {
        return BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(), drawable).getWidth();
    }

    public static int getImageHeight(int drawable) {
        return BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(), drawable).getHeight();
    }

    public static boolean isPointInRect(int pX, int pY, int pW, int pH, int targetX, int targetY, int targetW, int targetH) {
        Rectangle target = new Rectangle();
        target.setBounds(targetX, targetY, targetW, targetH);
        return (target.contains(pX, pY));
    }


    public static boolean isCollide(int pX, int pY, int pW, int pH, int targetX, int targetY, int targetW, int targetH) {

        if ((pX + pW) < targetX) {
            return false;
        } else if ((pY + pH) < (targetY)) {
            return false;
        } else if (pY > (targetY + targetH)) {
            return false;
        } else if (pX > (targetX + targetW)) {
            return false;
        }
        return true;
    }

    public static int getPercentage(int current_Health, int Max_Health) {
        int value  =0 ;
        int percentage = ((100/MAX_HEALTH)*current_Health);
        value = (int) ((percentage * 0.01) * Max_Health);
        return value;
    }

}
