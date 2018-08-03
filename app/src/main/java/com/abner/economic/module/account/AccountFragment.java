package com.abner.economic.module.account;

import android.view.View;
import android.widget.RelativeLayout;
import com.abner.economic.R;
import com.abner.economic.base.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/18.
 */

public class AccountFragment extends BaseFragment<AccountPresenter> {
    @BindView(R.id.rl_help)
    RelativeLayout rl_help;
    @BindView(R.id.rl_about)
    RelativeLayout rl_about;
    @BindView(R.id.rl_update)
    RelativeLayout rl_update;
    @BindView(R.id.rl_login_or_register)
    RelativeLayout rl_login_or_register;

    @Override
    public View setContentView() {
        return inflater.inflate(R.layout.main_account,null);
    }

    @Override
    public AccountPresenter createPresenter() {
        return new AccountPresenter(this);
    }

    @OnClick({R.id.rl_help,R.id.rl_update,R.id.rl_about,R.id.rl_login_or_register})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.rl_help:
                presenter.help();
                break;
            case R.id.rl_about:
                presenter.about();
                break;
            case R.id.rl_update:
                presenter.update();
                break;
            case R.id.rl_login_or_register:
                presenter.toLoginOrRegister();
                break;
        }
    }
}
