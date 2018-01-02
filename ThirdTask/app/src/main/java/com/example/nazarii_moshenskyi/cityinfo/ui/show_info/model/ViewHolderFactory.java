package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;

public class ViewHolderFactory {
    public static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView descriprionText;

        public TextViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title_text);
            descriprionText = itemView.findViewById(R.id.description);
        }

        public void setTitleText(String titleText) {
            if (titleText != null) {
                this.titleText.setText(titleText);
            }
        }

        public void setDescriprionText(String descriprionText) {
            if (titleText != null) {
                this.descriprionText.setText(descriprionText);
            }
        }
    }

    public static class ElectricityViewHolder extends RecyclerView.ViewHolder {
        private TextView voltage;
        private TextView frequency;
        private TextView plugs;

        public ElectricityViewHolder(View itemView) {
            super(itemView);
            voltage = itemView.findViewById(R.id.voltage);
            frequency = itemView.findViewById(R.id.frequency);
            plugs = itemView.findViewById(R.id.plugs);
        }

        public void setVoltage(String voltage) {
            if (voltage != null) {
                this.voltage.setText(voltage);
            }
        }

        public void setFrequency(String frequency) {
            if (frequency != null) {
                this.frequency.setText(frequency);
            }
        }

        public void setPlugs(String plugs) {
            if (plugs != null) {
                this.plugs.setText(plugs);
            }
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RowType.TEXT_ROW_TYPE:
                View textTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_text_type, parent, false);
                return new ViewHolderFactory.TextViewHolder(textTypeView);

            case RowType.ELECTRICITY_ROW_TYPE:
                View imageTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_electricity_type, parent, false);
                return new ViewHolderFactory.ElectricityViewHolder(imageTypeView);

            default:
                return null;
        }
    }
}
