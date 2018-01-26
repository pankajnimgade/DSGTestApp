package com.test.sdg.dsgtestapp.model;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public interface IMainActivityModel {

    void callVenueCollection(String url);

    interface VenueCollection {

        void getVenueCollection(String responseText);

    }
}


