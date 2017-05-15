package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;

import java.util.HashMap;

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
        TranslateRealm cachedWords = Realm.getDefaultInstance()
                .where(TranslateRealm.class)
                .equalTo("text", hashMap.get("text"))
                .findFirst();

        if(cachedWords != null) {
            return Observable.just(cachedWords)
                    .map(mapper::mapFrom);
        }
        return Observable.empty();
    }
}
