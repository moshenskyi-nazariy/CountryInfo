package com.example.nazarii_moshenskyi.hometask;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ColorPickerFragment.OnFragmentInteractionListener {

    private static final String COLOR_EXTRA = "COLOR";
    private FragmentManager manager;
    private AbstractFragment currentFragment;
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            defaultColor = getResources().getColor(R.color.colorDefault);
            currentFragment = FirstFragment.newInstance(defaultColor);
            manager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.fragment_container, currentFragment, currentFragment.getThisTag())
                    .commit();
        } else {
            String tag = savedInstanceState.getString(COLOR_EXTRA);
            currentFragment = (AbstractFragment) manager.findFragmentByTag(tag);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(COLOR_EXTRA, currentFragment.getThisTag());
    }

    @Override
    public void onColorChanged(int color) {
        currentFragment.setColor(color);
    }

    @Override
    public void onUpdateFragment() {
        String next = currentFragment.getNextTag();
        currentFragment = (AbstractFragment) manager.findFragmentByTag(next);
        if (currentFragment == null) {
            currentFragment = SecondFragment.newInstance(defaultColor);
        }

        manager.beginTransaction()
                .replace(R.id.fragment_container, currentFragment, currentFragment.getThisTag())
                .addToBackStack(null)
                .commit();
    }
}
