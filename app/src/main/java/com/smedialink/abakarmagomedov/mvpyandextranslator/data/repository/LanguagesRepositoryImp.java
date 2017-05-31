package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreFactory;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class LanguagesRepositoryImp implements LanguagesRepository {


    /*private BaseDataStoreFactory<LanguagesDataStore<Language>> factory;

    public LanguagesRepositoryImp(BaseDataStoreFactory<LanguagesDataStore<Language>> factory) {
        this.factory = factory;
    }*/

    @Override
    public Observable<Language> getLanguages() {
        return null;
    }
}
