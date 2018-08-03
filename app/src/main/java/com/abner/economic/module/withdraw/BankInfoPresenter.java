package com.abner.economic.module.withdraw;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.abner.economic.base.BasePresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.ArrayList;


/**
 * Created by loony on 2018/7/25.
 */

public class BankInfoPresenter extends BasePresenter<BankInfoActivity> {

    public BankInfoAdapter bankInfoAdapter;
    public ArrayList<String> arrayList;

    public BankInfoPresenter(BankInfoActivity view) {
        super(view);
    }

    @Override
    public void initData() {
        arrayList = getData();
        initAdapter();
    }

    public void initAdapter(){
        view.rv_bankinfo.setLayoutManager(new LinearLayoutManager(view));
        bankInfoAdapter = new BankInfoAdapter();
        view.rv_bankinfo.setAdapter(bankInfoAdapter);
        bankInfoAdapter.setNewData(arrayList);
        view.rv_bankinfo.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("bankName",arrayList.get(position));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    public ArrayList<String> getData(){
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i =0 ;i< 10;i++){
            arrayList.add("中国银行   " + i);
        }
        return arrayList;
    }
}
