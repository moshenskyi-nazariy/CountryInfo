package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.di.CountryPresenterModule;
import com.example.nazarii_moshenskyi.cityinfo.di.DaggerCountryComponent;

import java.util.List;

import javax.inject.Inject;


public class CountryFragment extends Fragment implements CountryView {
    private static final String ARG_COUNTRY = "cityList";

    private OnFragmentInteractionListener listener;
    private RecyclerView countryList;
    private List<Country> countries;

    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;

    @Inject
    protected CountryPresenter presenter;

    public CountryFragment() {
        // Required empty public constructor
    }

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            countries = savedInstanceState.getParcelable(ARG_COUNTRY);
        }

        layoutManager = new LinearLayoutManager(getContext());
        DaggerCountryComponent.builder()
                .countryPresenterModule(new CountryPresenterModule(this))
                .build();

    }

    private void initList(View rootView) {
        countryList = rootView.findViewById(R.id.country_list);
        countryList.setItemAnimator(new DefaultItemAnimator());
        countryList.addItemDecoration(new CountryItemDecorator((int) getResources().
                getDimension(R.dimen.margins)));

        countryAdapter = new CountryAdapter(this);
        countryList.setAdapter(countryAdapter);
        countryList.setLayoutManager(layoutManager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_COUNTRY, (Parcelable) countries);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_country, container, false);
        initList(rootView);
        presenter.getCountries();
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onLoad(List<Country> items) {
        countryAdapter.update(items);
    }

    @Override
    public void onClick(Country country) {
        if (listener != null) {
            listener.onCountryClicked(country);
        }
    }

    public interface OnFragmentInteractionListener {
        void onCountryClicked(Country country);
    }
}
