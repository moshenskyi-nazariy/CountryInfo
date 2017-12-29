package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

import javax.inject.Inject;

public class CountryFragment extends Fragment implements CountryView {
    private OnFragmentInteractionListener listener;
    private RecyclerView countryList;

    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;

    @Inject
    public CountryPresenter presenter;
    private List<Country> items;

    public CountryFragment() {
        // Required empty public constructor
    }

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application application = getActivity().getApplication();
        if (application == null) {
            return;
        }
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        layoutManager = new LinearLayoutManager(getContext());
        presenter.attachView(this);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_country, container, false);
        initList(rootView);
        presenter.start();
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
        presenter.detachView();
    }

    public void onTextChanged(String intput) {
        presenter.updateItems(intput, countryAdapter);
    }

    @Override
    public List<Country> getItems() {
        return items;
    }

    @Override
    public void onLoad(List<Country> items) {
        countryAdapter.update(items);
        this.items = items;
    }

    @Override
    public void onClick(Country country) {
        presenter.onClick(country, listener);
    }

    public interface OnFragmentInteractionListener {
        void onCountryClicked(Country country);
    }
}
