package com.shekharkg.collageview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final int SELECT_IMG_1 = 10001;
  private static final int SELECT_IMG_2 = 10002;
  private static final int SELECT_IMG_3 = 10003;
  private static final int SELECT_IMG_4 = 10004;

  private ImageView imageView1;
  private ImageView imageView2;
  private ImageView imageView3;
  private ImageView imageView4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView1 = (ImageView) findViewById(R.id.collageView1);
    imageView2 = (ImageView) findViewById(R.id.collageView2);
    imageView3 = (ImageView) findViewById(R.id.collageView3);
    imageView4 = (ImageView) findViewById(R.id.collageView4);

    imageView1.setOnClickListener(this);
    imageView2.setOnClickListener(this);
    imageView3.setOnClickListener(this);
    imageView4.setOnClickListener(this);

//    imageView2.setOnTouchListener(new MultiTouchListener());
//    imageView1.setOnTouchListener(new MultiTouchListener());
//    imageView3.setOnTouchListener(new MultiTouchListener());
//    imageView4.setOnTouchListener(new MultiTouchListener());

  }


  @Override
  public void onClick(View v) {
    if (v == imageView1)
      showPickerDialog(SELECT_IMG_1);
    else if (v == imageView2)
      showPickerDialog(SELECT_IMG_2);
    else if (v == imageView3)
      showPickerDialog(SELECT_IMG_3);
    else if (v == imageView4)
      showPickerDialog(SELECT_IMG_4);
  }

  private void showPickerDialog(int seletcImageFlag) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Select Image...");

    builder.setPositiveButton("Gallery",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {

          }
        }
    );

    builder.setNegativeButton("Camera",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {

          }
        }
    );

    builder.show();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
      switch (requestCode) {
        case SELECT_IMG_1:

          break;

        case SELECT_IMG_2:

          break;

        case SELECT_IMG_3:

          break;

        case SELECT_IMG_4:

          break;
      }
    }
  }
}
