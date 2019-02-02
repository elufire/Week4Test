package com.example.week4test.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4test.R;
import com.example.week4test.flickr.Photo;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView tvTitle;
    TextView tvOwner;
    TextView tvId;
    TextView tvServer;
    TextView tvFarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.ivImage);
        tvTitle = findViewById(R.id.tvDetailTitle);
        tvOwner = findViewById(R.id.tvDetailOwner);
        tvId = findViewById(R.id.tvId);
        tvServer = findViewById(R.id.tvServer);
        tvFarm = findViewById(R.id.tvFarm);

        Intent intent = getIntent();
        Photo photo = intent.getParcelableExtra("photo_id");
        Glide.with(this).load("https://farm" + photo.getFarm()
                + ".staticflickr.com/" + photo.getServer() + "/" + photo.getId() +
                "_" + photo.getSecret() + ".jpg").into(imageView);

        tvTitle.setText("Title: " + photo.getTitle());
        tvOwner.setText("Owner: " + photo.getOwner());
        tvId.setText("Id: " + photo.getId());
        tvServer.setText("Server: " + photo.getServer());
        tvFarm.setText("Farm: " + String.valueOf(photo.getFarm()));

    }
}
