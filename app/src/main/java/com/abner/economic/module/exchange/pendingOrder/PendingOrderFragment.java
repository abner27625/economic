package com.abner.economic.module.exchange.pendingOrder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.abner.economic.R;
import com.abner.economic.base.Base2Fragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

public class PendingOrderFragment extends Base2Fragment<PendingOrderPresenter> implements OnTabSelectListener {

    @BindView(R.id.rv_pendingOrder)
    RecyclerView rv_pendingOrder;
    @BindView(R.id.ctl_tab)
    CommonTabLayout ctl_tab;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.view_pendingorder,null);
    }

    @Override
    public PendingOrderPresenter createPresenter() {
        return new PendingOrderPresenter(this);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
