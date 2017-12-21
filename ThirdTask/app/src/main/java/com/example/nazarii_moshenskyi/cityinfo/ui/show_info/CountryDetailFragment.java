package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;

import java.util.List;

public class CountryDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private OnPositionClickedListener mListener;
    private List<CountryInfo> cityList;
    private RecyclerView recyclerView;
    private LanguageAdapter languageAdapter;
    private VaccineAdapter vaccineAdapter;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    public static CountryDetailFragment newInstance() {
        CountryDetailFragment fragment = new CountryDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setList(List<CountryInfo> cityList) {
        this.cityList = cityList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_details, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_city);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        /*cityAdapter = new CityAdapter(cityList);*/
        /*recyclerView.setAdapter(cityAdapter);*/
        /*recyclerView.setLayoutManager(layoutManager);*/
        /*recyclerView.setItemAnimator(new DefaultItemAnimator());*/
        /*recyclerView.addItemDecoration(new ItemDecorator((int) view.getResources().getDimension(R.dimen.margins)));*/
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPositionClickedListener) {
            mListener = (OnPositionClickedListener) context;
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

    public interface OnPositionClickedListener {
        void onCityClicked(int position);
    }
}
