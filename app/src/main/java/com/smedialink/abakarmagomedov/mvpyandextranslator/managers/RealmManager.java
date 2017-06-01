package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import android.util.Log;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;


/**
 * Created by abakarmagomedov on 13/05/17.
 */

public class RealmManager {

    public static <T extends RealmObject> void writeToRealm(final T translateRealm){
        Realm.getDefaultInstance().
                executeTransaction(realm -> realm.copyToRealmOrUpdate(translateRealm));
    }
}
