package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation.language_choose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class LanguageActivity extends AppCompatActivity implements LanguageView {

    @Inject LanguagePresenter presenter;
    @BindView(R.id.language_recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        presenter.getLanguages();
    }


    @Override
    public void error(String error) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void fetchLanguages(List<Language> languages) {

    }
}
