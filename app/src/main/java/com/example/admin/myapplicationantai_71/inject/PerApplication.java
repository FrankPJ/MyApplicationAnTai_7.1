package com.example.admin.myapplicationantai_71.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Admin on 2019/1/5.
 */
/*限定注解作用预*/
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
