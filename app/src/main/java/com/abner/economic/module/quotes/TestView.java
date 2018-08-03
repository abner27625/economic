package com.abner.economic.module.quotes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.Base2Fragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by loony on 2018/7/18.
 */

public class TestView extends Base2Fragment<QuotesViewPresenter> implements BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.stl_refresh)
    SmartRefreshLayout stl_refresh;
    @BindView(R.id.rv_quotes)
    RecyclerView rv_quotes;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.view_recyclerview,null);
    }

    @Override
    public QuotesViewPresenter createPresenter() {
        return new QuotesViewPresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    public static TestView getInstance(){
        return new TestView();
    }

}
