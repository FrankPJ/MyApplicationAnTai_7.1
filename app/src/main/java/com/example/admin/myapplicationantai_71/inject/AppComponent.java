package com.example.admin.myapplicationantai_71.inject;

import com.example.admin.myapplicationantai_71.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Admin on 2019/1/5.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    //向子组件暴漏方法
    App getApp();

    ToastUtils getToatUtils();

    SpUtils getSpUtils();
}
