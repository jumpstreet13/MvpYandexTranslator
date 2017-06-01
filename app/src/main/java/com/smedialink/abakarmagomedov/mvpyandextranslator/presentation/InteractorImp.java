package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class InteractorImp implements Interactor {

    private final WordsRepository wordsRepository;
    private final LanguagesRepository languagesRepository;
    private final Mapper<TranslateRealm, Translate> mapper;

    public InteractorImp(WordsRepository wordsRepository, LanguagesRepository languagesRepository,
                         Mapper<TranslateRealm, Translate> mapper) {
        this.wordsRepository = wordsRepository;
        this.languagesRepository = languagesRepository;
        this.mapper = mapper;
    }

    @Override
    public Observable<Translate> getWord(HashMap<String, String> hashMap) {
        return wordsRepository.query(hashMap, StoreType.DB).mergeWith(wordsRepository.query(hashMap, StoreType.CLOUD));
    }

    @Override
    public Observable<List<Language>> getLanguages() {
        return languagesRepository.getLanguages(StoreType.DB).mergeWith(languagesRepository.getLanguages(StoreType.CLOUD));
    }
}
