package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.ParamsManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.realm.Realm;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class DataStoreImp extends BaseDataStore implements DataStore<Translate> {


    public DataStoreImp(@NonNull Mapper<TranslateRealm, Translate> mapper) {
        super(mapper);
    }

    @Override
    public Observable<Translate> wordsList(HashMap<String, String> hashMap) {
        return this.fetchResults(fetchCached(hashMap));
    }


    private Observable<Translate> fetchCached(HashMap<String,String> hashMap) {
        TranslateRealm cachedDiscounts = Realm.getDefaultInstance()
                .where(TranslateRealm.class)
                .equalTo("text", hashMap.get("text"))
                .findFirst();

        return Observable.just(cachedDiscounts)
                .map(mapper::mapFrom);
    }
}
