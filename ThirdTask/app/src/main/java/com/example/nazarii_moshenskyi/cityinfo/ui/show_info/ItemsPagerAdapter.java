package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ItemsPagerAdapter extends FragmentPagerAdapter {

    private List<String> countryNames;

    public ItemsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void update(List<String> items) {
        countryNames = items;
    }

    @Override
    public Fragment getItem(int position) {
        String name = countryNames.get(position);
        return CountryDetailFragment.newInstance(name);
    }

    @Override
    public int getCount() {
        return countryNames.size();
    }
}
