package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponentBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created by abakarmagomedov on 13/05/17.
 */

@Singleton
@Module(subcomponents = {LogicaComponent.class})
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Singleton
    @NonNull
    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @IntoMap
    @ClassKey(MainActivity.class)
    @Provides
    LogicComponentBuilder provideLogicComponentBuilder(LogicaComponent.Builder builder){
        return builder;
    }
}
