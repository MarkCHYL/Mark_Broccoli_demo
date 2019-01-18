package com.mark.broccoli.ui.exemple;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mark.broccoli.R;
import com.mark.broccoli.utils.PlaceholderHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.samlss.broccoli.Broccoli;

public class LayoutAdvancedSampleActivity extends AppCompatActivity {

    @BindView(R.id.iv_head_photo)
    ImageView ivHeadPhoto;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_view_time)
    TextView tvViewTime;
    @BindView(R.id.tv_collect_time)
    TextView tvCollectTime;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_clock)
    ImageView ivClock;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_calendar)
    ImageView ivCalendar;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.iv_arrow_right)
    ImageView ivArrowRight;
    @BindView(R.id.layout_details)
    LinearLayout layoutDetails;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_organizer_name)
    TextView tvOrganizerName;
    @BindView(R.id.tv_organizer_description)
    TextView tvOrganizerDescription;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.tv_fans_number)
    TextView tvFansNumber;
    @BindView(R.id.tv_events)
    TextView tvEvents;
    @BindView(R.id.tv_events_number)
    TextView tvEventsNumber;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.tv_station)
    TextView tvStation;
    @BindView(R.id.iv_retry)
    ImageView ivRetry;
    @BindView(R.id.root)
    RelativeLayout root;

    private Broccoli mBroccoli;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#847465"));
        }
        setContentView(R.layout.activity_simple_layout);
        ButterKnife.bind(this);

        initViews();
        initPlaceholders();
    }

    /**
     *
     */
    private void initPlaceholders() {
        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(PlaceholderHelper.getParameter(tvViewTime),
                PlaceholderHelper.getParameter(tvCollectTime),
                PlaceholderHelper.getParameter(tvPrice),
                PlaceholderHelper.getParameter(ivClock),
                PlaceholderHelper.getParameter(tvTime),
                PlaceholderHelper.getParameter(ivCalendar),
                PlaceholderHelper.getParameter(ivLocation),
                PlaceholderHelper.getParameter(tvLocation),
                PlaceholderHelper.getParameter(ivLogo),
                PlaceholderHelper.getParameter(tvOrganizerName),
                PlaceholderHelper.getParameter(tvFans),
                PlaceholderHelper.getParameter(tvFansNumber),
                PlaceholderHelper.getParameter(tvEvents),
                PlaceholderHelper.getParameter(tvEventsNumber),
                PlaceholderHelper.getParameter(tvFollow),
                PlaceholderHelper.getParameter(tvStation),
                PlaceholderHelper.getParameter(tvOrganizerDescription),
                PlaceholderHelper.getParameter(ivArrowRight),
                PlaceholderHelper.getParameter(tvTitle)
        );

        showPlaceholders();
    }

    private void initViews() {
        ivRetry.setOnTouchListener(new View.OnTouchListener() {
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

    private void showPlaceholders() {
        if (mBroccoli != null) {
            mBroccoli.show();

            mHandler.removeCallbacks(task);
            mHandler.postDelayed(task, 3000);
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

    public void onRetry(View view) {
        showPlaceholders();
    }
}
