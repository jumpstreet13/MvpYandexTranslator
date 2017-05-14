package com.smedialink.abakarmagomedov.mvpyandextranslator.di;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.Links;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.YandexApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abakarmagomedov on 14/05/17.
 */


@Module
public class NetModule {

    @Singleton
    @Provides
    YandexApi provideYandexApi(OkHttpClient client){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .baseUrl(Links.BASE_URL)
                .build().create(YandexApi.class);

    }

    @Singleton
    @NonNull
    @Provides
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        return httpClient.build();
    }

    @Singleton
    @NonNull
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }


    @Singleton
    @NonNull
    @Provides
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }


}
