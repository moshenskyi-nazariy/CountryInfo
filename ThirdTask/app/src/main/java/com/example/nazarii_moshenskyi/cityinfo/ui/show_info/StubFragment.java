package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;

public class StubFragment extends Fragment {

    public StubFragment() {
        // Required empty public constructor
    }

    public static StubFragment newInstance() {
        return new StubFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stub, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
