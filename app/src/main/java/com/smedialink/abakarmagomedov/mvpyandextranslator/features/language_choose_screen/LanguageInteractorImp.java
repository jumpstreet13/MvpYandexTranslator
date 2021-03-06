package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.StoreType;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by abakarmagomedov on 16/06/17.
 */

public class LanguageInteractorImp implements LanguageInteractor {

    private final LanguagesRepository languagesRepository;

    public LanguageInteractorImp(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    @Override
    public Observable<List<Language>> getLanguages() {
        return languagesRepository.getLanguages(StoreType.DB)
                .mergeWith(languagesRepository.getLanguages(StoreType.CLOUD))
                .map(languages -> {
                    for (Language language : languages) {
                        language.setDescription(language.getDescription().substring(1, language.getDescription().length() - 1));
                    }
                    return languages;
                });
    }
}
