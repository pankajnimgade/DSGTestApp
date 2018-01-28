package com.test.sdg.dsgtestapp.venue.page.view;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Contact;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 *
 * Implementation of this class represents Venue View
 * with implementation of following mentioned methods
 */
public interface IVenueActivity {

    /**
     * @param photoURL url who's response is image of the respective Store
     */
    void setPhoto(String photoURL);

    /**
     * @param storeName name of the store
     */
    void storeName(String storeName);

    /**
     * @param ratingValue representing value of RatingBar
     */
    void setRatingBar(float ratingValue);

    /**
     * @param url
     */
    void setURL(String url);

    /**
     * @param address address of the Store
     */
    void setAddress(String address);

    /**
     * @param contactList contact list for the Store
     */
    void setContactDetails(List<Contact> contactList);

    /**
     * @param ratingColor color associated with Rating of the Store
     */
    void setRatingBarColor(String ratingColor);
}
