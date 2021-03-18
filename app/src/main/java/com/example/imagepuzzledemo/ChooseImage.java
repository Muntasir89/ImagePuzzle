package com.example.imagepuzzledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseImage extends AppCompatActivity {
    MainActivity mainActivity = new MainActivity();
    RecyclerView recyclerView;
    int[] img_actor = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14};
    private Toolbar toolbar; ImageView backpress; MenuInflater inflater;
    //public static int img_no = 0;
    Point ptSize = new Point();
    TextView Select;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);

        //Toolbar
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        //Select Image text
        Select = new TextView(this);
        Select.setText("Select Image");
        Select.setGravity(Gravity.CENTER);
        Select.setTextColor(0);
        toolbar.addView(Select);
        //Background animation
        RelativeLayout relativeLayout = findViewById(R.id.choose_img);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        getWindowManager().getDefaultDisplay().getSize(ptSize);
        //RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        MyAdapter adapter = new MyAdapter(this, img_actor, ptSize.x*27/48);
        recyclerView.setAdapter(adapter);
        //Initialize Image
        backpress = findViewById(R.id.backpress);
        //Go to Previous activity
        backpress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}