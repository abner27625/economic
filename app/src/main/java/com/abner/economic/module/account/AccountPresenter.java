package com.abner.economic.module.account;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.KLine.ui.MainActivity;
import com.abner.economic.module.media.MediaActivity;
import com.abner.economic.module.withdraw.WithdrawActivity;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by loony on 2018/7/18.
 */

public class AccountPresenter extends BasePresenter<AccountFragment> {

    public AccountPresenter(AccountFragment view) {
        super(view);
    }

    @Override
    public void initData() {

    }

    public void update(){
        view.startActivity(new Intent(view.getLSActivity(), MediaActivity.class));
    }

    public void help(){
        view.startActivity(new Intent(view.getLSActivity(), MainActivity.class));
    }

    public void about(){
        Calendar calendar = Calendar.getInstance();
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        startCalendar.set(1930,1,1);
        endCalendar.set(2040,11,1);

        TimePickerView timePickerView = new TimePickerBuilder(view.getLSActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(view.getLSActivity(),date.getTime() + "", Toast.LENGTH_LONG).show();
            }
        })
                .setType(new boolean[]{true, true, false, false, false, false})
                .setRangDate(startCalendar,endCalendar)
                .setLineSpacingMultiplier(2.0f)
                .setLabel("","","","","","")
                .build();
        timePickerView.setDate(calendar);
        timePickerView.show();

    }

    public void toLoginOrRegister(){
        view.startActivity(new Intent(view.getLSActivity(), WithdrawActivity.class));
    }
}
