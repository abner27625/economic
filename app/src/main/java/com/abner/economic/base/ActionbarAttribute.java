package com.abner.economic.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.abner.economic.R;

public class ActionbarAttribute {
    private String mLeftTitle = "";
    private int mLeftImageId = R.drawable.actionbar_jiantou;
    private String mCenterString = "TODO";
    private String mRightTitle;
    private OnClickListener mRightOnClickListener;
    private int mVisible = View.VISIBLE;
    private int mRightImageId = 0;
    private boolean ivVisible = true;
    public int mRightTextcolor = 0;

    public ActionbarAttribute(String centerString, String rightTitle, OnClickListener rightOnClickListener) {
        this(centerString, rightTitle, rightOnClickListener, View.VISIBLE);
    }

    public ActionbarAttribute(int visible) {
        mVisible = visible;
    }

    public ActionbarAttribute(String centerString) {
        mCenterString = centerString;
    }


    public ActionbarAttribute(String centerString, String rightTitle, OnClickListener rightOnClickListener, int visible) {
        mCenterString = centerString;
        mRightTitle = rightTitle;
        mRightOnClickListener = rightOnClickListener;
        mVisible = visible;
    }

    public String getLeftTitle() {
        return mLeftTitle;
    }

    public ActionbarAttribute setLeftTitle(String leftTitle) {
        mLeftTitle = leftTitle;
        return this;
    }

    public int getLeftImageId() {
        return mLeftImageId;
    }

    public ActionbarAttribute setLeftImageId(int leftImageId) {
        mLeftImageId = leftImageId;
        return this;
    }

    public String getCenterString() {
        return mCenterString;
    }

    public ActionbarAttribute setCenterString(String centerString) {
        mCenterString = centerString;
        return this;
    }

    public String getRightTitle() {
        return mRightTitle;
    }

    public ActionbarAttribute setRightTitle(String rightTitle) {
        mRightTitle = rightTitle;
        return this;
    }
    public ActionbarAttribute setRightTextColor(int rightTextColor){
        mRightTextcolor = rightTextColor;
        return this;
    }
    public int getRightTextColor(){
        return mRightTextcolor;
    }
    public ActionbarAttribute setRightBackground(int icon){
        mRightImageId = icon;
        return this;
    }
    public int getmRightImageId(){
        return mRightImageId;
    }
    public OnClickListener getRightOnClickListener() {
        return mRightOnClickListener;
    }

    public ActionbarAttribute setRightOnClickListener(OnClickListener rightOnClickListener) {
        mRightOnClickListener = rightOnClickListener;
        return this;
    }

    public int getVisible() {
        return mVisible;
    }

    public ActionbarAttribute setVisible(int visible) {
        mVisible = visible;
        return this;
    }

    public ActionbarAttribute setmLeftImageVisible(boolean visible){
        ivVisible = visible;
        return this;
    }
    public boolean getmLeftImageVisible(){
        return ivVisible;
    }
}
