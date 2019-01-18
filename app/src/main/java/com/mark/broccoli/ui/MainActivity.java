package com.mark.broccoli.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mark.broccoli.R;
import com.mark.broccoli.ui.exemple.DingDingSampleActivity;
import com.mark.broccoli.ui.exemple.LayoutAdvancedSampleActivity;
import com.mark.broccoli.ui.exemple.LayoutSimpleSampleActivity;
import com.mark.broccoli.ui.exemple.RecyclerViewSampleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }

    public void startLayoutSample(View view) {
        startActivity(new Intent(this,LayoutSimpleSampleActivity.class));
    }

    public void startAdvancedLayoutSample(View view) {
        startActivity(new Intent(this,LayoutAdvancedSampleActivity.class));
    }

    public void startRecyclerViewSample(View view) {
        startActivity(new Intent(this,RecyclerViewSampleActivity.class));
    }

    public void startDingDingSample(View view) {
        startActivity(new Intent(this,DingDingSampleActivity.class));
    }
}
