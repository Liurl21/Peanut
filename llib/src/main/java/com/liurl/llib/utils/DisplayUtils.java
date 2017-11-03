package com.liurl.llib.utils;

import com.liurl.llib.x;

/**
 * Modify by liuruilin on 2017/10/10.
 * Created by wyouflf on 15/6/10.
 */

public class DisplayUtils {
    private static float density = -1F;
    private static int widthPixels = -1;
    private static int heightPixels = -1;

    public static float getDensity() {
        if (density <= 0F) {
            density = x.app().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getScreenHeight() {
        if (heightPixels <= 0) {
            heightPixels = x.app().getResources().getDisplayMetrics().heightPixels;
        }
        return heightPixels;
    }

    /**
     * 获取屏幕宽度
     * @return
     */
    public static int getScreenWidth() {
        if (widthPixels <= 0) {
            widthPixels = x.app().getResources().getDisplayMetrics().widthPixels;
        }
        return widthPixels;
    }

    /**
     * dip2px
     * @param dpValue
     * @return
     */
    public static int dip2px(float dpValue) {
        return (int) (dpValue * getDensity() + 0.5F);
    }

    /**
     * px2dip
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / getDensity() + 0.5F);
    }
}
