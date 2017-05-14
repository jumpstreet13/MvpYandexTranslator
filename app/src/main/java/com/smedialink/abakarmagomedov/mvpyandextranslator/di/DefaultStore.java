package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


/**
 * Created by Oleg Shelyakin on 07/02/17.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultStore {
}
