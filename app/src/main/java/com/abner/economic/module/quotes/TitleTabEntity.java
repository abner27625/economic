package com.abner.economic.module.quotes;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by loony on 2018/7/18.
 */

public class TitleTabEntity implements CustomTabEntity{
    private String title;
    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }

    public TitleTabEntity(String title){
        this.title = title;
    }
}
