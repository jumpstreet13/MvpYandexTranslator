package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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
        mSubscription = Observable.concat(mInteractor.getWordFromBase(hashMap), mInteractor.getWordFromCloud(hashMap))
                .first(new Translate())
                .subscribe(translate -> {
                    mView.fetchData(translate.getTranslate());
                });
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
