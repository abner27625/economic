package com.abner.economic.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abner.economic.utils.UIUtils;
import com.trello.rxlifecycle2.components.support.RxFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Base2Fragment<T extends BasePresenter> extends RxFragment implements ActivityView{
    public T presenter;
    public View contentView;
    public LayoutInflater inflater;
    private Unbinder unbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater=inflater;
        contentView=setContentView();
        presenter= UIUtils.checkNotNull(createPresenter());
        unbinder=ButterKnife.bind(this,contentView);
        return contentView;

    }
    public abstract View setContentView();
    public abstract T createPresenter();

    @Override
    public void onResume() {
        super.onResume();
        presenter.initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public Activity getLSActivity() {
        return this.getActivity();
    }
}
