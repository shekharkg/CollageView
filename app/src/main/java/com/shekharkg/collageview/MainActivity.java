package com.shekharkg.collageview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.shekharkg.collageview.toucher.MultiTouchListener;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final int SELECT_IMG_1 = 10001;
  private static final int SELECT_IMG_2 = 10002;
  private static final int SELECT_IMG_3 = 10003;
  private static final int SELECT_IMG_4 = 10004;
  private static final int SELECT_FROM_GALLERY = 10005;
  private static final int SELECT_FROM_CAMERA = 10006;

  private ImageView imageView1;
  private ImageView imageView2;
  private ImageView imageView3;
  private ImageView imageView4;

  private int selectedImageView;

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

  private void showPickerDialog(final int selectedImageView) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Select Image...");

    builder.setPositiveButton("Gallery",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, SELECT_FROM_GALLERY);
            MainActivity.this.selectedImageView = selectedImageView;
          }
        }
    );

    builder.setNegativeButton("Camera",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, SELECT_FROM_CAMERA);
            MainActivity.this.selectedImageView = selectedImageView;
          }
        }
    );

    builder.show();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
    if (resultCode != RESULT_OK)
      return;

    boolean isFromCamera = false;
    if (requestCode == SELECT_FROM_CAMERA) {
      isFromCamera = true;
    }

    switch (selectedImageView) {
      case SELECT_IMG_1:
        if (isFromCamera) {
          Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
          imageView1.setImageBitmap(photo);
        } else
          Picasso.with(MainActivity.this).load(imageReturnedIntent.getData())
              .placeholder(R.drawable.loading_spinner).into(imageView1);
        imageView1.setOnTouchListener(new MultiTouchListener());
        break;
      case SELECT_IMG_2:
        if (isFromCamera) {
          Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
          imageView2.setImageBitmap(photo);
        } else
          Picasso.with(MainActivity.this).load(imageReturnedIntent.getData())
              .placeholder(R.drawable.loading_spinner).into(imageView2);
        imageView2.setOnTouchListener(new MultiTouchListener());
        break;
      case SELECT_IMG_3:
        if (isFromCamera) {
          Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
          imageView3.setImageBitmap(photo);
        } else
          Picasso.with(MainActivity.this).load(imageReturnedIntent.getData())
              .placeholder(R.drawable.loading_spinner).into(imageView3);
        imageView3.setOnTouchListener(new MultiTouchListener());
        break;
      case SELECT_IMG_4:
        if (isFromCamera) {
          Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
          imageView4.setImageBitmap(photo);
        } else
          Picasso.with(MainActivity.this).load(imageReturnedIntent.getData())
              .placeholder(R.drawable.loading_spinner).into(imageView4);
        imageView4.setOnTouchListener(new MultiTouchListener());
        break;
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.action_share) {
      View v1 = findViewById(R.id.parentLayout);
      v1.setDrawingCacheEnabled(true);
      Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
      v1.setDrawingCacheEnabled(false);
      imageView1.setImageBitmap(bitmap);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
