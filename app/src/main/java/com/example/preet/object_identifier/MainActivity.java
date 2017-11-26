package com.example.preet.object_identifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

import static com.example.preet.object_identifier.R.id.imageView2;

public class MainActivity extends AppCompatActivity {


    private int PICK_IMAGE_REQUEST=1;

   public Bitmap bitmap;// = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ImageButton imb = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton imb1 = (ImageButton)findViewById(R.id.imageButton4);

        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        imb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();

            }
        });


        //finish();
    }

    public void openGallery()
    {

        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       ImageView imageView = (ImageView) findViewById(imageView2);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
               bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

               // ImageView imageView = (ImageView) findViewById(imageView2);
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
        Intent i = new Intent(this,Main2Activity.class);

        startActivity(i);

    }
    public void openCamera()
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent,0);

    }



}
