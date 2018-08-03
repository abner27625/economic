package com.abner.economic.module.exchange.viewExchange;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.abner.economic.R;
import com.abner.economic.base.Base2Fragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ExchangeView extends Base2Fragment<ExchangeViewPresenter> implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.stl_refresh)
    SmartRefreshLayout stl_refresh;
    @BindView(R.id.rv_quotes)
    RecyclerView rv_quotes;

    public int mType;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.view_recyclerview,null);
    }

    @Override
    public ExchangeViewPresenter createPresenter() {
        return new ExchangeViewPresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    public ExchangeView getInstance(int type){
        this.mType = type;
        return new ExchangeView();
    }
}
