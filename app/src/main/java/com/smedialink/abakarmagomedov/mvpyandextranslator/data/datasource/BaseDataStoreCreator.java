package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public interface BaseDataStoreCreator<STORE> {

    STORE create(StoreType type);

}
