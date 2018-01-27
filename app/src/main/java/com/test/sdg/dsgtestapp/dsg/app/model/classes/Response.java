package com.test.sdg.dsgtestapp.first.page.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class Response {

    @SerializedName("venues")
    ArrayList<Venue> venues;

    public ArrayList<Venue> getVenues() {
        return venues;
    }
}
