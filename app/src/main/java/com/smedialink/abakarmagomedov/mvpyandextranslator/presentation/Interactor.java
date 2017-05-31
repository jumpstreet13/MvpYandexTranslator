package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseInteractor;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface Interactor extends BaseInteractor {

    Observable<Translate> getWord(HashMap<String,String> hashMap);
}
