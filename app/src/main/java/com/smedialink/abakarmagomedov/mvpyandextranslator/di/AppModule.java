package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponentBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.translate_screen.TranslateActivity;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.language_choose.LanguageActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created by abakarmagomedov on 13/05/17.
 */

@Singleton
@Module(subcomponents = {MainActivityComponent.class, LanguageActivityComponent.class})
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
    @ClassKey(TranslateActivity.class)
    @Provides
    LogicComponentBuilder provideMainActivityComponentBuilder(MainActivityComponent.Builder builder){
        return builder;
    }

    @Singleton
    @IntoMap
    @ClassKey(LanguageActivity.class)
    @Provides
    LogicComponentBuilder provideLanguageActivityComponentBuilder(LanguageActivityComponent.Builder builder){
        return builder;
    }
}
