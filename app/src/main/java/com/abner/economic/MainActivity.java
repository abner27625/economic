package com.abner.economic;

import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.MVPBaseActivity;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends MVPBaseActivity<MainActivityPresenter> {

    @BindView(R.id.main_first)
    RelativeLayout main_first;
    @BindView(R.id.main_second)
    RelativeLayout main_second;
    @BindView(R.id.main_third)
    RelativeLayout main_third;
    @BindView(R.id.main_forth)
    RelativeLayout main_forth;
    @BindView(R.id.main_fifth)
    RelativeLayout main_fifth;

    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter(this);
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

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.main_first,R.id.main_second,R.id.main_third,R.id.main_forth,R.id.main_fifth})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.main_first:
                presenter.homeFragmentClick();
                break;
            case R.id.main_second:
                presenter.quotesFragmentClick();
                break;
            case R.id.main_third:
                presenter.discoverFragmentClick();
                break;
            case R.id.main_forth:
                presenter.accountFragmentClick();
                break;
            case R.id.main_fifth:
                presenter.exchangeFragmentClick();
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    presenter.exitBy2Click();
                    return false;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
