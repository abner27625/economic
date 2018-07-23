package com.abner.economic.module.quotes;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by loony on 2018/7/18.
 */

public class QuotesFragment extends BaseFragment<QuotesPresenter> implements OnTabSelectListener,BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.ctl_tab)
    SlidingTabLayout ctl_tab;
//    @BindView(R.id.stl_refresh)
//    SmartRefreshLayout stl_refresh;
//    @BindView(R.id.rl_quotes)
//    RecyclerView rl_quotes;
    @BindView(R.id.vp_quotes)
    ViewPager vp_quotes;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.main_quotes,null);
    }

    @Override
    public QuotesPresenter createPresenter() {
        return new QuotesPresenter(this);
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
