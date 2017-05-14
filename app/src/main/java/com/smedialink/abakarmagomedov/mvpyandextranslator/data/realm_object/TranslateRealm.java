package com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object;


import java.util.List;

import io.realm.RealmObject;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateRealm extends RealmObject {

    private String text;
    private String translate = null;


    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
