package com.example.admin.myapplicationantai_71.inject;

import android.support.annotation.NonNull;

import com.example.admin.myapplicationantai_71.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 2019/1/5.
 */
@PerApplication
@Module
public class AppModule {

    private App mApp;

    public AppModule(@NonNull App app) {

        mApp = app;
    }

    @Singleton
    @Provides
    App provideApp() {

        return mApp;
    }

    @Provides
    @Singleton
    ToastUtils provideToastUtils() {

        return new ToastUtils(mApp);
    }

    @Provides
    @Singleton
    SpUtils provideSpUtils() {


        return new SpUtils(mApp);
    }
}
