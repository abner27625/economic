package com.abner.economic.module.quotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abner.economic.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by loony on 2018/7/18.
 */

public class QuotesView extends Fragment implements BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.stl_refresh)
    SmartRefreshLayout stl_refresh;
    @BindView(R.id.rv_quotes)
    RecyclerView rv_quotes;

    public QuotesViewAdapter quotesAdapter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quotes_view,null);
        unbinder= ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quotesAdapter = new QuotesViewAdapter();
        rv_quotes.setAdapter(quotesAdapter);

//        stl_refresh.autoRefresh();
        stl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    @Override
    public void onLoadMoreRequested() {

    }

    public static QuotesView getInstance(){
        return new QuotesView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
