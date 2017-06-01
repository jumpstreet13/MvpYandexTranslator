package com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 01/06/17.
 */

public class LanguageRealm extends RealmObject {

    @PrimaryKey
    private String description;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
