package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class InteractorImp implements Interactor {

    private final WordsRepository wordsRepository;

    public InteractorImp(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @Override
    public Observable<Translate> getWord(HashMap<String, String> hashMap) {
        return wordsRepository.query(hashMap, StoreType.DB).mergeWith(wordsRepository.query(hashMap, StoreType.CLOUD));
    }
}
