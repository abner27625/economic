package com.abner.economic.module.withdraw;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.abner.economic.R;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.BaseActivity;
import com.abner.economic.manager.DialogManager;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/25.
 */

public class WithdrawActivity extends BaseActivity<WithdrawPresenter> {

    @BindView(R.id.et_withdraw_money)
    EditText et_withdraw_money;
    @BindView(R.id.tv_withdraw_money_hint)
    TextView tv_withdraw_money_hint;
    @BindView(R.id.tv_withdraw_fee)
    TextView tv_withdraw_fee;
    @BindView(R.id.iv_withdraw_question)
    ImageView iv_withdraw_question;
    @BindView(R.id.rl_bank_name)
    RelativeLayout rl_bank_name;
    @BindView(R.id.tv_withdraw_bank_name)
    TextView tv_withdraw_bank_name;
    @BindView(R.id.et_withdraw_bank_code)
    EditText et_withdraw_bank_code;
    @BindView(R.id.et_withdraw_bank_person_name)
    EditText et_withdraw_bank_person_name;
    @BindView(R.id.rl_bank_province)
    RelativeLayout rl_bank_province;
    @BindView(R.id.tv_withdraw_bank_province)
    TextView tv_withdraw_bank_province;
    @BindView(R.id.rl_bank_city)
    RelativeLayout rl_bank_city;
    @BindView(R.id.tv_withdraw_bank_city)
    TextView tv_withdraw_bank_city;
    @BindView(R.id.et_withdraw_subname)
    EditText et_withdraw_subname;
    @BindView(R.id.tv_withdraw)
    TextView tv_withdraw;

    @Override
    public WithdrawPresenter createPresenter() {
        return new WithdrawPresenter(this);
    }

    @Override
    public ActionbarAttribute getActionbarAttribute() {
        return new ActionbarAttribute("提现");
    }

    @Override
    public boolean isContainFragments() {
        return false;
    }

    @Override
    public void init() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_withdraw;
    }

    @OnClick({R.id.iv_withdraw_question,R.id.rl_bank_name,R.id.rl_bank_province,R.id.rl_bank_city,R.id.tv_withdraw})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.iv_withdraw_question:
                DialogManager.showWithdrawFeeRule(getLSActivity()).show();
                break;
            case R.id.rl_bank_name:
                presenter.getBankName();
                break;
            case R.id.rl_bank_province:
                presenter.getProvince();
                break;
            case R.id.rl_bank_city:
                presenter.getCity();
                break;
            case R.id.tv_withdraw:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 0){
                tv_withdraw_bank_name.setText(data.getStringExtra("bankName"));
            }
        }
    }
}
