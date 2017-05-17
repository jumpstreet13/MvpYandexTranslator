package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.support.annotation.NonNull;
import android.util.Log;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.BasePresenterImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
                .doAfterTerminate(() -> getView().hideProgress())
                .subscribe(translate -> {
                      getView().fetchData(translate.getTranslate());
                }, throwable -> getView().error("No interten connection")); // TODO: 17/05/17 Should whatch what kind of issue snackBar when there is no connection
    }


    @Override
    public Disposable hasSubscription() {
        return mSubscription;
    }
}
