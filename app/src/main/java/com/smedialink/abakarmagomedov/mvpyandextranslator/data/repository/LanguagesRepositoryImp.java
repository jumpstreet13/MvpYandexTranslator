package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class LanguagesRepositoryImp implements LanguagesRepository {


    /*private BaseDataStoreCreator<LanguagesDataStore<Language>> factory;

    public LanguagesRepositoryImp(BaseDataStoreCreator<LanguagesDataStore<Language>> factory) {
        this.factory = factory;
    }*/

    @Override
    public Observable<Language> getLanguages() {
        return null;
    }
}
