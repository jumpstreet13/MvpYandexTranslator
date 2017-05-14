package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.ComponentsHolder;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

@Singleton
@Component(modules = {UtilsModule.class, AppModule.class, NetModule.class})
public interface AppComponent {

    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
