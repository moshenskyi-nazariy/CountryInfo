package com.example.nazarii_moshenskyi.hometask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends AbstractFragment {

    private static final String ARG_COLOR = "color";
    private static final String FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT";
    private int color;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(int color) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_COLOR);
            setRetainInstance(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_second, container, false);
        root.setBackgroundColor(color);
        return root;
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
        this.color = color;
    }

    @Override
    public String getNextTag() {
        return FIRST_FRAGMENT_TAG;
    }

    @Override
    public String getThisTag() {
        return SECOND_FRAGMENT_TAG;
    }
}
