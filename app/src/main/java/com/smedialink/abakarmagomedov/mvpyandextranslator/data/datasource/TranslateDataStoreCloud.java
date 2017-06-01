package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.RealmManager;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateDataStoreCloud implements TranslateDataStore {


    private final YandexApi api;
    protected final Mapper<TranslateRealm, Translate> mapper;


    public TranslateDataStoreCloud(@NonNull Mapper<TranslateRealm, Translate> mapper, YandexApi api) {
        this.mapper = mapper;
        this.api = api;
    }


    @Override
    public Observable<Translate> wordsList(HashMap<String, String> hashMap) {
        return api.getTranslate(hashMap).observeOn(Schedulers.io())
                .map(translate -> {
                    translate.setText(hashMap.get("text"));
                    return mapper.mapTo(translate);
                })
                .doOnNext(RealmManager::writeToRealm)       // TODO: 01/06/17 Throw this logic to repository
                .map(mapper::mapFrom)
                .onErrorResumeNext(throwable -> {
                    return Observable.empty();
                });

    }

}
