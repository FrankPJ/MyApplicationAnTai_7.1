package com.example.admin.myapplicationantai_71.inject;

import com.example.admin.myapplicationantai_71.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 2019/1/5.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void infdt(MainActivity mainActivity);
    void inject(ToastUtils toastUtils);
}
