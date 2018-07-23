package com.abner.economic.module.quotes;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.abner.economic.base.BasePresenter;
import java.util.ArrayList;

/**
 * Created by loony on 2018/7/18.
 */

public class QuotesPresenter extends BasePresenter<QuotesFragment>  {

    public QuotesAdapter quotesAdapter;

    public String[] mtitles = {"爱淘","国际黄金","美国原油","上海期货","全球股指","外汇"};

    public ArrayList<Fragment> fragments = new ArrayList<>();
    public QuotesPresenter(QuotesFragment view) {
        super(view);
    }

    @Override
    public void initData() {
        fragments.clear();
        for(String title : mtitles){
//            fragments.add(QuotesView.getInstance());
            fragments.add(TestView.getInstance());
        }

        quotesAdapter = new QuotesAdapter(getActivity().getSupportFragmentManager(),mtitles,fragments);
        view.vp_quotes.setAdapter(quotesAdapter);
        view.ctl_tab.setOnTabSelectListener(view);

        view.ctl_tab.setViewPager(view.vp_quotes);
        view.vp_quotes.setCurrentItem(view.ctl_tab.getCurrentTab());

    }
}
