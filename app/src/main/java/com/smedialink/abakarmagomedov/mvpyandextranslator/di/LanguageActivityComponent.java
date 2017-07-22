package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponentBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.language_choose.LanguageActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 23/06/17.
 */

@LanguageScope
@Subcomponent(modules = {LanguageActivityModule.class})
public interface LanguageActivityComponent extends LogicComponent<LanguageActivity> {

    @Subcomponent.Builder
    interface Builder extends LogicComponentBuilder<LanguageActivityComponent, LanguageActivityModule>{

    }

}
