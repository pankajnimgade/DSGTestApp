package com.test.sdg.dsgtestapp.venue.page.model;

import android.util.Log;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Location;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Photo;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.venue.page.presenter.VenueActivityPresenter;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class VenueActivityModel {

    private static final String TAG = "VenueActivityModel";
    private VenueActivityPresenter presenter;
    private Venue venue;

    public VenueActivityModel() {
    }

    public void setPresenter(VenueActivityPresenter presenter) {
        this.presenter = presenter;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;

        populateUI();
    }

    private void populateUI() {
        if (venue != null) {
            populatePhoto();
            populateStoreName();
            populateRatingValue();
            populateRatingColor();
            populateURL();
            populateAddress();
            populateContactDetails();
        }
    }

    private void populatePhoto() {
        List<Photo> photos = venue.getPhotos();
        if (photos != null && photos.size() > 0) {
            Photo firstPhoto = photos.get(0);
            if (firstPhoto != null &&
                    firstPhoto.getUrl() != null &&
                    !firstPhoto.getUrl().isEmpty()) {
                Log.d(TAG, "populatePhoto: " + firstPhoto.getUrl());
                if (presenter != null) {
                    presenter.setPhoto(firstPhoto.getUrl());
                }
            }
        }
    }

    private void populateStoreName() {
        if (venue.getName() != null &&
                !venue.getName().isEmpty()) {
            presenter.setStoreName(venue.getName());
        }
    }

    private void populateRatingValue() {
        if (venue.getRating() != 0) {
            presenter.setRatingBar(venue.getRating());
        }
    }

    private void populateRatingColor() {
        if (venue.getRatingColor() != null && !venue.getRatingColor().isEmpty()) {
            Log.d(TAG, "populateRatingColor: " + venue.getRatingColor());
            presenter.setRatingBarColor(venue.getRatingColor());
        }
    }

    private void populateURL() {
        if (venue.getUrl() != null && !venue.getUrl().isEmpty()) {
            presenter.setURL(venue.getUrl());
        }
    }

    private void populateAddress() {
        if (venue.getLocation() != null) {
            StringBuilder addressBuilder = new StringBuilder();
            Location location = venue.getLocation();
            addressBuilder.append((location.getAddress() == null) ? "" : location.getAddress() + "\n");
            addressBuilder.append((location.getPostalCode() == null) ? "" : location.getPostalCode() + "\n");
            addressBuilder.append((location.getCity() == null) ? "" : location.getCity() + "\n");
            addressBuilder.append((location.getState() == null) ? "" : location.getState() + "\n");
            addressBuilder.append((location.getCountry() == null) ? "" : location.getCountry() + "\n");
            String address = addressBuilder.toString();
            if (address != null && !address.isEmpty()) {
                presenter.setAddress(address);
            }
        }
    }

    private void populateContactDetails() {
        if (venue.getContacts() != null && venue.getContacts().size() > 0) {
            presenter.setContactDetails(venue.getContacts());
        }
    }


}
