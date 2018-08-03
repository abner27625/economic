package com.abner.economic.module.media;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.abner.economic.R;
import com.dl7.player.media.IjkPlayerView;

/**
 * Created by loony on 2018/7/25.
 */

public class MediaActivity extends AppCompatActivity {

    public IjkPlayerView mPlayerViewFirst;
    public ImageView imageView;
    public IjkPlayerView mPlayerViewSecond;
    public IjkPlayerView mPlayerViewThird;
    public Uri mUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        mPlayerViewFirst = findViewById(R.id.player_view_first);
        imageView = findViewById(R.id.iv_tuceng);
//        mPlayerViewSecond = (IjkPlayerView) findViewById(R.id.player_view_second);
//        mPlayerViewThird = (IjkPlayerView) findViewById(R.id.player_view_third);
        mUri = Uri.parse("http://covertness.qiniudn.com/android_zaixianyingyinbofangqi_test_baseline.mp4");

        mPlayerViewFirst.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku();
//        mPlayerViewSecond.init()
//                .setVideoPath(mUri)
//                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
//                .enableDanmaku();
//        mPlayerViewThird.init()
//                .setVideoPath(mUri)
//                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
//                .enableDanmaku();
//        mPlayerViewFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPlayerViewFirst.start();
//            }
//        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                mPlayerViewFirst.start();
            }
        });
//        mPlayerViewSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPlayerViewSecond.start();
//            }
//        });
//        mPlayerViewThird.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPlayerViewThird.start();
//            }
//        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPlayerViewFirst.onResume();
//        mPlayerViewSecond.onResume();
//        mPlayerViewThird.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerViewFirst.onPause();
//        mPlayerViewSecond.onPause();
//        mPlayerViewThird.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerViewFirst.onDestroy();
//        mPlayerViewSecond.onDestroy();
//        mPlayerViewThird.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        newConfig.orientation = 1;
        mPlayerViewFirst.configurationChanged(newConfig);
//        mPlayerViewSecond.configurationChanged(newConfig);
//        mPlayerViewThird.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerViewFirst.handleVolumeKey(keyCode)) {
            return true;
        }
//        if (mPlayerViewSecond.handleVolumeKey(keyCode)) {
//            return true;
//        }
//        if (mPlayerViewThird.handleVolumeKey(keyCode)) {
//            return true;
//        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerViewFirst.onBackPressed()) {
            return;
        }
//        if (mPlayerViewSecond.onBackPressed()) {
//            return;
//        }
//        if (mPlayerViewThird.onBackPressed()) {
//            return;
//        }
        super.onBackPressed();
    }
}
