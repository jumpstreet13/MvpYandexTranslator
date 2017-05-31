package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.CloudStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DefaultStore;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class TranslateDataStoreFactory implements BaseDataStoreFactory<TranslateDataStore<Translate>> {

    private TranslateDataStore<Translate> store;
    private TranslateDataStore<Translate> defaultStore;
    private TranslateDataStore<Translate> cloudStore;

    public TranslateDataStoreFactory(@DefaultStore @NonNull TranslateDataStore<Translate> defaultStore,
                              @CloudStore @NonNull TranslateDataStore<Translate> cloudStore) {
        this.defaultStore = defaultStore;
        this.cloudStore = cloudStore;
    }

    @Override
    public TranslateDataStore<Translate> create() {
        return defaultStore;
    }
}
