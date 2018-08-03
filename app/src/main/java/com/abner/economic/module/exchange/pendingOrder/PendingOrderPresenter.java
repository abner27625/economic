package com.abner.economic.module.exchange.pendingOrder;

import android.support.v7.widget.LinearLayoutManager;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.quotes.TitleTabEntity;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class PendingOrderPresenter extends BasePresenter<PendingOrderFragment> {

    public PendingOrderAdapter pendingOrderAdapter;
    public ArrayList<CustomTabEntity> arrayList;
    public PendingOrderPresenter(PendingOrderFragment view) {
        super(view);
    }

    @Override
    public void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new TitleTabEntity("正在挂单"));
        arrayList.add(new TitleTabEntity("历史记录"));

        view.ctl_tab.setTabData(arrayList);
        view.ctl_tab.setOnTabSelectListener(view);
        view.ctl_tab.setCurrentTab(view.ctl_tab.getCurrentTab());

        view.rv_pendingOrder.setLayoutManager(new LinearLayoutManager(view.getLSActivity()));
        initAdapter();
    }

    public void initAdapter(){
        pendingOrderAdapter = new PendingOrderAdapter();
        view.rv_pendingOrder.setAdapter(pendingOrderAdapter);
    }
}
