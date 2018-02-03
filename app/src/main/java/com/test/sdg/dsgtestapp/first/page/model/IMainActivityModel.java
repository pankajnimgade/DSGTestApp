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

package com.test.sdg.dsgtestapp.first.page.model;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;
import com.test.sdg.dsgtestapp.first.page.view.MainActivity;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 * <p>
 * Implementation of this class provides concrete logic to be used in {@link MainActivity}
 */

public interface IMainActivityModel {

    /**
     * Used to call the REST API response
     * @param url
     */
    void callVenueCollection(String url);

    /**
     * @param presenter the presenter to be associated with this model
     */
    void setPresenter(MainActivityPresenter presenter);

    /**
     * to save (set) Venue to shared preference
     * @param favoriteVenue venue instance to be saved
     */
    void setFavoriteVenue(Venue favoriteVenue);

    /**
     * Used to remove favorite venue as it is invalid now
     * @param removeFavoriteVenue venue instance to be removed
     */
    void removeFavoriteVenue(Venue removeFavoriteVenue);

    /**
     * @return get id for favorite venue
     */
    String getFavoriteVenueID();

    /**
     * Used to sort the Venue List with respect to the favorite venue and ascending order
     * in distance from current location
     */
    void sortList();

    /**
     * Its implementation class would receive the REST API response
     */
    interface VenueCollection {

        /**
         * @param responseText  REST API response
         */
        void getVenueCollection(String responseText);

    }
}


