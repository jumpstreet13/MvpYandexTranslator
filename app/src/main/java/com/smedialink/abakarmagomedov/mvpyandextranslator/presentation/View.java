package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import java.util.List;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface View {

    void fetchData(List<String> translate);
    void error(String error);
    void showProgress();
    void hideProgress();
}
