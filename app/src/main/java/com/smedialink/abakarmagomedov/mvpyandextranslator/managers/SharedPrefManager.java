package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Abocha on 22.07.2017.
 */

public class SharedPrefManager {

    private final static String TRANSLATE_LANG = "tranlate_lang";
    private SharedPreferences sharedPreference;

    public SharedPrefManager(Context context) {
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void writeToPref(String lang){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(TRANSLATE_LANG, lang);
        editor.apply();
    }

    public String readFromPref(){
        return sharedPreference.getString(TRANSLATE_LANG, "en");
    }

}
