package com.monis.scrollviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShowActivity extends AppCompatActivity {
    private HorizontalScrollView scrollView;
    private LinearLayout linearLayout;
    private HorizontalScrollView scrollView2;
    private LinearLayout linearLayout2;
    private HorizontalScrollView scrollView3;
    private LinearLayout linearLayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        findViews();
        showCollect();
        showCollect2();
        showCollect3();
    }

    private void findViews() {
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout);
        scrollView2 = findViewById(R.id.scrollView2);
        linearLayout2 = findViewById(R.id.linearLayout2);
        scrollView3 = findViewById(R.id.scrollView3);
        linearLayout3 = findViewById(R.id.linearLayout3);
    }

    public void showCollect() {
        int[][] images = new int[][]{{R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home}};
        for (int[] image : images) {
            for(int ima : image) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(ima);
                linearLayout.addView(imageView, 300, 300);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        }
    }

    public void showCollect2() {
        int[][] images2 = new int[][]{{R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home}};
        for (int[] image2 : images2) {
            for(int ima2 : image2) {
                ImageView imageView2 = new ImageView(this);
                imageView2.setImageResource(ima2);
                linearLayout2.addView(imageView2, 400, 400);
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        }
    }

    public void showCollect3() {
        int[][] images3 = new int[][]{{R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home},
                {R.drawable.lake,R.drawable.home,R.drawable.home}};
        for (int[] image3 : images3) {
            for(int ima3 : image3) {
                ImageView imageView2 = new ImageView(this);
                imageView2.setImageResource(ima3);
                linearLayout3.addView(imageView2, 500, 500);
                scrollView3.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        }
    }
}
