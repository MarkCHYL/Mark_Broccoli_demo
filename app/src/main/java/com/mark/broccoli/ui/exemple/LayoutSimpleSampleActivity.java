package com.mark.broccoli.ui.exemple;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.mark.broccoli.R;

import me.samlss.broccoli.Broccoli;

/**
 * @Desc
 * @作者 Mark
 * @时间 2019/1/18
 * @EMail 2285581945@qq.com
 */
public class LayoutSimpleSampleActivity extends AppCompatActivity {
    private Broccoli mBroccoli;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#847465"));
        }
        setContentView(R.layout.activity_simple_layout);


        initView();
        initPlaceholers();
    }

    private void initPlaceholers() {
        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(this,R.id.tv_title, R.id.tv_view_time, R.id.tv_collect_time,
                R.id.tv_price, R.id.iv_clock, R.id.tv_time, R.id.iv_calendar, R.id.iv_location,
                R.id.tv_location, R.id.iv_arrow_right, R.id.iv_logo, R.id.tv_organizer_name, R.id.tv_organizer_description,
                R.id.tv_fans, R.id.tv_fans_number, R.id.tv_events, R.id.tv_events_number, R.id.tv_follow, R.id.tv_station);

        showPlaceholders();
    }

    private void initView() {
        findViewById(R.id.iv_retry).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setPivotX(v.getWidth() / 2);
                v.setPivotY(v.getHeight() / 2);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.animate()
                            .scaleX(1.3f)
                            .scaleY(1.3f)
                            .setInterpolator(new BounceInterpolator())
                            .setDuration(300)
                            .start();
                } else if (event.getAction() == MotionEvent.ACTION_CANCEL
                        || event.getAction() == MotionEvent.ACTION_UP) {
                    v.animate()
                            .scaleX(1)
                            .scaleY(1)
                            .setInterpolator(new BounceInterpolator())
                            .setDuration(300)
                            .start();
                }
                return false;
            }
        });
    }

    public void onRetry(View view) {
        showPlaceholders();
    }

    private void showPlaceholders() {
        if (mBroccoli != null) {
            mBroccoli.show();
            mHandler.removeCallbacks(task);
            mHandler.postDelayed(task, 2000);
        }

    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            showData();
        }
    };

    private void showData() {
        mBroccoli.clearAllPlaceholders();
    }
}
