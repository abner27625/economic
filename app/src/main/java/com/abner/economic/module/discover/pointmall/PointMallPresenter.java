package com.abner.economic.module.discover.pointmall;

import com.abner.economic.base.BasePresenter;

/**
 * Created by loony on 2018/7/24.
 */

public class PointMallPresenter extends BasePresenter<PointMallFragment>{
    public PointMallAdapter pointMallAdapter;

    public PointMallPresenter(PointMallFragment view) {
        super(view);
    }

    @Override
    public void initData() {
    }

    public void initAdapter(){
        pointMallAdapter = new PointMallAdapter();
        pointMallAdapter.setOnLoadMoreListener(view,view.rv_coupon);
        view.rv_coupon.setAdapter(pointMallAdapter);
    }
}
