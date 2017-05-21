package com.smedialink.abakarmagomedov.mvpyandextranslator.presentation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.smedialink.abakarmagomedov.mvpyandextranslator.App;
import com.smedialink.abakarmagomedov.mvpyandextranslator.BaseActivity;
import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Translate;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.mapper.Mapper;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.Links;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.realm_object.TranslateRealm;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.repository.WordsRepository;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.MainActivityModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;

import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity implements View, Validator.ValidationListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Inject Validator validator;
    @Inject CameraSource camera;
    @Inject TextRecognizer recognizer;
    @Inject Presenter mPresenter;
    @Inject Animation animation;
    @NotEmpty @BindView(R.id.text) EditText englishText;
    @BindView(R.id.translate) TextView translate;
    @BindView(R.id.fbi) FloatingActionButton fba;
    private HashMap<String, String> map;


    @OnClick(R.id.fbi)
    void onFbiClick() {
        MainActivityPermissionsDispatcher.getPhotoWithCheck(this);
    }

    @OnClick(R.id.translate_button)
    void onButtonClick() {
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
        LogicComponent component = (LogicComponent) App.getApp(this).getComponentsHolder()
                .getLogicComponent(getClass(), new MainActivityModule());
        component.inject(this);
        validator.setValidationListener(this);
        mPresenter.attachView(this);
        map = new HashMap<>();
        map.put("key", Links.ACCESS_TOKEN);
        map.put("lang", "en-ru");
    }

    @Override
    public void fetchData(List<String> translate, String text) {
        if(translate == null) {
            error("No internet connection");
            return;
        }
        this.englishText.setText("");
        englishText.setText(text);
        this.translate.setText("");
        for (String s : translate) {
            this.translate.append(s);
        }
        englishText.setSelection(englishText.getText().length());
    }

    @Override
    public void error(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        fba.startAnimation(animation);
    }

    @Override
    public void hideProgress() {
        animation.cancel();
        animation.reset();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseLogicComponent(getClass());
            mPresenter.detachView();
            recognizer.release();
        }
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public void getPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            List<String> list = new ArrayList<>();
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            SparseArray<TextBlock> textBlocks = recognizer.detect(new Frame.Builder().setBitmap(imageBitmap).build());
            for (int i = 0; i < textBlocks.size(); i++) {
                TextBlock textBlock = textBlocks.get(textBlocks.keyAt(i));
                list.add(textBlock.getValue());
            }
            if(!list.isEmpty()) {
                map.put("text", list.get(0));
                mPresenter.getData(map);
            }else{
                error("I have found nothing");
            }
        }
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        error("Write a word to field");
    }
}
