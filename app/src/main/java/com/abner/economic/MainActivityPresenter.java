package com.abner.economic;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.account.AccountFragment;
import com.abner.economic.module.discover.DiscoverFragment;
import com.abner.economic.module.home.HomeFragment;
import com.abner.economic.module.quotes.QuotesFragment;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivityPresenter extends BasePresenter<MainActivity> {
    private FragmentManager fm;
    private FragmentTransaction ft;
    private AccountFragment accountFragment;
    private QuotesFragment quotesFragment;
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private Fragment current;
    private static Boolean isExit = false;
    public MainActivityPresenter(MainActivity view) {
        super(view);
        init();
    }

    @Override
    public void initData() {

    }
    private void init(){
        accountFragment = new AccountFragment();
        quotesFragment = new QuotesFragment();
        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        fm= view.getFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.fl_mainactivity, homeFragment);
        ft.commit();
    }
    public void homeFragmentClick(){
        switchFragment(accountFragment,quotesFragment,discoverFragment,homeFragment);

    }
    public void accountFragmentClick(){
        switchFragment(quotesFragment,discoverFragment,homeFragment,accountFragment);
    }
    public void quotesFragmentClick(){
        switchFragment(accountFragment,discoverFragment,homeFragment,quotesFragment);
    }

    public void discoverFragmentClick(){
        switchFragment(accountFragment,quotesFragment,homeFragment,discoverFragment);
    }

    private void switchFragment(Fragment from1,Fragment from2,Fragment from3,Fragment to){
       FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if(to!=current){
            current=to;
            if (to.isAdded()) {
                fragmentTransaction.hide(from1).hide(from2).hide(from3).show(to).commitAllowingStateLoss();
            }else{
                fragmentTransaction.hide(from1).hide(from2).hide(from3).add(R.id.fl_mainactivity,to).show(to).commitAllowingStateLoss();
            }
        }
    }

    /**
     * 双击退出应用
     */
    protected void exitBy2Click() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true;
            Toast.makeText(view, "再按一次退出程序", Toast.LENGTH_LONG).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }
}
