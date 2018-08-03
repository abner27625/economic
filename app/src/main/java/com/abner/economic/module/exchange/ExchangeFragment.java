package com.abner.economic.module.exchange;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/18.
 */

public class ExchangeFragment extends BaseFragment<ExchangePresenter> implements OnTabSelectListener,BaseQuickAdapter.RequestLoadMoreListener{
    @BindView(R.id.ctl_tab)
    SlidingTabLayout ctl_tab;
    @BindView(R.id.vp_exchange)
    ViewPager vp_exchange;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.main_exchange,null);
    }

    @Override
    public ExchangePresenter createPresenter() {
        return new ExchangePresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
