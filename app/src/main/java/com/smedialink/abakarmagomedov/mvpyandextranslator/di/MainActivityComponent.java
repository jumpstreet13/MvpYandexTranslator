package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponentBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.translate_screen.TranslateActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 13/05/17.
 */


@LogicScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent extends LogicComponent<TranslateActivity>{

    @Subcomponent.Builder
    interface Builder extends LogicComponentBuilder<MainActivityComponent, MainActivityModule>{

    }

}
