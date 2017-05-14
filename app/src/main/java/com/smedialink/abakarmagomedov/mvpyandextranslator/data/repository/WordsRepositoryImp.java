package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.DataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.CloudStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.DefaultStore;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class WordsRepositoryImp implements  WordsRepository {

    private DataStore<Translate> store;
    private DataStore<Translate> defaultStore;
    private DataStore<Translate> cloudStore;

    public WordsRepositoryImp(@DefaultStore @NonNull DataStore<Translate> defaultStore,
                                  @CloudStore @NonNull DataStore<Translate> cloudStore) {
        this.configKindStore(STORE.LOCAL);
        this.defaultStore = defaultStore;
        this.cloudStore = cloudStore;
    }

    @Override
    public Observable<Translate> query(HashMap<String, String> hashMap) {
        return store.wordsList(hashMap);
    }

    @Override
    public void addAll(List<Translate> discounts) {

    }

    @Override
    public WordsRepository configKindStore(STORE kind) {
        switch (kind){
            case LOCAL:
                this.store = defaultStore;
                break;
            case CLOUD:
                this.store = cloudStore;
                break;
            default:
                this.store = defaultStore;
                break;
        }
        return this;
    }
}
