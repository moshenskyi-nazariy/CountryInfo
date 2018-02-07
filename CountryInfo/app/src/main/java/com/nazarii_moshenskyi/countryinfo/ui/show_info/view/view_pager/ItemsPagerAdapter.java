package com.nazarii_moshenskyi.countryinfo.ui.show_info.view.view_pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.nazarii_moshenskyi.countryinfo.ui.show_info.view.CountryDetailFragment;

import java.util.List;

public class ItemsPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "ItemsPagerAdapter";
    private final List<String> items;

    public ItemsPagerAdapter(FragmentManager fm, List<String> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        String countryName = items.get(position);
        Log.d(TAG, "getItem: " + countryName);
        return CountryDetailFragment.newInstance(countryName);
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

}
