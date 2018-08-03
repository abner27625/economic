package com.abner.economic.module.discover.pointmall;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import com.abner.economic.R;
import com.abner.economic.base.Base2Fragment;
import com.abner.economic.module.discover.pointhistory.PointHistoryActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/24.
 */

public class PointMallFragment extends Base2Fragment<PointMallPresenter> implements BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.rv_coupon)
    RecyclerView rv_coupon;
    @BindView(R.id.rl_history)
    RelativeLayout rl_history;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.fragment_point_mall,null);
    }

    @Override
    public PointMallPresenter createPresenter() {
        return new PointMallPresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    @OnClick({R.id.rl_history})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.rl_history:
                startActivity(new Intent(view.getContext(), PointHistoryActivity.class));
                break;
        }
    }
}
