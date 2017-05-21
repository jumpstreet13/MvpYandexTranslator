package com.smedialink.abakarmagomedov.mvpyandextranslator;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.Inspector;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.AppComponent;

import io.realm.Realm;
import io.realm.annotations.RealmModule;
import io.realm.internal.RealmProxyMediator;

/**
 * Created by abakarmagomedov on 14/05/17.
 */

public class App extends Application {

    private ComponentsHolder componentsHolder;

    public static App getApp(Context context) {
        return (App)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);


        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }

    public ComponentsHolder getComponentsHolder() {
        return componentsHolder;
    }
}
