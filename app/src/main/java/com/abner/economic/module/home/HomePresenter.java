package com.abner.economic.module.home;

import com.abner.economic.base.BasePresenter;
import com.abner.economic.module.home.banner.GlideImageLoader;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;

/**
 * Created by loony on 2018/7/19.
 */

public class HomePresenter extends BasePresenter<HomeFragment> {

    public ArrayList<String> images = new ArrayList();
    public HomeAdapter homeAdapter;

    public HomePresenter(HomeFragment view) {
        super(view);
    }

    @Override
    public void initData() {

        images.clear();
        images.add("https://static.hexindai.com/attachment/uploads/homepic/2018/07/03/1530602680_homepic.png");
        images.add("https://static.hexindai.com/attachment/uploads/homepic/2018/06/08/1528441400_homepic.jpg");
        images.add("https://static.hexindai.com/attachment/uploads/homepic/2018/07/03/1530602490_homepic.jpg");

        //设置banner样式
        view.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        view.banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        view.banner.setImages(images);
        //设置banner动画效果
        view.banner.setBannerAnimation(Transformer.Stack);
        //设置自动轮播，默认为true
        view.banner.isAutoPlay(true);
        //设置轮播时间
        view.banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        view.banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        view.banner.start();

        initAdapter();
    }


    public void initAdapter(){
        homeAdapter = new HomeAdapter();
        homeAdapter.setOnLoadMoreListener(view,view.rl_view);
        view.rl_view.setAdapter(homeAdapter);

    }

}
