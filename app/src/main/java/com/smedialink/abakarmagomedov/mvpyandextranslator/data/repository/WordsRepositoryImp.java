package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreFactory;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreFactory;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.CloudStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DefaultStore;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class WordsRepositoryImp implements WordsRepository {

    private BaseDataStoreFactory<TranslateDataStore<Translate>> factory;

    public WordsRepositoryImp(BaseDataStoreFactory<TranslateDataStore<Translate>> factory) {
        this.factory = factory;
    }

    @Override
    public Observable<Translate> query(HashMap<String, String> hashMap) {
        TranslateDataStore<Translate> store = factory.create();
        return store.wordsList(hashMap);
    }
}
