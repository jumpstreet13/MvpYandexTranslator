package com.smedialink.abakarmagomedov.mvpyandextranslator;

/**
 * Created by abakarmagomedov on 17/05/17.
 */

public interface BasePresenter<V extends BaseView, IC extends BaseInteractor> {

    void attachView(V v);
    void detachView();
    V getView();
    IC getInteractor();

}
