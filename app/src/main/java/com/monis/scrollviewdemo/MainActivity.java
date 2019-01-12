package com.monis.scrollviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private HorizontalScrollView scrollView;
    private HorizontalScrollView scrollView1;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout1;
    private ImageView tvImage;
    private ImageView tvImage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViews();
    }

    private void findViews() {
        tvImage = findViewById(R.id.tvImage);
        tvImage1 = findViewById(R.id.tvImage1);
        scrollView = findViewById(R.id.scrollView);
        scrollView1 = findViewById(R.id.scrollView1);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout1 = findViewById(R.id.linearLayout1);
    }

    public void onAddClick(View view) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.home);
        linearLayout.addView(imageView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    public void onAddClick1(View view) {
        int[] images = {R.drawable.home, R.drawable.lake, R.drawable.home, R.drawable.lake,
                             R.drawable.home, R.drawable.lake, R.drawable.home, R.drawable.lake};
        for (int image : images) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image);
            linearLayout1.addView(imageView, 300, 300);
            scrollView1.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
