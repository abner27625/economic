package com.abner.economic.module.quotes;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by loony on 2018/7/19.
 */

public class QuotesAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment> mFragment;
    public String[] mtitles;

    public QuotesAdapter(FragmentManager fm,String[] titles, ArrayList<Fragment> fragments) {
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
