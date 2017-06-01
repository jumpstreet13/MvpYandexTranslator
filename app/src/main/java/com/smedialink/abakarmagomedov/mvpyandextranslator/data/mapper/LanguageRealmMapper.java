package com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper;

import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Langs;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.LanguageRealm;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class LanguageRealmMapper implements Mapper<LanguageRealm, Language> {


    @Override
    public LanguageRealm mapTo(Language language) {
        LanguageRealm languageRealm = new LanguageRealm();
        languageRealm.setName(language.getName());
        languageRealm.setDescription(language.getDescription());
        return languageRealm;
    }

    @Override
    public Language mapFrom(LanguageRealm languageRealm) {
        Language language = new Language();
        language.setName(languageRealm.getName());
        language.setDescription(languageRealm.getDescription());
        return language;
    }
}
