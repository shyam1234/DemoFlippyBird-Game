package com.malviya.demoflypee.constants;

/**
 * Created by 23508 on 8/14/2017.
 */

public interface GameWorldConstants {
    float FRAME_PER_CYCLE = 0.5f;//0.5f; //control game speed
    //--------------------------------------------
    int GRAVITY = 25;
    long HOLD_BOARD_TIME = 1000; //millsec
    int BOARD_SCROLLUP_SPEED = -100;
    float HERO_ANIMATION_SPEED = 1.2f;
    long RNDERER_DELAY_TIME = 1; //millisec
    int STATE_INIT = 1;
    int STATE_RUNNING = 2;
    int STATE_PAUSE = 3;
    int STATE_GAMEOVER = 4;
    int STATE_MENU = 5;
    int BASE_BUILD_DP_WIDTH = 360;//720;
    int BASE_BUILD_DP_HEIGHT = 592;//640;//1280;
    //game world view
    int SCROLL_BG_SPEED = -5;
    int SCROLL_OBSTRACLE_N_FOOTER_SPEED = -40;
    int PIPE_GAP = 180;
    int SMALL_PIPE_GAP = 160;
    float HUD_HEIGHT = 50;
    int MAX_HEALTH = 50;
    int HEALTH_HUD_W = 350;
    int HEALTH_HUD_H = 20;
    int HUD_HEIGHT_DIFF = 50;
}
