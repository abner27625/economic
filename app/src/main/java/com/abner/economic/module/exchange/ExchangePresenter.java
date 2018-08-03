package com.abner.economic.module.exchange;

import android.support.v4.app.Fragment;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.exchange.pendingOrder.PendingOrderFragment;
import com.abner.economic.module.exchange.viewExchange.ExchangeView;

import java.util.ArrayList;

/**
 * Created by loony on 2018/7/18.
 */

public class ExchangePresenter extends BasePresenter<ExchangeFragment> {

    public ExchangeAdapter exchangeAdapter;
    public String[] titles = {"买卖","持仓","挂单","交易记录","资金"};
    public ArrayList<Fragment> fragments = new ArrayList<>();

    public ExchangePresenter(ExchangeFragment view) {
        super(view);
    }

    @Override
    public void initData() {
        fragments.clear();
        for(int i =0 ;i< titles.length;i++){
            if("挂单".equals(titles[i])){
                fragments.add(new PendingOrderFragment());
            } else {
                fragments.add(new ExchangeView().getInstance(i));
            }
        }
        initAdapter();
        view.ctl_tab.setViewPager(view.vp_exchange);
        view.ctl_tab.setCurrentTab(view.ctl_tab.getCurrentTab());
    }

    public void initAdapter(){
        exchangeAdapter = new ExchangeAdapter(getActivity().getSupportFragmentManager(),titles,fragments);
        view.vp_exchange.setAdapter(exchangeAdapter);
    }
}
