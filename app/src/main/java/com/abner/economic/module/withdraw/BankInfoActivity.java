package com.abner.economic.module.withdraw;

import android.support.v7.widget.RecyclerView;
import com.abner.economic.R;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.BaseActivity;
import butterknife.BindView;

/**
 * Created by loony on 2018/7/25.
 */

public class BankInfoActivity extends BaseActivity<BankInfoPresenter> {

    @BindView(R.id.rv_bankinfo)
    RecyclerView rv_bankinfo;

    @Override
    public BankInfoPresenter createPresenter() {
        return new BankInfoPresenter(this);
    }

    @Override
    public ActionbarAttribute getActionbarAttribute() {
        return new ActionbarAttribute("选择银行");
    }

    @Override
    public boolean isContainFragments() {
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_bankinfo;
    }

}
