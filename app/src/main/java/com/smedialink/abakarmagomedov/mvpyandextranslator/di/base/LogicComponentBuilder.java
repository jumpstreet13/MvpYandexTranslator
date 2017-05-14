package com.smedialink.abakarmagomedov.mvpyandextranslator.di.base;

/**
 * Created by abakarmagomedov on 14/05/17.
 */

public interface LogicComponentBuilder<C extends LogicComponent, M extends LogicModule>  {

    C build();
    LogicComponentBuilder<C,M> module(M module);

}
