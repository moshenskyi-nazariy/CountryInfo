package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter.CountryMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryItemDecorator;

import java.util.List;

import javax.inject.Inject;

public class CountryFragment extends BaseFragment<CountryMvpPresenter> implements CountryMvpView, AdapterOnClickListener {
    private OnFragmentInteractionListener listener;
    private RecyclerView countryList;

    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener;
    private BottomNavigationView bottomNavigationView;

    @Inject
    public CountryMvpPresenter presenter;
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
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        layoutManager = new LinearLayoutManager(getContext());
        onNavigationItemSelectedListener = getOnNavigationItemSelectedListener();
    }

    private void initList(View rootView) {
        bottomNavigationView = rootView.findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

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
        presenter.attachView(this);
        initList(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getCountries();
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

    public void onTextChanged(String input) {
        presenter.updateItems(input, countryAdapter);
    }

    @Override
    public List<Country> getItems() {
        return items;
    }

    @Override
    public void onLoad(List<Country> items) {
        this.items = items;
        countryAdapter.update(items);
        listener.onCountriesLoaded(items);
    }

    @Override
    public void onClick(Country country) {
        listener.onCountryClicked(country);
    }

    public interface OnFragmentInteractionListener {

        void onCountryClicked(Country country);

        void onCountriesLoaded(List<Country> list);

    }

    @NonNull
    private BottomNavigationView.OnNavigationItemSelectedListener getOnNavigationItemSelectedListener() {
        return item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    layoutManager.scrollToPosition(0);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        };
    }
}
