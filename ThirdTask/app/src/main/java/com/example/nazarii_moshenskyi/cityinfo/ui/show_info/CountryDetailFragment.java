package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.model.InfoModel;

import javax.inject.Inject;

public class CountryDetailFragment extends Fragment implements CountryInfoView, View.OnClickListener {

    private static final String COUNTRY_NAME = "country";

    private boolean isOld = false;
    private SparseArray<Object> associatedMap;
    private TextView nameItem;
    private TextView adviseItem;
    private RecyclerView vaccinationItem;
    private RecyclerView languagesItem;
    private TextView currencyItem;
    private TextView socketsItem;
    private LinearLayoutManager layoutManagerLanguages;
    private LinearLayoutManager layoutManagerVaccines;

    private LanguageAdapter languageAdapter;
    private VaccineAdapter vaccineAdapter;

    @Inject
    public CountryInfoPresenterImpl presenter;

    private String countryName;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    public static CountryDetailFragment newInstance(String countryName) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putString(COUNTRY_NAME, countryName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Application application = getActivity().getApplication();
        if (application == null) {
            return;
        }
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        if (savedInstanceState == null) {
            countryName = getArguments().getString(COUNTRY_NAME);
        } else {
            countryName = savedInstanceState.getString(COUNTRY_NAME);
        }

        languageAdapter = new LanguageAdapter();
        vaccineAdapter = new VaccineAdapter();

        presenter.attachView(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(COUNTRY_NAME, countryName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_detail, container, false);

        layoutManagerLanguages = new LinearLayoutManager(view.getContext());
        layoutManagerVaccines = new LinearLayoutManager(view.getContext());

        initImages(view);
        initDataRepresentation(view);
        associateIds();
        nameItem.setText(countryName);
        presenter.getInfo(countryName);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public void onLoad(InfoModel infoModel) {
        adviseItem.setText(infoModel.getAdvise());
        currencyItem.setText(infoModel.getCurrency());
        socketsItem.setText(infoModel.getSockets());

        languageAdapter.update(infoModel.getLanguages());
        vaccineAdapter.update(infoModel.getVaccinations());
    }

    private void initDataRepresentation(View rootView) {
        nameItem = rootView.findViewById(R.id.name_item);
        adviseItem = rootView.findViewById(R.id.advises_item);
        socketsItem = rootView.findViewById(R.id.sockets_item);
        currencyItem = rootView.findViewById(R.id.currency_item);
        vaccinationItem = rootView.findViewById(R.id.list_vaccinations);
        languagesItem = rootView.findViewById(R.id.list_languages);

        languagesItem.setAdapter(languageAdapter);
        languagesItem.setLayoutManager(layoutManagerLanguages);

        vaccinationItem.setAdapter(vaccineAdapter);
        vaccinationItem.setLayoutManager(layoutManagerVaccines);
    }

    private void associateIds() {
        associatedMap = new SparseArray<>();
        associatedMap.put(R.id.advise_arrow_down, R.id.advises_item);
        associatedMap.put(R.id.vaccinations_arrow_down, R.id.list_vaccinations);
        associatedMap.put(R.id.languages_arrow_down, R.id.list_languages);
        associatedMap.put(R.id.currency_arrow_down, R.id.currency_item);
        associatedMap.put(R.id.sockets_arrow_down, R.id.sockets_item);
    }

    private void initImages(View rootView) {
        ImageView adviseView = rootView.findViewById(R.id.advise_arrow_down);
        ImageView vaccinationView = rootView.findViewById(R.id.vaccinations_arrow_down);
        ImageView languagesView = rootView.findViewById(R.id.languages_arrow_down);
        ImageView socketView = rootView.findViewById(R.id.sockets_arrow_down);
        ImageView currencyView = rootView.findViewById(R.id.currency_arrow_down);

        adviseView.setOnClickListener(this);
        vaccinationView.setOnClickListener(this);
        languagesView.setOnClickListener(this);
        socketView.setOnClickListener(this);
        currencyView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        View visibleView = getActivity().findViewById((Integer) associatedMap.get(id));
        if (isOld) {
            visibleView.setVisibility(View.GONE);
        } else {
            visibleView.setVisibility(View.VISIBLE);
        }
        isOld = !isOld;
    }
}
