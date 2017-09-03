package com.malviya.demoflypee.baseclasses;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by 23508 on 8/14/2017.
 */

public interface AbstractGameWorld {
    void init();

    void reset();

    void handleEvents();

    void cycle(float fps);

    void renderer(Paint paint, Canvas canvas);

    void destroy();


}
