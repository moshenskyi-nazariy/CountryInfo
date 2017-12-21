package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Language;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    private List<Language> languages;

    @Override
    public LanguageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.languages_item, parent, false);
        return new LanguageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LanguageAdapter.ViewHolder holder, int position) {
        Language language = languages.get(position);
        String languageName = language.getLanguage();
        holder.language.setText(languageName);
    }

    public void update(List<Language> languages) {
        if(languages != null) {
            this.languages = languages;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView language;

        ViewHolder(View itemView) {
            super(itemView);
            language = itemView.findViewById(R.id.language);
        }
    }
}