package com.smedialink.abakarmagomedov.mvpyandextranslator;

import io.reactivex.disposables.Disposable;

/**
 * Created by abakarmagomedov on 17/05/17.
 */

public interface BaseView {

    void error(String error);
    void showProgress();
    void hideProgress();

}
