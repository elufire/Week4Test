package com.example.week4test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week4test.R;
import com.example.week4test.adapters.RecyclerViewAdapter;
import com.example.week4test.flickr.Flickr;
import com.example.week4test.flickr.Photo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    MainActivityPresenter mainActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter= new MainActivityPresenter(this);
        mainActivityPresenter.getPhotos();
        recyclerView = findViewById(R.id.rvView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void returnPhoto(Flickr flickr) {
        ArrayList<Photo> photoArrayList = new ArrayList<>(flickr.getPhotos().getPhoto());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecyclerViewAdapter(photoArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


}
