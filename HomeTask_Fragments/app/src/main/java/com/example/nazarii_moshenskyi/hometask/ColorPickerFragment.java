package com.example.nazarii_moshenskyi.hometask;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPickerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public ColorPickerFragment() {
        // Required empty public constructor
    }

    public static ColorPickerFragment newInstance() {
        ColorPickerFragment fragment = new ColorPickerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_color_picker, container, false);
        root.findViewById(R.id.btn_color).setOnClickListener(new View.OnClickListener() {
            private int color = getResources().getColor(R.color.colorDefault);

            @Override
            public void onClick(View view) {
                AmbilWarnaDialog colordialog = new AmbilWarnaDialog(getContext(), color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        mListener.onColorChanged(color);
                    }
                });
                colordialog.show();
            }
        });

        root.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onUpdateFragment();
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onColorChanged(int color);
        void onUpdateFragment();
    }
}
