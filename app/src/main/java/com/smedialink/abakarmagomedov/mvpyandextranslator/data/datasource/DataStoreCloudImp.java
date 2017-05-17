package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.ParamsManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class DataStoreCloudImp extends BaseDataStore implements DataStore<Translate> {


    private final YandexApi api;


    public DataStoreCloudImp(@NonNull Mapper<TranslateRealm, Translate> mapper, YandexApi api) {
        super(mapper);
        this.api = api;
    }

    @Override
    public Observable<Translate> wordsList(HashMap<String, String> hashMap) {
        return this.fetchResults(api.getTranslate(hashMap), hashMap);

    }
}
