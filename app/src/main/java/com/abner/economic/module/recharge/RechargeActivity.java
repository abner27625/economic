package com.abner.economic.module.recharge;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;
import com.abner.economic.R;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/25.
 */

public class RechargeActivity extends BaseActivity<RechargePresenter> {

    @BindView(R.id.rv_recharge)
    RecyclerView rv_recharge;
    @BindView(R.id.rb_alipay)
    RadioButton rb_alipay;
    @BindView(R.id.rb_bank_pay)
    RadioButton rb_bank_pay;

    @Override
    public RechargePresenter createPresenter() {
        return new RechargePresenter(this);
    }

    @Override
    public ActionbarAttribute getActionbarAttribute() {
        return new ActionbarAttribute("充值");
    }

    @Override
    public boolean isContainFragments() {
        return false;
    }

    @Override
    public void init() {

        rb_alipay.setChecked(false);
        rb_bank_pay.setChecked(false);

        rb_alipay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb_alipay.setChecked(isChecked);
                rb_bank_pay.setChecked(!isChecked);
            }
        });
        rb_bank_pay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb_bank_pay.setChecked(isChecked);
                rb_alipay.setChecked(!isChecked);
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_recharge;
    }

    @OnClick({R.id.tv_recharge})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.tv_recharge:
                if(rb_bank_pay.isChecked() || rb_alipay.isChecked()){
                    Toast.makeText(this,"有一个选中了",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
