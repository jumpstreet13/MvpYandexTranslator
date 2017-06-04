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
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LanguageDataStroreCloud implements LanguageDataStore {


    private final YandexApi api;
    private final Mapper<Langs, List<LanguageRealm>> realmMapper;
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
                    List<Language> languages = new ArrayList<>();
                    for (LanguageRealm languageRealm : languageRealms) {
                        Language lang = langMapper.mapFrom(languageRealm);
                        lang.setDescription(lang.getDescription().replace("\'", ""));
                        languages.add(lang);
                    }
                    return languages;
                }).onErrorResumeNext(throwable -> {
                    return Observable.empty();
                });
    }
}
