package com.example.admin.myapplicationantai_71;

import android.app.Application;

import com.example.admin.myapplicationantai_71.inject.AppComponent;
import com.example.admin.myapplicationantai_71.inject.AppModule;
import com.example.admin.myapplicationantai_71.inject.DaggerAppComponent;


/**
 * Created by Admin on 2019/1/5.
 */

public class App extends Application {


    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();


    }
}
