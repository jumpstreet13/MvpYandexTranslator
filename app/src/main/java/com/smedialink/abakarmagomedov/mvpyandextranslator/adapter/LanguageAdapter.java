package com.smedialink.abakarmagomedov.mvpyandextranslator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.mvpyandextranslator.R;
import com.smedialink.abakarmagomedov.mvpyandextranslator.custom_views.StateButton;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

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

    public LanguageAdapter(List<Language> languageList, LanguageListener listener) {
        this.languageList = languageList;
        this.listener = listener;
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
        holder.bindView(language, listener);
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

        LanguageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Language language, LanguageListener listener) {
            this.language = language;
            this.listener = listener;
            textView.setText(language.getDescription());
        }
    }

}
