package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;

import java.util.HashMap;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface Presenter extends BasePresenter<View, Interactor> {
    void getData(HashMap<String,String> hashMap);
}
