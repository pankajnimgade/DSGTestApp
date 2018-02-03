/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.test.sdg.dsgtestapp.venue.page.presenter;

import android.util.Log;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Contact;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
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

