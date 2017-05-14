package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class GsonManager {

    private Gson mGson;

    public GsonManager(Gson gson) {
        mGson = gson;
    }

    public String toJson(List<String> to){
        return  mGson.toJson(to);
    }

    public List<String> fromJson(String json){
        return  mGson.fromJson(json, new TypeToken<List<String>>(){}.getType());
    }
}
