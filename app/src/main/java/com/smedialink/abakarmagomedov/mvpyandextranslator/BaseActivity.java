package com.smedialink.abakarmagomedov.mvpyandextranslator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by abakarmagomedov on 21/05/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void start(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    protected void startForRes(Class<?> cls, int requestCode) {
        startActivityForResult(new Intent(this, cls), requestCode);
    }
}
