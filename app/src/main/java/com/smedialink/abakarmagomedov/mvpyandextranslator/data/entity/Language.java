package com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class Language {

    private transient String name;
    private transient String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
