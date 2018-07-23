package com.abner.economic.module.quotes;

import android.support.annotation.NonNull;
import com.abner.economic.base.BasePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by loony on 2018/7/18.
 */

public class QuotesViewPresenter extends BasePresenter<TestView>  {

    public QuotesViewAdapter quotesAdapter;

    public QuotesViewPresenter(TestView view) {
        super(view);
    }

    @Override
    public void initData() {

        quotesAdapter = new QuotesViewAdapter();
        view.rv_quotes.setAdapter(quotesAdapter);

        view.stl_refresh.autoRefresh();
        view.stl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }


}
