package com.abner.economic.module.discover.pointhistory;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abner.economic.R;
import com.abner.economic.base.ActionbarAttribute;
import com.abner.economic.base.BaseActivity;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by loony on 2018/7/24.
 */

public class PointHistoryActivity extends BaseActivity<PointHistoryPresenter> {

    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.rl_date)
    RelativeLayout rl_date;
    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    public int year;
    public int month;
    Calendar calendar = Calendar.getInstance();
    @Override
    public PointHistoryPresenter createPresenter() {
        return new PointHistoryPresenter(this);
    }

    @Override
    public ActionbarAttribute getActionbarAttribute() {
        return new ActionbarAttribute("兑换历史");
    }

    @Override
    public boolean isContainFragments() {
        return false;
    }

    @Override
    public void init() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) +1;
        tv_date.setText(year +"年" + month+"月");
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_point_history;
    }

    @OnClick({R.id.rl_date})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.rl_date:
                Calendar startCalendar = Calendar.getInstance();
                Calendar endCalendar = Calendar.getInstance();
                startCalendar.set(1930,1,1);
                endCalendar.set(2040,11,1);

                TimePickerView timePickerView = new TimePickerBuilder(getLSActivity(), new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        calendar.setTime(date);
                        year = calendar.get(Calendar.YEAR);
                        month = calendar.get(Calendar.MONTH) + 1;
                        tv_date.setText(year +"年" + month+"月");
                    }
                })
                        .setType(new boolean[]{true, true, false, false, false, false})
                        .setRangDate(startCalendar,endCalendar)
                        .setLineSpacingMultiplier(2.0f)
                        .setLabel("","","","","","")
                        .build();
                timePickerView.setDate(calendar);
                timePickerView.show();
                break;
        }
    }
}
