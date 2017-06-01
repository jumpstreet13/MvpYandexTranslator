package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.LanguageRealm;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.realm.Realm;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LanguageDataStoreBase implements LanguageDataStore {

    private Mapper<LanguageRealm, Language> mapper;

    public LanguageDataStoreBase(Mapper<LanguageRealm, Language> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Observable<List<Language>> languageList() {
        List<LanguageRealm> realRealm = new ArrayList<>();
        List<LanguageRealm> cacheLanguages = Realm.getDefaultInstance()
                .where(LanguageRealm.class)
                .findAll();

        if (cacheLanguages != null) {
            for (LanguageRealm cacheLanguage : cacheLanguages) {
                LanguageRealm realm = new LanguageRealm();
                realm.setName(cacheLanguage.getName());
                realm.setDescription(cacheLanguage.getDescription());
                realRealm.add(realm);
            }
            return Observable.fromArray(cacheLanguages)
                    .map(languageRealms -> {
                        List<Language> languages = new ArrayList<>();
                        for (LanguageRealm language : realRealm) {
                            languages.add(mapper.mapFrom(language));
                        }
                        return languages;
                    });

        }
        return Observable.empty();
    }
}
