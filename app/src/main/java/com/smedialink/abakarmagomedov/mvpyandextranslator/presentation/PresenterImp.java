package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import android.util.Log;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class PresenterImp implements Presenter {

    private Disposable mSubscription;
    private Interactor mInteractor;
    private View mView;


    public PresenterImp(Interactor interactor) {
        mInteractor = interactor;
    }


    @Override
    public void getData(HashMap<String, String> hashMap) {
        mSubscription = Observable.merge(mInteractor.getWordFromBase(hashMap), mInteractor.getWordFromCloud(hashMap))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .first(new Translate())
                .subscribe(new Consumer<Translate>() {
                    @Override
                    public void accept(Translate translate) throws Exception {
                        if(translate.getTranslate() == null) mView.error("word has not been found");
                        else mView.fetchData(translate.getTranslate());
                    }
                }, Throwable::printStackTrace);
    }

    @Override
    public void attachView(View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        if(!mSubscription.isDisposed()) mSubscription.dispose();
    }
}
