package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;

import java.util.HashMap;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateDataStoreImp implements TranslateDataStore<Translate> {

    protected final Mapper<TranslateRealm, Translate> mapper;

    public TranslateDataStoreImp(@NonNull Mapper<TranslateRealm, Translate> mapper) {
       this.mapper = mapper;
    }

    @Override
    public Observable<Translate> wordsList(HashMap<String, String> hashMap) {
        return fetchCached(hashMap);
    }


    private Observable<Translate> fetchCached(HashMap<String, String> hashMap) {

        RealmConfiguration config2 = new RealmConfiguration.Builder()
                .name("default2")
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();

        TranslateRealm cachedWords = Realm.getInstance(config2)
                .where(TranslateRealm.class)
                .equalTo("text", hashMap.get("text"))
                .findFirst();

        if (cachedWords != null) {
            TranslateRealm translateRealm = new TranslateRealm();
            translateRealm.setText(cachedWords.getText());
            translateRealm.setTranslate(cachedWords.getTranslate());
            return Observable.just(translateRealm)
                    .map(mapper::mapFrom);
        }
        return Observable.empty();
    }

}
