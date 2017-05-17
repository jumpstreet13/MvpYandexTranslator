package com.smedialink.abakarmagomedov.mvpyandextranslator;

import android.support.annotation.NonNull;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.Disposable;

/**
 * Created by abakarmagomedov on 17/05/17.
 */

public abstract class BasePresenterImp<V extends BaseView, IC extends BaseInteractor> implements BasePresenter<V, IC>, HasSubscription<Disposable> {

    private V view;
    private final IC interactor;

    public BasePresenterImp( @NonNull IC interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(V v) {
        this.view = v;
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public IC getInteractor() {
        return interactor;
    }

    protected void unSubscribe(){
        if (hasSubscription() != null && !hasSubscription().isDisposed()){
            hasSubscription().dispose();
        }
    }


}
