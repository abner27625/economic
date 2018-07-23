package com.abner.economic.module.discover;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by loony on 2018/7/18.
 */

public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements OnTabSelectListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.ctl_tab)
    CommonTabLayout ctl_tab;
    @BindView(R.id.stl_refresh)
    SmartRefreshLayout stl_refresh;
    @BindView(R.id.rl_discover)
    RecyclerView rl_discover;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.main_discover,null);
    }

    @Override
    public DiscoverPresenter createPresenter() {
        return new DiscoverPresenter(this);
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
