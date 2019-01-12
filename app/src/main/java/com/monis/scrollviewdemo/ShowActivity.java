package com.monis.scrollviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShowActivity extends AppCompatActivity {

    Context context;

    private HorizontalScrollView scrollView;
    private LinearLayout linearLayout;
    int[] images = {R.drawable.home, R.drawable.lake, R.drawable.home, R.drawable.lake,
            R.drawable.home, R.drawable.lake, R.drawable.home, R.drawable.lake};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        findViews();
        showCollect(images);

    }
    private void findViews() {
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout);
    }

    public void showCollect(int[] images) {

        for (int image : images) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image);
            linearLayout.addView(imageView, 400, 400);

            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }
}