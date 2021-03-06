package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseView;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public interface LanguageView extends BaseView {

    void fetchLanguages(List<Language> languages);
}
