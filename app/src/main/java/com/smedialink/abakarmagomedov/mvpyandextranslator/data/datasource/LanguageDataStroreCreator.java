package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.di.CloudStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DefaultStore;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LanguageDataStroreCreator implements BaseDataStoreCreator<LanguageDataStore> {

    private LanguageDataStore defaultStore;
    private LanguageDataStore cloudStore;

    public LanguageDataStroreCreator(@DefaultStore LanguageDataStore defaultStore,
                                     @CloudStore LanguageDataStore cloudStore) {
        this.defaultStore = defaultStore;
        this.cloudStore = cloudStore;
    }


    @Override
    public LanguageDataStore create(StoreType type) {
        LanguageDataStore output;
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
