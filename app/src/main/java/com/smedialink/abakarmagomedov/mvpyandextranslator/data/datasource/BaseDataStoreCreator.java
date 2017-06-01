package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public interface BaseDataStoreCreator<STORE> {

    STORE create(StoreType type);

}
