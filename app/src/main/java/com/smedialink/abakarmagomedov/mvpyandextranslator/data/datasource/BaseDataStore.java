package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.RealmManager;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public abstract class BaseDataStore {

    protected final Mapper<TranslateRealm, Translate> mapper;

    public BaseDataStore(@NonNull Mapper<TranslateRealm, Translate> mapper) {
        this.mapper = mapper;
    }

    Observable<Translate> fetchResults(Observable<Translate> observable){
        return observable.observeOn(Schedulers.computation())
                .map(mapper::mapTo)
                .doOnNext(RealmManager::writeToRealm)
                .map(mapper::mapFrom);
    }
}
