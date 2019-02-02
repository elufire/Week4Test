package com.example.week4test.activities;

import com.example.week4test.FlickrEvent;
import com.example.week4test.OkHttpHelper;
import com.example.week4test.activities.MainActivityContract;
import com.example.week4test.flickr.Flickr;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivityPresenter {
    MainActivityContract mainActivityContract;

    public MainActivityPresenter(MainActivityContract mainActivityContract) {
        this.mainActivityContract = mainActivityContract;
        EventBus.getDefault().register(this);
    }

    public void getPhotos(){
        OkHttpHelper.ascyncOkHttpApi("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=b70cc739c3f5aa69c88286cd25f27977&per_page=10&page=1&format=json&nojsoncallback=1&api_sig=4cdfe40e6c47ba1ddec95d4ce2687388");

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void flickerEvent(FlickrEvent flickrEvent){
        Flickr flick = flickrEvent.getFlickr();
        mainActivityContract.returnPhoto(flick);
    }
}
