package com.smedialink.abakarmagomedov.mvpyandextranslator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.custom_views.StateButton;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;
import com.smedialink.abakarmagomedov.mvpyandextranslator.managers.SharedPrefManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 04/06/17.
 */

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageHolder> {

    private List<Language> languageList;
    private LanguageListener listener;
    private String chosenLanguage;


    public LanguageAdapter(List<Language> languageList, LanguageListener listener, String chosenLanguage) {
        this.languageList = languageList;
        this.listener = listener;
        this.chosenLanguage = chosenLanguage;
    }


    @Override
    public LanguageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.language_item, parent, false);
        return new LanguageHolder(view);
    }

    @Override
    public void onBindViewHolder(LanguageHolder holder, int position) {
        Language language = languageList.get(position);
        holder.bindView(language, listener, chosenLanguage);
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public interface LanguageListener {
        void onLanguageClick(Language language);
    }


    static class LanguageHolder extends RecyclerView.ViewHolder {

        private LanguageListener listener;
        private Language language;
        @BindView(R.id.languageName) TextView textView;
        @BindView(R.id.language_check) CheckBox languageCheck;

        @OnClick(R.id.language_check)
        void onLanguageClick() {
            listener.onLanguageClick(language);
        }

        LanguageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Language language, LanguageListener listener, String chosenLanguage) {
            this.language = language;
            this.listener = listener;
            textView.setText(language.getDescription());
            if(language.getDescription().equals(chosenLanguage)) languageCheck.setChecked(true);
            else languageCheck.setChecked(false);
        }
    }

}
