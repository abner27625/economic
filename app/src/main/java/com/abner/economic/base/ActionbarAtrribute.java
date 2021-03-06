package com.abner.economic.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.abner.economic.R;

public class ActionbarAtrribute {
    private String mLeftTitle = "";
    private int mLeftImageId = R.drawable.actionbar_jiantou;
    private String mCenterString = "TODO";
    private String mRightTitle;
    private OnClickListener mRightOnClickListener;
    private int mVisible = View.VISIBLE;
    private int mRightImageId = 0;
    private boolean ivVisible = true;
    public int mRightTextcolor = 0;

    public ActionbarAtrribute(String centerString, String rightTitle, OnClickListener rightOnClickListener) {
        this(centerString, rightTitle, rightOnClickListener, View.VISIBLE);
    }

    public ActionbarAtrribute(int visible) {
        mVisible = visible;
    }

    public ActionbarAtrribute(String centerString) {
        mCenterString = centerString;
    }


    public ActionbarAtrribute(String centerString, String rightTitle, OnClickListener rightOnClickListener, int visible) {
        mCenterString = centerString;
        mRightTitle = rightTitle;
        mRightOnClickListener = rightOnClickListener;
        mVisible = visible;
    }

    public String getLeftTitle() {
        return mLeftTitle;
    }

    public ActionbarAtrribute setLeftTitle(String leftTitle) {
        mLeftTitle = leftTitle;
        return this;
    }

    public int getLeftImageId() {
        return mLeftImageId;
    }

    public ActionbarAtrribute setLeftImageId(int leftImageId) {
        mLeftImageId = leftImageId;
        return this;
    }

    public String getCenterString() {
        return mCenterString;
    }

    public ActionbarAtrribute setCenterString(String centerString) {
        mCenterString = centerString;
        return this;
    }

    public String getRightTitle() {
        return mRightTitle;
    }

    public ActionbarAtrribute setRightTitle(String rightTitle) {
        mRightTitle = rightTitle;
        return this;
    }
    public ActionbarAtrribute setRightTextColor(int rightTextColor){
        mRightTextcolor = rightTextColor;
        return this;
    }
    public int getRightTextColor(){
        return mRightTextcolor;
    }
    public ActionbarAtrribute setRightBackground(int icon){
        mRightImageId = icon;
        return this;
    }
    public int getmRightImageId(){
        return mRightImageId;
    }
    public OnClickListener getRightOnClickListener() {
        return mRightOnClickListener;
    }

    public ActionbarAtrribute setRightOnClickListener(OnClickListener rightOnClickListener) {
        mRightOnClickListener = rightOnClickListener;
        return this;
    }

    public int getVisible() {
        return mVisible;
    }

    public ActionbarAtrribute setVisible(int visible) {
        mVisible = visible;
        return this;
    }

    public ActionbarAtrribute setmLeftImageVisible(boolean visible){
        ivVisible = visible;
        return this;
    }
    public boolean getmLeftImageVisible(){
        return ivVisible;
    }
}
