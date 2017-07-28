package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public interface LanguagePresenter extends BasePresenter<LanguageView, LanguageInteractor> {

    void getLanguages();
}
