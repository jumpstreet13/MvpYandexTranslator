package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenterImp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public class LanguagePresenterImp extends BasePresenterImp<LanguageView, LanguageInteractor> implements LanguagePresenter {

    private Disposable subscriptionLanguage;

    public LanguagePresenterImp(@NonNull LanguageInteractor interactor) {
        super(interactor);
    }

    @Override
    public Disposable hasSubscription() {
        return null;
    }

    @Override
    public void getLanguages() {
        subscriptionLanguage = getInteractor()    // TODO: 16/06/17 Resolve subscription hell
                .getLanguages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(languages -> {
                    if(!languages.isEmpty()) getView().fetchLanguages(languages);
                    else getView().error("Can not download list of languages");
                    getView().hideProgress();
                });
    }
}
