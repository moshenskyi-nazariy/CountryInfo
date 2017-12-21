package com.example.nazarii_moshenskyi.cityinfo.ui.show_cities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;


public class CountryFragment extends Fragment {
    private static final String TAG = "CountryFragment";
    private static final String ARG_PARAM1 = "cityList";

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    public CountryFragment() {
        // Required empty public constructor
    }

   /* public static CountryFragment newInstance(CountryList countries) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, countries);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //countries = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView = view.findViewById(R.id.country_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        //countryAdapter = new CountryAdapter(countries.getCountries());
        recyclerView.setAdapter(countryAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CountryItemDecorator((int) view.getResources().getDimension(R.dimen.margins)));

        return view;
    }

    public void onItemClicked(int position) {
        if (mListener != null) {
            mListener.onCountryClicked(position);
        }
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
        void onCountryClicked(int position);
    }
}
