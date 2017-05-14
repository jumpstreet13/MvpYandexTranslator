package com.smedialink.abakarmagomedov.mvpyandextranslator.data.datasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface DataStore<T> {

    Observable<T> wordsList(HashMap<String, String> map);
}
