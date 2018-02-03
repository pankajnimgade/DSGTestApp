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

package com.test.sdg.dsgtestapp.first.page.presenter;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.first.page.view.MainActivity;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 *
 * This class acts as adapter interface between View and Model,
 * can be called as Presenter or Controller
 */

public class MainActivityPresenter {

    private IMainActivityModel model;

    private MainActivity view;

    public MainActivityPresenter(IMainActivityModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }

    /**
     * @param view {@link MainActivity} View with which this presenter will communicate with model
     */
    public void setView(MainActivity view) {
        this.view = view;
    }

    /**
     * Requests for the REST API response
     * @param url to be called
     */
    public void requestData(String url) {
        this.model.callVenueCollection(url);
    }

    /**
     * provides the venue list to the View
     * @param venueList list of Venue
     */
    public void setVenueCollection(List<Venue> venueList) {
        System.out.println(venueList);
        this.view.loadInformation(venueList);
    }


    /**
     * @param favoriteVenue
     */
    public void saveFavoriteVenue(Venue favoriteVenue) {
        model.setFavoriteVenue(favoriteVenue);
    }

    /**
     * @param removeFavoriteVenue
     */
    public void removeFavoriteVenue(Venue removeFavoriteVenue) {
        model.removeFavoriteVenue(removeFavoriteVenue);
    }

    /**
     * notifies data set change after the sorting the list and favorite correction
     */
    public void notifyListChange() {
        view.notifyListChange();
    }

    /**
     * propagates error message to the from Model to UI
     */
    public void errorOccurred(String errorMessage) {
        view.showError(errorMessage);
    }
}
