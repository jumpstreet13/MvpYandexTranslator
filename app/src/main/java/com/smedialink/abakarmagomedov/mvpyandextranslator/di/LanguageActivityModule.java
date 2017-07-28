package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen.LanguageInteractor;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen.LanguageInteractorImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen.LanguagePresenter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen.LanguagePresenterImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 19/06/17.
 */


@LanguageScope
@Module
public class LanguageActivityModule implements LogicModule {

    @LanguageScope
    @Provides
    LanguagePresenter provideLanguagePresenter(LanguageInteractor interactor){
        return  new LanguagePresenterImp(interactor);
    }

    @LanguageScope
    @Provides
    LanguageInteractor provideLanguageInteractor(LanguagesRepository repository){
        return new LanguageInteractorImp(repository);
    }
}
