package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreCreator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.LanguageDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class LanguagesRepositoryImp implements LanguagesRepository {


    private BaseDataStoreCreator<LanguageDataStore> factory;

    public LanguagesRepositoryImp(BaseDataStoreCreator<LanguageDataStore> factory) {
        this.factory = factory;
    }

    @Override
    public Observable<List<Language>> getLanguages(StoreType type) {
        return factory.create(type).languageList();
    }
}
