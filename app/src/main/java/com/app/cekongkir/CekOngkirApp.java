package com.app.cekongkir;

import android.app.Application;
import android.content.Context;

/**
 * Created by islam on 18/09/17.
 */

public class CekOngkirApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
