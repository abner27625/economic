package com.abner.economic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.abner.economic.module.loginAndregister.LoginAndRegisterActivity;
import com.abner.economic.utils.UIUtils;

public abstract class MVPBaseActivity<T extends BasePresenter>  extends BaseActivity{
    public T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter= UIUtils.checkNotNull(createPresenter());
    }

    /**
     * 创建业务类
     * @return
     */
    public abstract T createPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        presenter.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
        presenter=null;
    }

    @Override
    public MVPBaseActivity getLSActivity() {
        return this;
    }
}
