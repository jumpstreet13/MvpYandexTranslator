package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseInteractor;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public interface LanguageInteractor extends BaseInteractor {
    Observable<List<Language>> getLanguages();
}
