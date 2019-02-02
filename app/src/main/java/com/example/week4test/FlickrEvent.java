package com.example.week4test;

import com.example.week4test.flickr.Flickr;

public class FlickrEvent {
    Flickr flickr;

    public FlickrEvent(Flickr flickr) {
        this.flickr = flickr;
    }

    public Flickr getFlickr() {
        return flickr;
    }

    public void setFlickr(Flickr flickr) {
        this.flickr = flickr;
    }
}
