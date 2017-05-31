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
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.BaseDataStoreFactory;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStore;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreCloudImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreFactory;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource.TranslateDataStoreImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.TranslateRealmMapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepositoryImp;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.GsonManager;

import javax.inject.Singleton;

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
    TranslateDataStore<Translate> provideCloudStore(Mapper<TranslateRealm, Translate> mapper, YandexApi yandexApi) {
        return new TranslateDataStoreCloudImp(mapper, yandexApi);
    }

    @Singleton
    @NonNull
    @Provides
    @DefaultStore
    TranslateDataStore<Translate> provideBaseStore(Mapper<TranslateRealm, Translate> mapper) {
        return new TranslateDataStoreImp(mapper);
    }

    @Singleton
    @NonNull
    @Provides
    WordsRepository provideWordsRepository(BaseDataStoreFactory<TranslateDataStore<Translate>> factory){
        return  new WordsRepositoryImp(factory);
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
    BaseDataStoreFactory<TranslateDataStore<Translate>> provideTranslateDataStrore(@CloudStore TranslateDataStore<Translate> cloud, @DefaultStore TranslateDataStore<Translate> base){
        return new TranslateDataStoreFactory(base, cloud);
    }

}
