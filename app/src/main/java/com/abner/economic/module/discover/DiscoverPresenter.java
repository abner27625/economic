package com.abner.economic.module.discover;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.discover.pointmall.PointMallFragment;
import com.abner.economic.module.quotes.TestView;

/**
 * Created by loony on 2018/7/18.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverFragment> {

    public String[] mtitles = {"名师直播","学习专区","积分商城"};
    public DiscoverAdapter discoverAdapter;

    public DiscoverPresenter(DiscoverFragment view) {
        super(view);
    }

    @Override
    public void initData() {
        discoverAdapter = new DiscoverAdapter(getActivity().getSupportFragmentManager());
        view.vp_discover.setAdapter(discoverAdapter);
        view.ctl_tab.setOnTabSelectListener(view);
        view.ctl_tab.setViewPager(view.vp_discover,mtitles);
        view.vp_discover.setCurrentItem(view.ctl_tab.getCurrentTab());
    }

    class DiscoverAdapter extends FragmentPagerAdapter{

        public DiscoverAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment view;
             if(position == 2){
                view = new PointMallFragment();
            }  else {
                view = new TestView();
            }
            return view;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
