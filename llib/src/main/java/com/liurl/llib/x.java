package com.liurl.llib;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Method;

/**
 * Modify by liuruilin on 2017/10/10.
 * Created by wyouflf on 15/6/10.
 */

public final class x {
    private x() {
    }

    public static Application app() {
        if (Ext.app == null) {
            try {
                // 在IDE进行布局预览时使用
                Class<?> renderActionClass = Class.forName("com.android.layoutlib.bridge.impl.RenderAction");
                Method method = renderActionClass.getDeclaredMethod("getCurrentContext");
                Context context = (Context) method.invoke(null);
                Ext.app = new MockApplication(context);
            } catch (Throwable ignored) {
                throw new RuntimeException("please invoke x.Ext.init(app) on Application#onCreate()"
                        + " and register your Application in manifest.");
            }
        }
        return Ext.app;
    }

    public static boolean isDebug() {
        return Ext.debug;
    }

    public static class Ext {
        private static boolean debug;
        private static Application app;

        private Ext() {
        }

        public static void setDebug(boolean debug) {
            Ext.debug = debug;
        }

        public static void init(Application app) {
            if (Ext.app == null) {
                Ext.app = app;
            }
        }
    }

    private static class MockApplication extends Application {
        public MockApplication(Context baseContext) {
            this.attachBaseContext(baseContext);
        }
    }
}
