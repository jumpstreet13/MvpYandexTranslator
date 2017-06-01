package com.smedialink.abakarmagomedov.mvpyandextranslator.data.net;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.YandexResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface YandexApi {

    @GET("api/v1.5/tr.json/translate?")
    Observable<Translate> getTranslate(@QueryMap HashMap<String, String> map);


    @POST("https://translate.yandex.net/api/v1.5/tr.json/getLangs?ui=en&key=trnsl.1.1.20170504T104836Z.704d64c90ed3fc09.0c073c975fdca419ff33264c65a2fd744454e99b")
    Observable<YandexResponse> getLanguages();

}
