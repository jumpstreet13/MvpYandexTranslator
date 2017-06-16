package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.language_choose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.smedialink.abakarmagomedov.mvpyandextranslator.R;

import javax.inject.Inject;

import butterknife.BindView;

public class LanguageActivity extends AppCompatActivity {

    @BindView(R.id.language_recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }



}
