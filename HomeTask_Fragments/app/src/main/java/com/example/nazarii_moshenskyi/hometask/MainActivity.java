package com.example.nazarii_moshenskyi.hometask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ColorPickerFragment.OnFragmentInteractionListener {

    private FragmentManager manager;
    private AbstractFragment currentFragment;
    private static final String FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT";
    private static final String SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT";
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultColor = getResources().getColor(R.color.colorDefault);

        if (savedInstanceState == null) {
            currentFragment = FirstFragment.newInstance(defaultColor);
            currentFragment.setNext(SECOND_FRAGMENT_TAG);

            manager = getSupportFragmentManager();
            manager.beginTransaction().add(R.id.fragment_container, currentFragment, FIRST_FRAGMENT_TAG).addToBackStack(null).commit();
        }
    }

    @Override
    public void onColorChanged(int color) {
        currentFragment.setColor(color);
    }

    @Override
    public void onUpdateFragment() {
        String next = currentFragment.getNext();
        if (manager.findFragmentByTag(next) == null) {

        }

    }
}
