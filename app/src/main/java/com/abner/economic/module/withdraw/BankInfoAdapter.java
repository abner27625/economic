package com.abner.economic.module.withdraw;

import android.util.Log;

import com.abner.economic.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by loony on 2018/7/25.
 */

public class BankInfoAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public BankInfoAdapter() {
        super(R.layout.item_bankinfo);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_bankname,item).addOnClickListener(R.id.ll_item);
    }
}
