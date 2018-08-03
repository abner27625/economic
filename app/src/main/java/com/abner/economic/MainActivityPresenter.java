package com.abner.economic;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;
import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.account.AccountFragment;
import com.abner.economic.module.discover.DiscoverFragment;
import com.abner.economic.module.exchange.ExchangeFragment;
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
    private ExchangeFragment exchangeFragment;
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
//        view.btb_bar.init(getActivity().getSupportFragmentManager()).setImgSize(50,50)
//                .setFontSize(8)
//                .setTabPadding(4,6,10)
//                .setChangeColor(UIUtils.getColor(R.color.color_008dfe),UIUtils.getColor(R.color.color_333333))
//                .addTabItem("首页",R.drawable.tab_home, HomeFragment.class)
//                .addTabItem("行情",R.drawable.tab_quotes, QuotesFragment.class)
//                .addTabItem("发现",R.drawable.tab_home, DiscoverFragment.class)
//                .addTabItem("我",R.drawable.tab_quotes, AccountFragment.class)
//                .isShowDivider(false)
//                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
//                    @Override
//                    public void onTabChange(int position, String name) {
//                        switch(position){
//                            case 0:
//
//                                break;
//                            case 1:
//                                break;
//                            case 2:
//                                break;
//                            case 3:
//                                break;
//                        }
//                    }
//                });

        accountFragment = new AccountFragment();
        quotesFragment = new QuotesFragment();
        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        exchangeFragment = new ExchangeFragment();

        fm= view.getFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.fl_mainactivity, homeFragment);
        ft.commit();
    }
    public void homeFragmentClick(){
        switchFragment(accountFragment,quotesFragment,discoverFragment,exchangeFragment,homeFragment);

    }
    public void accountFragmentClick(){
        switchFragment(quotesFragment,discoverFragment,homeFragment,exchangeFragment,accountFragment);
    }
    public void quotesFragmentClick(){
        switchFragment(accountFragment,discoverFragment,homeFragment,exchangeFragment,quotesFragment);
    }

    public void discoverFragmentClick(){
        switchFragment(accountFragment,quotesFragment,homeFragment,exchangeFragment,discoverFragment);
    }

    public void exchangeFragmentClick(){
        switchFragment(accountFragment,quotesFragment,homeFragment,discoverFragment,exchangeFragment);
    }

    private void switchFragment(Fragment from1,Fragment from2,Fragment from3,Fragment from4,Fragment to){
       FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if(to!=current){
            current=to;
            if (to.isAdded()) {
                fragmentTransaction.hide(from1).hide(from2).hide(from3).hide(from4).show(to).commitAllowingStateLoss();
            }else{
                fragmentTransaction.hide(from1).hide(from2).hide(from3).hide(from4).add(R.id.fl_mainactivity,to).show(to).commitAllowingStateLoss();
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
