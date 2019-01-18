package com.mark.broccoli.ui.exemple;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mark.broccoli.R;
import com.mark.broccoli.utils.DrawableUtils;

import me.samlss.broccoli.Broccoli;
import me.samlss.broccoli.PlaceholderParameter;

public class DingDingSampleActivity extends AppCompatActivity {
    private Broccoli mBroccoli;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_ding_sample);
        initPlaceholders();
    }
    private void initPlaceholders(){
        int placeholderColor = Color.parseColor("#DDDDDD");

        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.iv_head))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_name))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_description))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_day_des))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_shangban))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_xiaban))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_timeline))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_shangban))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_xiaban))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_daka))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_daka_des))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build()

        );

        showPlaceholders();
    }

    private void showPlaceholders(){
        mBroccoli.show();
        mHandler.removeCallbacks(task);
        mHandler.postDelayed(task,2000);
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            mBroccoli.removeAllPlaceholders();
        }
    };
}
