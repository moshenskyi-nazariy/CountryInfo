package com.example.nazarii_moshenskyi.hometask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends AbstractFragment {

    private static final String ARG_COLOR = "color";
    private int color;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(int color) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(ARG_COLOR);
        } else {
            color = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        root.setBackgroundColor(color);
        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_COLOR, color);
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
        this.color = color;
    }

    @Override
    public String getNextTag() {
        return SECOND_FRAGMENT_TAG;
    }

    @Override
    public String getThisTag() {
        return FIRST_FRAGMENT_TAG;
    }

}
