package com.example.nazarii_moshenskyi.hometask;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class AbstractFragment extends Fragment {
    private int color;
    protected static final String FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT";
    protected static final String SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT";

    public void setColor(int color) {
        this.color = color;
        View root = getView();
        if (root != null) {
            root.setBackgroundColor(color);
        }
    }

    public int getColor() {
        return color;
    }

    public abstract String getNextTag();

    public abstract String getThisTag();

}
