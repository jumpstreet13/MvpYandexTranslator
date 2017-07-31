package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public interface LanguageDataStore {

    Observable<List<Language>> languageList();
}
