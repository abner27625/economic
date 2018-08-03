package com.abner.economic.module.exchange.viewExchange;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ExchangeViewAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    public int mState;
    public ExchangeViewAdapter(int layoutResId,int state) {
        super(layoutResId);
        this.mState = state;
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        initItem(item,mState);
    }

    public void initItem(Object item,int state){
        switch (state){
            case 0:
                break;
            case 1:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
