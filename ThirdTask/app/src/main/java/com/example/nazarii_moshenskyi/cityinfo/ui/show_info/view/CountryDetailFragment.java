package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.AnalyticsInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.InfoAdapter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter.CountryInfoMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.util.glide_svg.GlideApp;
import com.example.nazarii_moshenskyi.cityinfo.util.glide_svg.SvgSoftwareLayerSetter;

import java.util.List;

import javax.inject.Inject;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountryDetailFragment extends BaseFragment<CountryInfoMvpPresenter, CountryInfoMvpView> implements CountryInfoMvpView {

    private static final String COUNTRY_NAME = "country";

    private LinearLayoutManager linearLayoutManager;
    private InfoAdapter infoAdapter;
    private RecyclerView infoRecyclerView;
    private ImageView flagImage;
    private TextView population;
    private TextView area;
    private TextView continent;

    @Inject
    public CountryInfoMvpPresenter presenter;

    private String countryName;
    private RequestBuilder<PictureDrawable> requestBuilder;
    private ProgressBar progressBar;

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
    protected CountryInfoMvpPresenter createPresenter() {
        Application application = getActivity().getApplication();
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            countryName = getArguments().getString(COUNTRY_NAME);
        } else {
            countryName = savedInstanceState.getString(COUNTRY_NAME);
        }

        infoAdapter = new InfoAdapter();
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

        linearLayoutManager = new LinearLayoutManager(view.getContext());

        initViews(view);

        requestBuilder = GlideApp.with(this)
                .as(PictureDrawable.class)
                .apply(new RequestOptions().override(flagImage.getWidth(), flagImage.getHeight()))
                .placeholder(R.drawable.no_image_placeholder)
                .error(R.drawable.no_image_placeholder)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());

        return view;
    }

    private void initViews(View rootView) {
        infoRecyclerView = rootView.findViewById(R.id.info_recycler_view);
        infoRecyclerView.setAdapter(infoAdapter);
        infoRecyclerView.setLayoutManager(linearLayoutManager);

        flagImage = rootView.findViewById(R.id.flag_placeholder);
        progressBar = rootView.findViewById(R.id.progressBar);

        population = rootView.findViewById(R.id.population);
        area = rootView.findViewById(R.id.area);
        continent = rootView.findViewById(R.id.continent);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().getInfo(countryName);
    }

    @Override
    public void onLoad(List<RowType> infoModel) {
        infoAdapter.update(infoModel);
    }

    @Override
    public void setBackground(String flagUrl) {
        requestBuilder.load(flagUrl).into(flagImage);
    }

    public void setTitleInfo(AnalyticsInfo analytics, String continent) {
        population.setText(analytics.getPopulation());
        area.setText(analytics.getArea());

        this.continent.setText(continent);
    }

    @Override
    public void showLoadingBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingBar() {
        progressBar.setVisibility(View.GONE);
    }

   /* @Override
    public void showError() {
        Toast.makeText(getActivity(), "No internet.", Toast.LENGTH_LONG).show();
    }*/
}
