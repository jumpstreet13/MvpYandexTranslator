package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;
import android.util.Log;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateDataStoreImp implements TranslateDataStore {

    protected final Mapper<TranslateRealm, Translate> mapper;

    public TranslateDataStoreImp(@NonNull Mapper<TranslateRealm, Translate> mapper) {
       this.mapper = mapper;
    }

    @Override
    public Observable<Translate> wordsList(HashMap<String, String> hashMap) {
        return fetchCached(hashMap);
    }

    private Observable<Translate> fetchCached(HashMap<String, String> hashMap) {

        List<TranslateRealm> list = Realm.getDefaultInstance().where(TranslateRealm.class).findAll();
        for (TranslateRealm translateRealm : list) {
            Log.d("INFO", translateRealm.getText() + " - " + translateRealm.getLang() + " - " + translateRealm.getTranslate());
        }

        TranslateRealm cachedWords = Realm.getDefaultInstance()
                .where(TranslateRealm.class)
                .equalTo("lang", hashMap.get("lang"))
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
