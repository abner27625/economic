package com.abner.economic.module.loginAndregister;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.abner.economic.R;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.BaseActivity;
import com.abner.economic.utils.UIUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/25.
 */

public class LoginAndRegisterActivity extends BaseActivity<LoginAndRegisterPresenter> implements OnTabSelectListener{
    @BindView(R.id.ctl_tab)
    CommonTabLayout ctl_tab;
    @BindView(R.id.rl_background)
    RelativeLayout rl_background;
    @BindView(R.id.ll_content)
    LinearLayout ll_content;

    public View view1;
    public View view2;
    @Override
    public LoginAndRegisterPresenter createPresenter() {
        return new LoginAndRegisterPresenter(this);
    }

    @Override
    public ActionbarAttribute getActionbarAttribute() {
        return new ActionbarAttribute(View.GONE);
    }

    @Override
    public boolean isContainFragments() {
        return false;
    }

    @Override
    public void init() {
        view1 = UIUtils.inflate(R.layout.activity_login);
        view2 = UIUtils.inflate(R.layout.activity_register);
        ll_content.addView(view1);
        ll_content.addView(view2);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login_and_register;
    }

    @Override
    public void onTabSelect(int position) {
        if(position == 0){
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.GONE);
        } else {
            view1.setVisibility(View.GONE);
            view2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onTabReselect(int position) {

    }

    @OnClick({R.id.rl_background})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.rl_background:
                finish();
                break;
        }
    }
}
