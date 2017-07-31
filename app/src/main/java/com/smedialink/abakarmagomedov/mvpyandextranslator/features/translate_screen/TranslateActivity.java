package com.smedialink.abakarmagomedov.mvpyandextranslator.features.translate_screen;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.util.SparseArray;
import android.view.animation.Animation;
import android.widget.EditText;
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
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.net.Links;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.MainActivityModule;
import com.smedialink.abakarmagomedov.mvpyandextranslator.di.base.LogicComponent;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.SharedPrefManager;
import com.smedialink.abakarmagomedov.mvpyandextranslator.features.language_choose_screen.LanguageActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class TranslateActivity extends BaseActivity implements TranslateView, Validator.ValidationListener{

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_LANGUAGE_TO_TRANSLATE = 2;
    @Inject SharedPrefManager manager;
    @Inject CameraSource camera;
    @Inject TextRecognizer recognizer;
    @Inject TranslatePresenter mTranslatePresenter;
    @Inject Animation animation;
    @NotEmpty @BindView(R.id.text) EditText englishText;
    @BindView(R.id.translate) TextView translate;
    @BindView(R.id.fbi_photo) FloatingActionButton fbi_photo;
    @BindView(R.id.fbi_language) FloatingActionButton fbi_language;
    @BindView(R.id.bottomSheet) android.view.View bottomSheet;
    private HashMap<String, String> map;
    private Validator validator;

    @OnClick(R.id.fbi_photo)
    void onFbiClick() {
        TranslateActivityPermissionsDispatcher.getPhotoWithCheck(this);
    }

    @OnClick(R.id.fbi_language)
    void onFbiLanguageClick() {
        startForRes(LanguageActivity.class, REQUEST_LANGUAGE_TO_TRANSLATE);
    }

    @OnClick(R.id.translate_button)
    void onButtonClick() {
        validator.validate();
    }

    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ButterKnife.bind(this);
        LogicComponent component = (LogicComponent) App.getApp(this).getComponentsHolder()
                .getLogicComponent(getClass(), new MainActivityModule());
        component.inject(this);
        validator = new Validator(this);
        validator.setValidationListener(this);
        mTranslatePresenter.attachView(this);
        map = new HashMap<>();
        map.put("key", Links.ACCESS_TOKEN);
        map.put("lang", "ru");
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void fetchData(List<String> translate, String text) {
        if (translate == null) {
            error(getString(R.string.no_internet_connection));
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
        fbi_photo.startAnimation(animation);
        fbi_language.startAnimation(animation);
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
            mTranslatePresenter.detachView();
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
            assert (imageBitmap != null ? imageBitmap : null) != null;
            SparseArray<TextBlock> textBlocks = recognizer.detect(new Frame.Builder().setBitmap(imageBitmap).build());
            for (int i = 0; i < textBlocks.size(); i++) {
                TextBlock textBlock = textBlocks.get(textBlocks.keyAt(i));
                list.add(textBlock.getValue());
            }
            if (!list.isEmpty()) {
                map.put("text", list.get(0));
                mTranslatePresenter.getData(map);
            } else {
                error(getString(R.string.i_have_found_nothing));
            }
        }

        if(requestCode == REQUEST_LANGUAGE_TO_TRANSLATE && resultCode == RESULT_OK){
            map.put("lang", manager.readFromPref());
            map.put("text", englishText.getText().toString());
            mTranslatePresenter.getData(map);
        }
    }

    @Override
    public void onValidationSucceeded() {
        map.put("text", englishText.getText().toString());
        mTranslatePresenter.getData(map);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        error(getString(R.string.write_a_word_to_field));
    }

}
