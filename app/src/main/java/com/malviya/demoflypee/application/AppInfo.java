package com.malviya.demoflypee.application;

import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.malviya.demoflypee.constants.GameWorldConstants;

/**
 * Created by 23508 on 8/14/2017.
 */

public class AppInfo extends Application {
    public static int WIDTH;
    public static int HEIGHT;
    private static AppInfo instance;
    private static float scaleX;
    private static float scaleY;
    private static int dpi;

    public static float getScaleX() {
        return (scaleX);
    }

    public static float getScaleY() {
        return (scaleY);
    }

    private static void setScaleY(float scaleY) {
        AppInfo.scaleY = scaleY;
    }

    private static void setScaleX(float scaleX) {
        AppInfo.scaleX = scaleX;
    }

    public static int getDpi() {
        return dpi;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getWidthHeight();
    }

    private void getWidthHeight() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        HEIGHT = displayMetrics.heightPixels;
        WIDTH = displayMetrics.widthPixels;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        //calculating scale factor as per base build
        setScaleX(GameWorldConstants.BASE_BUILD_DP_WIDTH / dpWidth);
        setScaleY(GameWorldConstants.BASE_BUILD_DP_HEIGHT / dpHeight);
        dpi = getResources().getConfiguration().densityDpi;
        Log.d("malviya", "+++++++++++++++++++++++++++++++++++++");
        Log.d("malviya", "WIDTH++ " + WIDTH);
        Log.d("malviya", "HEIGHT++ " + HEIGHT);
        Log.d("malviya", "dpHeight++ " + dpHeight);
        Log.d("malviya", "dpWidth++" + dpWidth);
        Log.d("malviya", "dpi++ " + dpi);
        Log.d("malviya", "getScaleX++ " + getScaleX());
        Log.d("malviya", "getScaleY++" + getScaleY());
        Log.d("malviya", "+++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    @Override
    public String getPackageName() {
        return super.getPackageName();
    }

    public static AppInfo getInstance() {
        return instance;
    }
}
