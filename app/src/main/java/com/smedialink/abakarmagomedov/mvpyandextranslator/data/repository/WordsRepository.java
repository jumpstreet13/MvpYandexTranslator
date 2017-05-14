package com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface WordsRepository {

    String LOCAL_STORE = "LOCAL_STORE";
    String NETWORK = "NETWORK";

    Observable<Translate> query (HashMap<String, String> hashMap);
    void addAll(List<Translate> discounts);
    WordsRepository configKindStore(STORE kind);

    enum STORE{
        LOCAL, CLOUD;
    }
}
