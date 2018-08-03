package com.abner.economic.manager;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import com.abner.economic.R;
import com.abner.economic.utils.UIUtils;

/**
 * Created by loony on 2018/7/25.
 */

public class DialogManager {
    /*
    * 提现规则
    * */
    public static Dialog showWithdrawFeeRule(Activity activity){
        Dialog dialog = new Dialog(activity, R.style.dialog_style);
        View view = UIUtils.inflate(R.layout.dialog_withdraw_fee_rule);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(view);
        return dialog;
    }
}
