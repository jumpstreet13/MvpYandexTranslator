package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.DataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.DataStoreCloudImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.DataStoreImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.TranslateRealmMapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.GsonManager;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

@Singleton
@Module
public class UtilsModule {


    @Singleton
    @NonNull
    @Provides
    GsonManager provideGsonManager(Gson gson) {
        return new GsonManager(gson);
    }

    @Singleton
    @NonNull
    @Provides
    Mapper<TranslateRealm, Translate> provideMapper(GsonManager gsonManager) {
        return new TranslateRealmMapper(gsonManager);
    }

    @Singleton
    @NonNull
    @Provides
    @CloudStore
    DataStore<Translate> provideCloudStore(Mapper<TranslateRealm, Translate> mapper, YandexApi yandexApi) {
        return new DataStoreCloudImp(mapper, yandexApi);
    }

    @Singleton
    @NonNull
    @Provides
    @DefaultStore
    DataStore<Translate> provideBaseStore(Mapper<TranslateRealm, Translate> mapper) {
        return new DataStoreImp(mapper);
    }


    @Singleton
    @NonNull
    @Provides
    WordsRepository provideWordsRepository(@CloudStore DataStore<Translate> cloud, @DefaultStore DataStore<Translate> base) {
        return new WordsRepositoryImp(cloud, base);
    }
}
