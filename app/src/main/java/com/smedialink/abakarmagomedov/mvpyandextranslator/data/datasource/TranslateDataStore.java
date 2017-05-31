package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface TranslateDataStore {

    Observable<Translate> wordsList(HashMap<String, String> map);
}
