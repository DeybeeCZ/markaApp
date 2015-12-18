package com.markplace.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.markplace.parse.Usuario;
import com.parse.Parse;

/**
 * Created by deybee on 27/11/15.
 */
public class Configuration extends Application {
    public static Usuario user;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
        user = new Usuario();
    }
}
