package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.CloudStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DefaultStore;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class TranslateDataStoreFactory implements BaseDataStoreCreator<TranslateDataStore> {

    private TranslateDataStore output;
    private TranslateDataStore defaultStore;
    private TranslateDataStore cloudStore;

    public TranslateDataStoreFactory(@DefaultStore @NonNull TranslateDataStore defaultStore,
                                     @CloudStore @NonNull TranslateDataStore cloudStore) {
        this.defaultStore = defaultStore;
        this.cloudStore = cloudStore;
    }

    @Override
    public TranslateDataStore create(WordsRepositoryImp.StoreType type) {
        switch (type) {
            case CLOUD:
                output = cloudStore;
                break;
            case DB:
                output = defaultStore;
                break;
            default:
                output = defaultStore;
        }
        return output;
    }
}
