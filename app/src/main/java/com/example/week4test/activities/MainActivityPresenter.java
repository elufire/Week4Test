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

    public void getPhotos(String query){
        OkHttpHelper.ascyncOkHttpApi("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=e0704084a765455afa2c7af759082590&tags=" +
                query + "&format=json&nojsoncallback=1");

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void flickerEvent(FlickrEvent flickrEvent){
        Flickr flick = flickrEvent.getFlickr();
        mainActivityContract.returnPhoto(flick);
    }
}
