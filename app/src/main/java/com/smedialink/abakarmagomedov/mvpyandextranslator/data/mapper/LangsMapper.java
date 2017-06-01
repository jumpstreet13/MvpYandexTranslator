package com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Langs;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.LanguageRealm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LangsMapper implements Mapper<Langs, List<LanguageRealm>> {


    @Override
    public Langs mapTo(List<LanguageRealm> languageRealms) {
        return null;
    }

    @Override
    public List<LanguageRealm> mapFrom(Langs langs) {
        List<LanguageRealm> realms = new ArrayList<>();
        String info = langs.toString();
        String[] languages = info.split(",");
        for (String language : languages) {
            LanguageRealm languageRealm = new LanguageRealm();
            String[] details = language.split("=");
            languageRealm.setName(details[0]);
            languageRealm.setDescription(details[1]);
            realms.add(languageRealm);
        }
        return realms;
    }
}
