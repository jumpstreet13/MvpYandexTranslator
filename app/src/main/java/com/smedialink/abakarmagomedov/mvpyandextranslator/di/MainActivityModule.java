package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.Interactor;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.InteractorImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.Presenter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.PresenterImp;

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
    Interactor provideInteractor(WordsRepository wordsRepository, LanguagesRepository languagesRepository,
                                 Mapper<TranslateRealm, Translate> mapper){
        return new InteractorImp(wordsRepository, languagesRepository, mapper);
    }

    @LogicScope
    @Provides
    Presenter providePresenter(Interactor interactor){
        return new PresenterImp(interactor);
    }

}
