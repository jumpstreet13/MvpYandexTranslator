package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen.TranslateInteractor;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen.TranslateInteractorImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen.TranslatePresenter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen.TranslatePresenterImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 14/05/17.
 */


@LogicScope
@Module
public class MainActivityModule implements LogicModule {


    @LogicScope
    @Provides
    TranslateInteractor provideInteractor(WordsRepository wordsRepository){
        return new TranslateInteractorImp(wordsRepository);
    }

    @LogicScope
    @Provides
    TranslatePresenter providePresenter(TranslateInteractor translateInteractor){
        return new TranslatePresenterImp(translateInteractor);
    }
}
