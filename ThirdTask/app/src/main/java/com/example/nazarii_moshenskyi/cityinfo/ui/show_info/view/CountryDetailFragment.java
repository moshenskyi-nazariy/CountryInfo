package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view;

import android.app.Application;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.constraint.Guideline;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.ui.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.InfoAdapter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter.CountryInfoMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.util.glide_svg.GlideApp;
import com.example.nazarii_moshenskyi.cityinfo.util.glide_svg.SvgSoftwareLayerSetter;
import com.example.ratingbar.RatingBar;

import java.util.List;

import javax.inject.Inject;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountryDetailFragment extends Fragment implements CountryInfoMvpView {

    private static final String COUNTRY_NAME = "country";

    private LinearLayoutManager linearLayoutManager;
    private InfoAdapter infoAdapter;
    private RecyclerView infoRecyclerView;
    private ImageView flagImage;
    private RatingBar dangerRating;
    private TextView dangerTitle;
    private Guideline dangerTitleTop;
    private TextView population;
    private TextView area;
    private TextView continent;

    @Inject
    public CountryInfoMvpPresenter presenter;

    private String countryName;
    private RequestBuilder<PictureDrawable> requestBuilder;

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

        infoRecyclerView = view.findViewById(R.id.info_recycler_view);
        infoRecyclerView.setAdapter(infoAdapter);
        infoRecyclerView.setLayoutManager(linearLayoutManager);

        flagImage = view.findViewById(R.id.flag_placeholder);

        dangerRating = view.findViewById(R.id.danger_rating);
        dangerTitle = view.findViewById(R.id.danger_title);
        dangerTitleTop = view.findViewById(R.id.title_bottom);

        population = view.findViewById(R.id.population);
        area = view.findViewById(R.id.area);
        continent = view.findViewById(R.id.continent);

        requestBuilder = GlideApp.with(this)
                .as(PictureDrawable.class)
                .apply(new RequestOptions().override(flagImage.getWidth(), flagImage.getHeight()))
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        presenter.getInfo(countryName);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public void onLoad(List<RowType> infoModel, DangerInfo dangerLevel) {
        infoAdapter.update(infoModel);

        int level = dangerLevel.getLevel();
        if (level == -1) {
            dangerTitle.setVisibility(View.GONE);
            dangerTitleTop.setVisibility(View.GONE);
            dangerRating.setVisibility(View.GONE);
        } else {
            dangerRating.setLevel(level);
        }
    }

    @Override
    public void setBackground(String flagUrl) {
        if (flagUrl != null) {
            requestBuilder.load(flagUrl).into(flagImage);
        }
    }

    public void setTitleInfo(CountryAnalytics analytics, String continent) {
        Integer analyticsPopulation;
        if ((analyticsPopulation = analytics.getPopulation()) != null) {
            population.setText(String.valueOf(analyticsPopulation));
        }

        Integer analyticsArea;
        if ((analyticsArea = analytics.getArea()) != null) {
            area.setText(String.valueOf(analyticsArea));
        }

        if (continent != null) {
            this.continent.setText(continent);
        }
    }

}
