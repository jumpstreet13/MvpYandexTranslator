package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.translate_screen;


import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateInteractorImp implements TranslateInteractor {

    private final WordsRepository wordsRepository;

    public TranslateInteractorImp(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @Override
    public Observable<Translate> getWord(HashMap<String, String> hashMap) {
        return wordsRepository.query(hashMap, StoreType.DB).mergeWith(wordsRepository.query(hashMap, StoreType.CLOUD));
    }
}
