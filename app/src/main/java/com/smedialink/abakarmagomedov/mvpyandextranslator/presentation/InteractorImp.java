package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class InteractorImp implements Interactor {

    private final WordsRepository repository;
    private final Mapper<TranslateRealm, Translate> mapper;

    public InteractorImp(WordsRepository repository, Mapper<TranslateRealm, Translate> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Observable<Translate> getWordFromBase(HashMap<String,String> hashMap) {
        return makeObservable(WordsRepository.STORE.LOCAL, hashMap);
    }

    @Override
    public Observable<Translate> getWordFromCloud(HashMap<String,String> hashMap) {
        return makeObservable(WordsRepository.STORE.CLOUD, hashMap);
    }

    private Observable<Translate> makeObservable (WordsRepository.STORE store, HashMap<String, String> hashMap){
        return repository.configKindStore(store)
                .query(hashMap);
    }
}
