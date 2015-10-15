package com.shekharkg.collageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.shekharkg.collageview.toucher.MultiTouchListener;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView imageView1 = (ImageView) findViewById(R.id.collageView1);
    ImageView imageView2 = (ImageView) findViewById(R.id.collageView2);
    ImageView imageView3 = (ImageView) findViewById(R.id.collageView3);
    ImageView imageView4 = (ImageView) findViewById(R.id.collageView4);

    imageView2.setOnTouchListener(new MultiTouchListener());
    imageView1.setOnTouchListener(new MultiTouchListener());
    imageView3.setOnTouchListener(new MultiTouchListener());
    imageView4.setOnTouchListener(new MultiTouchListener());

  }

}
