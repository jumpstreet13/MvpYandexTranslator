package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;


import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenterImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class PresenterImp extends BasePresenterImp<View, Interactor> implements Presenter {

    private Disposable subscriptionTranslate, subscriptionLanguage;

    public PresenterImp(@NonNull Interactor interactor) {
        super(interactor);
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
    public void getLanguageList() {
        subscriptionLanguage = getInteractor()
                .getLanguages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(languages -> {
                    if(!languages.isEmpty()) getView().fetchLanguages(languages);
                    else getView().error("Can not download list of languages");
                    getView().hideProgress();
                });
    }


    @Override
    public Disposable hasSubscription() {
        return subscriptionTranslate;
    }
}
