package com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen;


import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenterImp;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslatePresenterImp extends BasePresenterImp<TranslateView, TranslateInteractor> implements TranslatePresenter {

    private Disposable subscriptionTranslate;

    public TranslatePresenterImp(@NonNull TranslateInteractor translateInteractor) {
        super(translateInteractor);
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        subscriptionTranslate = getInteractor()
                .getWord(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showProgress())
                .doOnNext(translate -> getView().fetchData(translate.getTranslate(), translate.getText()))
                .any(translate -> (translate != null))
                .subscribe(aBoolean -> {
                    if(!aBoolean) getView().error("No internet connection");
                    getView().hideProgress();
                });
    }


    @Override
    public Disposable hasSubscription() {
        return subscriptionTranslate;
    }
}
