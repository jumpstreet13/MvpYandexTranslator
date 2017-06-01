package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseView;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface View extends BaseView {
    void fetchData(List<String> translate, String text);
    void fetchLanguages(List<Language> languages);
}
