package com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smedialink.abakarmagomedov.mvpyandextranslator.App;
import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.adapter.LanguageAdapter;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.LanguageActivityModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.SharedPrefManager;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LanguageActivity extends AppCompatActivity implements LanguageView, LanguageAdapter.LanguageListener {

    @Inject LanguagePresenter presenter;
    @Inject SharedPrefManager manager;
    @BindView(R.id.language_recycler) RecyclerView recyclerView;

    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        ButterKnife.bind(this);
        LogicComponent component = (LogicComponent) App.getApp(this).getComponentsHolder()
                .getLogicComponent(getClass(), new LanguageActivityModule());
        component.inject(this);
        presenter.attachView(this);
        presenter.getLanguages();
    }


    @Override
    public void error(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void fetchLanguages(List<Language> languages) {
        LanguageAdapter adapter = new LanguageAdapter(languages, this, manager.readDescriptionFromPref());   // TODO: 31/07/17 Remove this sheet
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLanguageClick(Language language) {
        manager.writeToPref(language.getName());
        manager.writeDescriptionToPref(language.getDescription());
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
