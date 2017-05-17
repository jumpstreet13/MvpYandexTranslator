package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.support.annotation.NonNull;
import android.util.Log;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenterImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class PresenterImp extends BasePresenterImp<View, Interactor> implements Presenter {

    private Disposable mSubscription;

    public PresenterImp(@NonNull Interactor interactor) {
        super(interactor);
    }


    @Override
    public void getData(HashMap<String, String> hashMap) {
        mSubscription = Observable.merge(getInteractor().getWordFromBase(hashMap), getInteractor().getWordFromCloud(hashMap))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showProgress())
                .doOnTerminate(() -> getView().hideProgress())
                .first(new Translate())
                .subscribe(translate -> {
                    if(translate.getTranslate() == null) getView().error("word has not been found");
                    else getView().fetchData(translate.getTranslate());
                }, Throwable::printStackTrace);
    }


    @Override
    public Disposable hasSubscription() {
        return mSubscription;
    }
}
