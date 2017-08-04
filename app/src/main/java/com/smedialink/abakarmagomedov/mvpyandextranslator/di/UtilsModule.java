package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.gson.Gson;
import com.mobsandgeeks.saripaar.Validator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreCreator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.LanguageDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.LanguageDataStoreBase;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.LanguageDataStoreCloud;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.LanguageDataStroreCreator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreBase;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreCloud;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreCreator;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Langs;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.LangsMapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.LanguageRealmMapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.TranslateRealmMapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.LanguageRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.LanguagesRepositoryImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.GsonManager;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.SharedPrefManager;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

@Singleton
@Module
public class UtilsModule {


    @Singleton
    @NonNull
    @Provides
    SharedPrefManager provideShadredManager(Context context){
        return new SharedPrefManager(context);
    }

    @Singleton
    @NonNull
    @Provides
    GsonManager provideGsonManager(Gson gson) {
        return new GsonManager(gson);
    }

    @Singleton
    @NonNull
    @Provides
    Mapper<TranslateRealm, Translate> provideTranslateMapper(GsonManager gsonManager) {
        return new TranslateRealmMapper(gsonManager);
    }

    @Singleton
    @NonNull
    @Provides
    Mapper<LanguageRealm, Language> provideLanguageMapper() {
        return new LanguageRealmMapper();
    }

    @Singleton
    @NonNull
    @Provides
    Mapper<Langs, List<LanguageRealm>> provideLangsMapper() {
        return new LangsMapper();
    }

    @Singleton
    @NonNull
    @Provides
    @CloudStore
    TranslateDataStore provideCloudStore(Mapper<TranslateRealm, Translate> mapper, YandexApi yandexApi) {
        return new TranslateDataStoreCloud(mapper, yandexApi);
    }

    @Singleton
    @NonNull
    @Provides
    @DefaultStore
    TranslateDataStore provideBaseStore(Mapper<TranslateRealm, Translate> mapper) {
        return new TranslateDataStoreBase(mapper);
    }

    @Singleton
    @NonNull
    @Provides
    @CloudStore
    LanguageDataStore provideLanguageCloudStore(Mapper<Langs, List<LanguageRealm>> mapper,
                                                YandexApi yandexApi, Mapper<LanguageRealm, Language> langMapper) {
        return new LanguageDataStoreCloud(yandexApi, mapper, langMapper);
    }

    @Singleton
    @NonNull
    @Provides
    @DefaultStore
    LanguageDataStore provideLanguageBaseStore(Mapper<LanguageRealm, Language> mapper) {
        return new LanguageDataStoreBase(mapper);
    }


    @Singleton
    @NonNull
    @Provides
    WordsRepository provideWordsRepository(BaseDataStoreCreator<TranslateDataStore> factory){
        return  new WordsRepositoryImp(factory);
    }

    @Singleton
    @NonNull
    @Provides LanguagesRepository provideLanguagesRepository(BaseDataStoreCreator<LanguageDataStore> factory){
        return new LanguagesRepositoryImp(factory);
    }


    @Singleton
    @NonNull
    @Provides
    TextRecognizer provideTextREcognizer(Context context) {
        return new TextRecognizer.Builder(context).build();
    }


    @Singleton
    @NonNull
    @Provides
    CameraSource provideCameraSource(Context context, TextRecognizer recognizer) {
        return new CameraSource.Builder(context, recognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(15.0f)
                .setAutoFocusEnabled(true)
                .build();
    }

    @Singleton
    @NonNull
    @Provides
    Animation provideRotateAnimation(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        animation.setRepeatCount(Animation.INFINITE);
        return animation;
    }

    @Singleton
    @NonNull
    @Provides
    Validator provideValidator(Context context){
        return  new Validator(context);
    }

    @Singleton
    @NonNull
    @Provides
    BaseDataStoreCreator<TranslateDataStore> provideTranslateDataStore(@CloudStore TranslateDataStore cloud, @DefaultStore TranslateDataStore base){
        return new TranslateDataStoreCreator(base, cloud);
    }

    @Singleton
    @NonNull
    @Provides
    BaseDataStoreCreator<LanguageDataStore> provideLanguageDataStore(@CloudStore LanguageDataStore cloud, @DefaultStore LanguageDataStore base){
        return new LanguageDataStroreCreator(base, cloud);
    }

}
