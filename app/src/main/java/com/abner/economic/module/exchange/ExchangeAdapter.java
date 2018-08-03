package com.abner.economic.module.exchange;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by loony on 2018/7/19.
 */

public class ExchangeAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment> mFragment;
    public String[] mtitles;

    public ExchangeAdapter(FragmentManager fm, String[] titles, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragment = fragments;
        this.mtitles = titles;
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles[position];
    }
}
