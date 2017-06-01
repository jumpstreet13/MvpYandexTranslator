package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Langs;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.LanguageRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.RealmManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LanguageDataStroreCloud implements LanguageDataStore {


    private final YandexApi api;
    protected final Mapper<Langs, List<LanguageRealm>> realmMapper;
    private Mapper<LanguageRealm, Language> langMapper;


    public LanguageDataStroreCloud(YandexApi api, Mapper<Langs, List<LanguageRealm>> mapper, Mapper<LanguageRealm, Language> langMapper) {
        this.api = api;
        this.realmMapper = mapper;
        this.langMapper = langMapper;
    }


    @Override
    public Observable<List<Language>> languageList() {
        return api.getLanguages()
                .map(yandexResponse -> realmMapper.mapFrom(yandexResponse.getLangs()))
                .doOnNext(languageRealms -> {
                    for (LanguageRealm languageRealm : languageRealms) {
                        RealmManager.writeToRealm(languageRealm);
                    }
                }).map(languageRealms -> {
                    List<Language> languages = new ArrayList<Language>();
                    for (LanguageRealm languageRealm : languageRealms) {
                        languages.add(langMapper.mapFrom(languageRealm));
                    }
                    return languages;
                });
    }
}
