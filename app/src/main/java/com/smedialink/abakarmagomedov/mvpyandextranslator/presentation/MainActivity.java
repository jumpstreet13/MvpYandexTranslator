package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.smedialink.abakarmagomedov.mvpyandextranslator.App;
import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.MainActivityModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View {

    @Inject Presenter mPresenter;
    @BindView(R.id.text) EditText englishText;
    @BindView(R.id.translate) EditText translate;
    private HashMap<String, String> map;


    @OnClick(R.id.button)
    public void onButtonClick(){
        map.put("text", englishText.getText().toString());
        mPresenter.getData(map);
        Log.d("Click", "clicked");
    }

    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LogicComponent component = (LogicComponent) App.getApp(this).getComponentsHolder().getLogicComponent(getClass(), new MainActivityModule());
        component.inject(this);
        mPresenter.attachView(this);
        map = new HashMap<>();
        map.put("key", "trnsl.1.1.20170504T104836Z.704d64c90ed3fc09.0c073c975fdca419ff33264c65a2fd744454e99b");
        map.put("lang", "en-ru");
    }

    @Override
    public void fetchData(List<String> translate) {
        this.translate.setText("");
        for (String s : translate) {
            this.translate.append(s);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseLogicComponent(getClass());
        }
    }
}
