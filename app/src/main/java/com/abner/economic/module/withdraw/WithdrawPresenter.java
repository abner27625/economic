package com.abner.economic.module.withdraw;

import android.content.Intent;
import android.view.View;
import com.abner.economic.base.BasePresenter;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import java.util.ArrayList;

/**
 * Created by loony on 2018/7/25.
 */

public class WithdrawPresenter extends BasePresenter<WithdrawActivity> {
    public WithdrawPresenter(WithdrawActivity view) {
        super(view);
    }

    @Override
    public void initData() {

    }

    public void getBankName(){
        view.startActivityForResult(new Intent(view,BankInfoActivity.class),0);
    }

    public void getProvince(){
        final String[] province = {"北京市", "天津市", "上海市", "重庆市", "云南省", "内蒙古区", "吉林省", "四川省", "宁夏回族自治区", "安徽省", "山东省", "山西省", "广东省", "广西壮族自治区", "新疆维吾尔族自治区", "江苏省", "江西省", "河北省", "河南省", "浙江省", "海南省", "湖北省", "湖南省", "甘肃省", "福建省", "西藏自治区", "贵州省", "辽宁省", "陕西省","青海省", "黑龙江省"};
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0;i< province.length;i++){
            arrayList.add(province[i]);
        }
        OptionsPickerView optionsPickerView = new OptionsPickerBuilder(view.getLSActivity(), new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                view.tv_withdraw_bank_province.setText(province[options1]);
            }
        }).build();
        optionsPickerView.setPicker(arrayList);
        optionsPickerView.show();

    }

    public void getCity(){
        final String[] province = {"北京市", "天津市", "上海市", "重庆市", "云南省", "内蒙古区", "吉林省", "四川省", "宁夏回族自治区", "安徽省", "山东省", "山西省", "广东省", "广西壮族自治区", "新疆维吾尔族自治区", "江苏省", "江西省", "河北省", "河南省", "浙江省", "海南省", "湖北省", "湖南省", "甘肃省", "福建省", "西藏自治区", "贵州省", "辽宁省", "陕西省","青海省", "黑龙江省"};
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0;i< province.length;i++){
            arrayList.add(province[i]);
        }
        OptionsPickerView optionsPickerView = new OptionsPickerBuilder(view.getLSActivity(), new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                view.tv_withdraw_bank_city.setText(province[options1]);
            }
        }).build();
        optionsPickerView.setPicker(arrayList);
        optionsPickerView.show();
    }
}
