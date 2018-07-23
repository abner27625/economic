package com.abner.economic.module.discover;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.account.AccountFragment;
import com.abner.economic.module.quotes.TitleTabEntity;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * Created by loony on 2018/7/18.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverFragment> {

    public ArrayList<CustomTabEntity> tabEntities;
    public DiscoverAdapter discoverAdapter;

    public DiscoverPresenter(DiscoverFragment view) {
        super(view);
    }

    @Override
    public void initData() {
        tabEntities = new ArrayList<>();
        tabEntities.add(new TitleTabEntity("名师直播"));
        tabEntities.add(new TitleTabEntity("学习专区"));
        tabEntities.add(new TitleTabEntity("积分商城"));

        view.ctl_tab.setTabData(tabEntities);
        view.ctl_tab.setOnTabSelectListener(view);
        view.ctl_tab.setCurrentTab(0);

        initAdapter();

        view.rl_discover.setLayoutManager(new LinearLayoutManager(view.getXDActivity()));
        view.stl_refresh.autoRefresh();
        view.stl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    public void initAdapter(){
        discoverAdapter = new DiscoverAdapter();
        discoverAdapter.setOnLoadMoreListener(view,view.rl_discover);
        view.rl_discover.setAdapter(discoverAdapter);
    }
}
