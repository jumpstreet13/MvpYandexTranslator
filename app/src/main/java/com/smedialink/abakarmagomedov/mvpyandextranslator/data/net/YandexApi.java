package com.smedialink.abakarmagomedov.mvpyandextranslator.data.net;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface YandexApi {

    @GET("api/v1.5/tr.json/translate?")
    Observable<Translate> getTranslate(@QueryMap HashMap<String, String> map);

}
