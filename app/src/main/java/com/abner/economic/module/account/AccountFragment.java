package com.abner.economic.module.account;

import android.view.View;

import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;

/**
 * Created by loony on 2018/7/18.
 */

public class AccountFragment extends BaseFragment<AccountPresenter> {

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.main_account,null);
    }

    @Override
    public AccountPresenter createPresenter() {
        return new AccountPresenter(this);
    }

}
