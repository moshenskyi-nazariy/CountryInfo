package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper.DangerLevelMapper;
import com.example.ratingbar.RatingBar;

public class ViewHolderFactory {
    public static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView descriptionText;

        TextViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title_text);
            descriptionText = itemView.findViewById(R.id.description);
        }

        public void setTitleText(int titleTextId) {
            this.titleText.setText(titleTextId);
        }

        public void setDescriptionText(String descriptionText) {
            if (descriptionText == null || descriptionText.isEmpty()) {
                this.descriptionText.setText(R.string.no_info_text);
            } else {
                this.descriptionText.setText(descriptionText);
            }
        }

        public void setDescriptionText(String mask, String rate, String name) {
            if ((name != null && rate != null) && (!name.isEmpty() && !rate.isEmpty())) {
                String description = String.format(mask, rate, name);
                this.descriptionText.setText(description);
            } else {
                this.descriptionText.setText(R.string.no_info_text);
            }
        }
    }

    public static class ElectricityViewHolder extends RecyclerView.ViewHolder {
        private TextView voltage;
        private TextView frequency;
        private TextView plugs;

        ElectricityViewHolder(View itemView) {
            super(itemView);
            voltage = itemView.findViewById(R.id.voltage);
            frequency = itemView.findViewById(R.id.frequency);
            plugs = itemView.findViewById(R.id.plugs);
        }

        public void setVoltage(String voltage) {
            if (voltage != null && !voltage.isEmpty()) {
                this.voltage.setText(voltage);
            } else {
                this.voltage.setText(R.string.no_info_text);
            }
        }

        public void setFrequency(String frequency) {
            if (frequency != null && !frequency.isEmpty()) {
                this.frequency.setText(frequency);
            } else {
                this.frequency.setText(R.string.no_info_text);
            }
        }

        public void setPlugs(String plugs) {
            if (plugs != null && !plugs.isEmpty()) {
                this.plugs.setText(plugs);
            } else {
                this.plugs.setText(R.string.no_info_text);
            }
        }
    }

    public static class DangerViewHolder extends RecyclerView.ViewHolder {
        private RatingBar ratingBar;

        public DangerViewHolder(View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.danger_rating);
        }

        public void setLevel(String level) {
            ratingBar.setLevel(DangerLevelMapper.convertLevel(level));
        }
    }

    public static RecyclerView.ViewHolder createTextViewHolder(ViewGroup parent) {
        View textTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_text_type, parent, false);
        return new ViewHolderFactory.TextViewHolder(textTypeView);
    }

    public static RecyclerView.ViewHolder createElectricityViewHolder(ViewGroup parent) {
        View electricityTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_electricity_type, parent, false);
        return new ViewHolderFactory.ElectricityViewHolder(electricityTypeView);
    }

    public static RecyclerView.ViewHolder createDangerViewHolder(ViewGroup parent) {
        View dangerTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_danger_type, parent, false);
        return new ViewHolderFactory.DangerViewHolder(dangerTypeView);
    }

}
