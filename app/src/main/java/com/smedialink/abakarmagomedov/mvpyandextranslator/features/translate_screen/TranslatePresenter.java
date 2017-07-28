package com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;

import java.util.HashMap;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface TranslatePresenter extends BasePresenter<TranslateView, TranslateInteractor> {
    void getData(HashMap<String,String> hashMap);
}
