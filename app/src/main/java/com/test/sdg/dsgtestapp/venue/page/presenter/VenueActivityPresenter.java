package com.test.sdg.dsgtestapp.venue.page.presenter;

import android.util.Log;

import com.test.sdg.dsgtestapp.first.page.model.Contact;
import com.test.sdg.dsgtestapp.first.page.model.Venue;
import com.test.sdg.dsgtestapp.venue.page.model.VenueActivityModel;
import com.test.sdg.dsgtestapp.venue.page.view.IVenueActivity;
import com.test.sdg.dsgtestapp.venue.page.view.VenueActivity;

import java.util.List;


/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class VenueActivityPresenter {

    private static final String TAG = "VenueActivityPresenter";

    private VenueActivityModel model;

    private IVenueActivity view;

    public VenueActivityPresenter(VenueActivityModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }

    public void setView(VenueActivity view) {
        this.view = view;
    }

    public void setVenueData(Venue venue) {
        model.setVenue(venue);
    }

    public void setPhoto(String photoUrl) {
        Log.d(TAG, "setPhoto: " + photoUrl);
        view.setPhoto(photoUrl);
    }

    public void setStoreName(String storeName) {
        view.storeName(storeName);
    }

    public void setRatingBar(float storeName) {
        view.setRatingBar(storeName);
    }

    public void setRatingBarColor(String ratingColor) {
        view.setRatingBarColor(ratingColor);
    }

    public void setURL(String url) {
        view.setURL(url);
    }

    public void setAddress(String address) {
        view.setAddress(address);
    }

    public void setContactDetails(List<Contact> contactList) {
        view.setContactDetails(contactList);
    }
}

