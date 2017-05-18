package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseView;

import java.util.List;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface View extends BaseView {
    void fetchData(List<String> translate, String text);
}
