package com.smedialink.abakarmagomedov.mvpyandextranslator.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Abocha on 22.07.2017.
 */

public class SharedPrefManager {

    private final static String TRANSLATE_LANG = "tranlate_lang";
    private final static String DESCRIPTION_LANG = "description_lang";
    private SharedPreferences sharedPreference;

    public SharedPrefManager(Context context) {
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void writeToPref(String lang){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(TRANSLATE_LANG, lang);
        editor.apply();
    }

    public void writeDescriptionToPref(String lang){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(DESCRIPTION_LANG, lang);
        editor.apply();
    }

    public String readDescriptionFromPref(){
        return sharedPreference.getString(DESCRIPTION_LANG, "English");
    }

    public String readFromPref(){
        return sharedPreference.getString(TRANSLATE_LANG, "en");    // TODO: 31/07/17 Put here GSONMANAGER
    }

}
