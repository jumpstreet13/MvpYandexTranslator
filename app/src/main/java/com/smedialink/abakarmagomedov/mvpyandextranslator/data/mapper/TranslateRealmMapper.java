package com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper;

import com.google.gson.Gson;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.GsonManager;

import javax.inject.Inject;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public class TranslateRealmMapper implements Mapper<TranslateRealm, Translate> {

    private final GsonManager mGson;

    public TranslateRealmMapper(GsonManager gson) {
        mGson = gson;
    }

    @Override
    public TranslateRealm mapTo(Translate translate) {
        TranslateRealm translateRealm = new TranslateRealm();
        translateRealm.setText(translate.getText());
        translateRealm.setTranslate(mGson.toJson(translate.getTranslate()));
        return translateRealm;
    }

    @Override
    public Translate mapFrom(TranslateRealm translateRealm) {
        return null;
    }
}
