package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import java.util.HashMap;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface Presenter {

    void getData(HashMap<String,String> hashMap);
    void attachView(View view);
    void detachView();
}
