package com.monis.scrollviewdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<MyCollection> myCollections;
//    private HorizontalScrollView scrollView;
//    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*   FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

//        startActivity(new Intent(this,ShowActivity.class));
        findViews();
        setCollections();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShowAdapter adapter = new ShowAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void findViews() {
//        scrollView = findViewById(R.id.scrollView);
//        linearLayout = findViewById(R.id.linearLayout);
    }

    private void setCollections() {
        myCollections = new ArrayList<>();
      /*  List<Integer> image1 = new ArrayList<>();
        image1.add(R.drawable.home);
        image1.add(R.drawable.home);
        image1.add(R.drawable.home);
        List<Integer> image2 = new ArrayList<>();
        image2.add(R.drawable.home);
        image2.add(R.drawable.home);
        List<Integer> image3 = new ArrayList<>();
        image3.add(R.drawable.home);
        image3.add(R.drawable.home);
        image3.add(R.drawable.home);
        List<Integer> image4 = new ArrayList<>();
        image4.add(R.drawable.home);
        image4.add(R.drawable.home);
        List<Integer> image5 = new ArrayList<>();
        image4.add(R.drawable.home);
        image4.add(R.drawable.home);
        List<Integer> image6 = new ArrayList<>();
        image6.add(R.drawable.home);
        image6.add(R.drawable.home);*/

        int[] image1 = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4,
                R.drawable.cat5, R.drawable.cat6, R.drawable.cat7, R.drawable.cat8};
        int[] image2 = {R.drawable.cat9, R.drawable.cat10, R.drawable.cat11, R.drawable.cat12,
                R.drawable.cat13, R.drawable.cat14, R.drawable.cat15, R.drawable.cat16};
        int[] image3 = {R.drawable.cat17, R.drawable.cat18, R.drawable.cat19, R.drawable.cat20,
                R.drawable.cat21, R.drawable.cat22, R.drawable.cat23, R.drawable.cat24};
        int[] image4 = {R.drawable.cat25, R.drawable.cat26, R.drawable.cat27, R.drawable.cat28,
                R.drawable.cat29, R.drawable.cat30, R.drawable.cat31, R.drawable.cat32};
        int[] image5 = {R.drawable.cat39, R.drawable.cat34, R.drawable.cat35, R.drawable.cat36,
                R.drawable.cat37, R.drawable.cat38, R.drawable.cat40, R.drawable.cat41};
        int[] image6 = {R.drawable.cat42, R.drawable.cat43, R.drawable.cat44};


        myCollections.add(new MyCollection(image1, "Collection1"));
        myCollections.add(new MyCollection(image2, "Collection2"));
        myCollections.add(new MyCollection(image3, "Collection3"));
        myCollections.add(new MyCollection(image4, "Collection4"));
        myCollections.add(new MyCollection(image5, "Collection5"));
        myCollections.add(new MyCollection(image6, "Collection6"));
    }

    public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowHolder> {
        @NonNull
        @Override
        public ShowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.activity_show, viewGroup, false);
            return new ShowHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ShowHolder showHolder, int i) {
            final MyCollection collection = myCollections.get(i);
            try {
                showHolder.text_Collection.setText(collection.getName());

                for (int image : collection.getImages()) {
                    ImageView imageView = new ImageView(MainActivity.this);

                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams.setMargins(0, 0, 10, 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setPadding(20,0,20,0);


                    imageView.setImageResource(image);
                    showHolder.linearLayout.addView(imageView, 500, 500);

                    showHolder.scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            showHolder.scrollView.fullScroll(View.FOCUS_FORWARD);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            showHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClicked(collection);
                }
            });
        }

        @Override
        public int getItemCount() {
            return myCollections.size();
        }

        public class ShowHolder extends RecyclerView.ViewHolder {

            LinearLayout linearLayout;
            HorizontalScrollView scrollView;
            TextView text_Collection;
            public ShowHolder(@NonNull View itemView) {
                super(itemView);
                text_Collection = itemView.findViewById(R.id.text_Collection);
                linearLayout = itemView.findViewById(R.id.linearLayout);
                scrollView = itemView.findViewById(R.id.scrollView);
            }
        }
    }

    private void itemClicked(MyCollection collection) {
        Toast.makeText(this, collection.getName(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "itemClicked: " + collection.getName());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}