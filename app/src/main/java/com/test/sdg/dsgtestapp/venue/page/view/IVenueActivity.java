package com.test.sdg.dsgtestapp.venue.page.view;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 */

public interface IVenueActivity {

    void setPhoto(String storeName);

    void storeName(String photoURL);

    void setRatingBar(float ratingValue);

    void setURL(String url);

    void setAddress(String address);

    void setContactDetails(String contactDetails);

    void setRatingBarColor(String ratingColor);
}
