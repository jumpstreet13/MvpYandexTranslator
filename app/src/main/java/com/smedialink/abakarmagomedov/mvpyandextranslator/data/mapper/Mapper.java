package com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper;

/**
 * Created by abakarmagomedov on 12/05/17.
 */

public interface Mapper<TO, FROM> {
    TO mapTo(FROM from);
    FROM mapFrom(TO to);
}
