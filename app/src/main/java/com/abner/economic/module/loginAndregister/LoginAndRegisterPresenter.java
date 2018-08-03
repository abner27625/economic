package com.abner.economic.module.loginAndregister;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.quotes.TitleTabEntity;
import com.abner.economic.utils.UIUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import java.util.ArrayList;

/**
 * Created by loony on 2018/7/25.
 */

public class LoginAndRegisterPresenter extends BasePresenter<LoginAndRegisterActivity> {

    public ArrayList<CustomTabEntity> arrayList = new ArrayList<>();

    public LoginAndRegisterPresenter(LoginAndRegisterActivity view) {
        super(view);
    }

    @Override
    public void initData() {
        arrayList.add(new TitleTabEntity("登录"));
        arrayList.add(new TitleTabEntity("注册"));
        view.ctl_tab.setTabData(arrayList);
        view.ctl_tab.setCurrentTab(view.ctl_tab.getCurrentTab());
        view.ctl_tab.setOnTabSelectListener(view);

        if(view.ctl_tab.getCurrentTab() == 0){
            view.view1.setVisibility(View.VISIBLE);
            view.view2.setVisibility(View.GONE);
        } else {
            view.view1.setVisibility(View.GONE);
            view.view2.setVisibility(View.VISIBLE);
        }

        if(UIUtils.keyBoard(view)){
            animate(view.rl_background);
        } else {
            animates(view.rl_background);
        }

    }

    public void animate(View view){
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view,"translationY",60,0);
        translationY.setDuration(200);
        translationY.start();
    }

    public void animates(View view){
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view,"translationY",0,60);
        translationY.setDuration(200);
        translationY.start();
    }

}
