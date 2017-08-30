package com.malviya.demoflypee.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.malviya.demoflypee.application.AppInfo;

/**
 * Created by 23508 on 8/14/2017.
 */

public class Utils {
    public static Bitmap getBitMap(int drawable){
      return  BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(),drawable);
    }

    public static int getImageWidth( int drawable) {
        return BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(),drawable).getWidth();
    }
    public static int getImageHeight(int drawable) {
        return BitmapFactory.decodeResource(AppInfo.getInstance().getApplicationContext().getResources(),drawable).getHeight();
    }
}
