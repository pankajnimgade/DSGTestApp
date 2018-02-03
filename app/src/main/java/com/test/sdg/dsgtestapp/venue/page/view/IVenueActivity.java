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
