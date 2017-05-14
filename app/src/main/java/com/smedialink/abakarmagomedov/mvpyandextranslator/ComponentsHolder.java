package com.smedialink.abakarmagomedov.mvpyandextranslator;

import android.content.Context;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.AppComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.AppModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DaggerAppComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.LogicaComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponentBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicModule;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by abakarmagomedov on 14/05/17.
 */

public class ComponentsHolder {

    private final Context mContext;

    @Inject
    Map<Class<?>, Provider<LogicComponentBuilder>> builders;

    private Map<Class<?>, LogicComponent> components;
    private AppComponent appComponent;


    public ComponentsHolder(Context context) {
        mContext = context;
    }

    void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(mContext)).build();
        appComponent.injectComponentsHolder(this);
        components = new HashMap<>();
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }

    public LogicComponent getLogicComponent(Class<?> cls) {
        return getLogicComponent(cls, null);
    }

    public LogicComponent getLogicComponent(Class<?> cls, LogicModule logicModule) {
        LogicComponent logicComponent = components.get(cls);
        if (logicComponent == null) {
            LogicComponentBuilder builder = builders.get(cls).get();
            if (logicModule != null) {
                builder.module(logicModule);
            }
            logicComponent = builder.build();
            components.put(cls, logicComponent);
        }
        return logicComponent;
    }

    public void releaseLogicComponent(Class<?> cls){
        components.put(cls, null);
    }

}
