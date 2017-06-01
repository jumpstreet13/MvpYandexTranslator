package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import io.realm.Realm;
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
