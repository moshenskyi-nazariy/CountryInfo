package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nazarii_moshenskyi.thirdtask.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CityFragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private ICityPresenter presenter;
    private Observer<String> choosenItem;


    public CityFragment() {
        // Required empty public constructor
    }

    public static CityFragment newInstance(ICityPresenter presenter) {
        CityFragment cityFragment = new CityFragment();
        cityFragment.setPresenter(presenter);
        return cityFragment;
    }

    public void setPresenter(ICityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initObserver(final Context context) {
         choosenItem = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
                Toast.makeText(context, s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);

        RecyclerView list = view.findViewById(R.id.recycler_view);
        presenter.setList(list);
        presenter.start();
        initObserver(view.getContext());

        subscribe(presenter.getOnItemClickListner());

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (listener != null) {
            listener.onFragmentInteraction(uri);
        }
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

    private void subscribe(Observable<String> item) {
        item.subscribe(choosenItem);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
