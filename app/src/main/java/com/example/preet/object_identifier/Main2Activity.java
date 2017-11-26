package com.example.preet.object_identifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity ma = new MainActivity();
        ImageView im2v = (ImageView)findViewById(R.id.imageView);
        im2v.setImageBitmap(ma.bitmap);
    }
}
