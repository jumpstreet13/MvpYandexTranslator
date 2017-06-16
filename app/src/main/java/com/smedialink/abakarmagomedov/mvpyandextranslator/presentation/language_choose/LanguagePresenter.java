package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.language_choose;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public interface LanguagePresenter extends BasePresenter<LanguageView, LanguageInteractor> {

    void getLanguages();
}
