package com.abner.economic.module.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import butterknife.BindView;

/**
 * Created by loony on 2018/7/19.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements BaseQuickAdapter.RequestLoadMoreListener{
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.mian_home,null);
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
