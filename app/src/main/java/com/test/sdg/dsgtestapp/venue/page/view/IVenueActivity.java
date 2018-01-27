package com.test.sdg.dsgtestapp.venue.page.view;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Contact;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 */

public interface IVenueActivity {

    void setPhoto(String storeName);

    void storeName(String photoURL);

    void setRatingBar(float ratingValue);

    void setURL(String url);

    void setAddress(String address);

    void setContactDetails(List<Contact> contactList);

    void setRatingBarColor(String ratingColor);
}
