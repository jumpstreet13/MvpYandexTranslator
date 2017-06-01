package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreCreator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class WordsRepositoryImp implements WordsRepository {

    private BaseDataStoreCreator<TranslateDataStore> factory;

    public WordsRepositoryImp(BaseDataStoreCreator<TranslateDataStore> factory) {
        this.factory = factory;
    }

    @Override
    public Observable<Translate> query(HashMap<String, String> hashMap, StoreType type) {
        return factory.create(type).wordsList(hashMap);
    }

}

