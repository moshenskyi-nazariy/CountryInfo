package com.example.nazarii_moshenskyi.hometask;

import android.support.v4.app.Fragment;
import android.view.View;

public class AbstractFragment extends Fragment {
    private int color;
    private String tag;

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

    public void setNext(String tag) {
        this.tag = tag;
    }

    public String getNext() {
        return tag;
    }
}
