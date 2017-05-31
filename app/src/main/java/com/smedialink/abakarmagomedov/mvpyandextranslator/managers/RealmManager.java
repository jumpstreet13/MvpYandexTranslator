package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import android.util.Log;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by abakarmagomedov on 13/05/17.
 */

public class RealmManager {


    public static void writeToRealm(final TranslateRealm translateRealm){

        Realm.getDefaultInstance().
                executeTransaction(realm -> realm.copyToRealmOrUpdate(translateRealm));
    }

}
