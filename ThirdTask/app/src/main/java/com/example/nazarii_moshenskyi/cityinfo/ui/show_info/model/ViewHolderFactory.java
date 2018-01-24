package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.ratingbar.RatingBar;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ViewHolderFactory {

    private static abstract class AbstractViewHolder extends RecyclerView.ViewHolder {
        private boolean isExpanded;

        public AbstractViewHolder(View itemView) {
            super(itemView);
        }

        protected void setListener(ImageButton icon, View titleLayout, View descriptionLayout) {
            setListener(icon, titleLayout, descriptionLayout, false);
        }

        protected void setListener(ImageButton icon, View titleLayout, View descriptionLayout, boolean expanded) {
            this.isExpanded = expanded;
            icon.setActivated(isExpanded);
            titleLayout.setOnClickListener(v -> {
                descriptionLayout.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                isExpanded = !isExpanded;
                icon.setActivated(isExpanded);
                TransitionManager.beginDelayedTransition((ViewGroup) itemView.getRootView(), new Fade());
            });
        }
    }

    public static class TextViewHolder extends AbstractViewHolder {
        private LinearLayout titleLayout;
        private LinearLayout descriptionLayout;
        private ImageButton icon;

        private TextView titleText;
        private TextView descriptionText;

        TextViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title_text);
            titleLayout = itemView.findViewById(R.id.title_layout);
            descriptionLayout = itemView.findViewById(R.id.description_layout);
            icon = itemView.findViewById(R.id.text_type_icon);

            setListener(icon, titleLayout, descriptionLayout);

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

    public static class ElectricityViewHolder extends AbstractViewHolder {
        private TextView voltage;
        private TextView frequency;
        private TextView plugs;
        private ImageButton icon;

        private LinearLayout titleLayout;
        private ConstraintLayout descriptionLayout;

        ElectricityViewHolder(View itemView) {
            super(itemView);
            descriptionLayout = itemView.findViewById(R.id.description_layout);
            titleLayout = itemView.findViewById(R.id.title_layout);
            icon = itemView.findViewById(R.id.electricity_type_icon);

            setListener(icon, titleLayout, descriptionLayout);

            voltage = itemView.findViewById(R.id.voltage);
            frequency = itemView.findViewById(R.id.frequency);
            plugs = itemView.findViewById(R.id.plugs);
        }

        public void setVoltage(String voltage) {
            if (voltage != null && !voltage.isEmpty()) {
                this.voltage.setText(voltage);
            } else {
                this.voltage.setText(R.string.no_info_short_form);
            }
        }

        public void setFrequency(String frequency) {
            if (frequency != null && !frequency.isEmpty()) {
                this.frequency.setText(frequency);
            } else {
                this.frequency.setText(R.string.no_info_short_form);
            }
        }

        public void setPlugs(String plugs) {
            if (plugs != null && !plugs.isEmpty()) {
                this.plugs.setText(plugs);
            } else {
                this.plugs.setText(R.string.no_info_short_form);
            }
        }
    }

    public static class WeatherViewHolder extends AbstractViewHolder {
        private LineChart chart;
        private LinearLayout titleLayout;
        private ImageButton icon;

        WeatherViewHolder(View itemView) {
            super(itemView);
            chart = itemView.findViewById(R.id.weather_chart);
            titleLayout = itemView.findViewById(R.id.title_layout);
            icon = itemView.findViewById(R.id.imageButton);

            setListener(icon, titleLayout, chart, true);
        }

        public void setWeather(WeatherInfo annualData) {
            List<Month> weather = annualData.getWeather();
            List<ILineDataSet> data = new ArrayList<>(0);
            List<Entry> minEntries = new ArrayList<>(0);
            List<Entry> avgEntries = new ArrayList<>(0);
            List<Entry> maxEntries = new ArrayList<>(0);

            setEntries(weather, minEntries, avgEntries, maxEntries);

            makeLines(data, minEntries, avgEntries, maxEntries);

            XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            LineData lineData = new LineData(data);
            chart.setData(lineData);
            Description desc = new Description();
            desc.setText("Month num / \u2103");
            chart.setDescription(desc);
            chart.setScaleEnabled(true);
            chart.setDragEnabled(true);
            chart.invalidate();
        }

        private void makeLines(List<ILineDataSet> data, List<Entry> minEntries, List<Entry> avgEntries, List<Entry> maxEntries) {
            LineDataSet min = new LineDataSet(minEntries, "min");
            min.setColor(Color.CYAN);
            min.setCircleColor(Color.CYAN);
            data.add(min);

            LineDataSet avg = new LineDataSet(avgEntries, "avg");
            avg.setColor(Color.GREEN);
            avg.setCircleColor(Color.GREEN);
            data.add(avg);

            LineDataSet max = new LineDataSet(maxEntries, "max");
            max.setColor(Color.RED);
            max.setCircleColor(Color.RED);
            data.add(max);
        }

        private void setEntries(List<Month> weather, List<Entry> minEntries, List<Entry> avgEntries, List<Entry> maxEntries) {
            for (int i = 0; i < weather.size(); i++) {
                Month currentMonth = weather.get(i);
                maxEntries.add(new Entry((float) i + 1, Float.parseFloat(currentMonth.gettMin())));
                avgEntries.add(new Entry((float) i + 1, Float.parseFloat(currentMonth.gettAvg())));
                minEntries.add(new Entry((float) i + 1, Float.parseFloat(currentMonth.gettMax())));
            }
        }
    }

    public static class DangerViewHolder extends AbstractViewHolder {
        private TextView title;
        private RatingBar ratingBar;
        private ImageButton icon;

        DangerViewHolder(View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.danger_rating);
            title = itemView.findViewById(R.id.danger_title);
            icon = itemView.findViewById(R.id.imageButton);

            setListener(icon, title, ratingBar);
        }

        public void setLevel(String level) {
            ratingBar.setLevel(Integer.parseInt(level));
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

    public static RecyclerView.ViewHolder createWeatherViewHolder(ViewGroup parent) {
        View weatherViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_weather_type, parent, false);
        return new ViewHolderFactory.WeatherViewHolder(weatherViewHolder);
    }

}
