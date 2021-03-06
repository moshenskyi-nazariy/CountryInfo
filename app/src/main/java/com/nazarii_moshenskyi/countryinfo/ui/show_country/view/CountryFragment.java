package com.nazarii_moshenskyi.countryinfo.ui.show_country.view;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nazarii_moshenskyi.countryinfo.R;
import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.CountryInfoApplication;
import com.nazarii_moshenskyi.countryinfo.ui.base.BaseFragment;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.presenter.CountryMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.recycler.CountryAdapter;

import java.util.List;

import javax.inject.Inject;

public class CountryFragment extends BaseFragment<CountryMvpPresenter, CountryMvpView> implements CountryMvpView, AdapterOnClickListener {
    private OnFragmentInteractionListener listener;

    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;

    @Inject
    public CountryMvpPresenter presenter;
    private List<Country> items;

    private ProgressBar loadingBar;

    public CountryFragment() {
        // Required empty public constructor
    }

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    protected CountryMvpPresenter createPresenter() {
        Application application = getActivity().getApplication();
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutManager = new LinearLayoutManager(getContext());
    }

    private void initList(View rootView) {
        RecyclerView countryList = rootView.findViewById(R.id.country_list);

        countryAdapter = new CountryAdapter(this);
        countryList.setAdapter(countryAdapter);
        countryList.setLayoutManager(layoutManager);

        countryList.addItemDecoration(new DividerItemDecoration(rootView.getContext(),
                                            layoutManager.getOrientation()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_country, container, false);
        initList(rootView);
        loadingBar = rootView.findViewById(R.id.progressBar);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
    public void showLoadingBar() {
        loadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingBar() {
        loadingBar.setVisibility(View.GONE);
    }

/*    @Override
    public void showError() {
//        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
//                R.string.email_archived, Snackbar.LENGTH_SHORT);
//        mySnackbar.setAction(R.string.undo_string, new MyUndoListener());
//        mySnackbar.show();
        Intent settingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        startActivityForResult(settingsIntent, 0);
    }*/

    @Override
    public void onLoad(List<Country> items) {
        this.items = items;
        countryAdapter.update(items);
        listener.onCountriesLoaded(items);
    }

    public void refreshLayout() {
        layoutManager.scrollToPosition(0);
    }

    @Override
    public void onClick(Country country) {
        listener.onCountryClicked(country);
    }


    public interface OnFragmentInteractionListener {

        void onCountryClicked(Country country);

        void onCountriesLoaded(List<Country> list);

    }
}
