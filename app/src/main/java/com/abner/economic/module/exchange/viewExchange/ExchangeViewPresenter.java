package com.abner.economic.module.exchange.viewExchange;

import com.abner.economic.R;
import com.abner.economic.base.BasePresenter;

public class ExchangeViewPresenter extends BasePresenter<ExchangeView> {

    public ExchangeViewAdapter exchangeViewAdapter;

    public ExchangeViewPresenter(ExchangeView view) {
        super(view);
    }

    @Override
    public void initData() {

    }

    public void initAdapter(){
        int layoutId = 0;
        if(view.mType == 0){
            layoutId = R.layout.item_exchange_first;
        } else {
            layoutId = 0;
        }
        exchangeViewAdapter = new ExchangeViewAdapter(layoutId,view.mType);
    }
}
