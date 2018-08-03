package com.abner.economic.base;

import android.content.Intent;
import com.abner.economic.R;

public abstract class BasePresenter<T extends ActivityView> {
    public T view;
    public T getActivityView(){return view;}
    public MVPBaseActivity getActivity(){return (MVPBaseActivity) view.getLSActivity();}
    public BasePresenter(T view){
        this.view=view;
    }
    public abstract void initData();
    public void finish(){
        view.getLSActivity().finish();
        view.getLSActivity().overridePendingTransition(0, R.anim.back_right_out);
    }

    public void startActivity(Intent intent){
        view.getLSActivity().startActivity(intent);
        view.getLSActivity().  overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
    public void startActivityForResult(Intent intent,int requestCode){
        view.getLSActivity().startActivityForResult(intent, requestCode);
        view.getLSActivity().  overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    public void setResult(int resultCode,Intent intent){
        view.getLSActivity().setResult(resultCode, intent);
        view.getLSActivity().  overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
    public void destory(){
        view=null;
    }
}
