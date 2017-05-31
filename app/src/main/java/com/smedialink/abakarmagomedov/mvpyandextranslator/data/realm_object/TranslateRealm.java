package com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object;


import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateRealm extends RealmObject {

    @PrimaryKey
    private String text;
    private String translate;
    private String lang;


    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

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
