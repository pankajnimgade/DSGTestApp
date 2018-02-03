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

import android.util.Log;

import com.google.gson.Gson;
import com.test.sdg.dsgtestapp.dsg.app.StartUp;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Response;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.dsg.app.network.calls.GetData;
import com.test.sdg.dsgtestapp.dsg.app.preferences.DataPreference;
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;

import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 * <p>
 * This class provides the implementation of {@link IMainActivityModel} and
 * {@link IMainActivityModel.VenueCollection}
 */

public class MainActivityModel implements IMainActivityModel, IMainActivityModel.VenueCollection {

    private static final String TAG = "MainActivityModel";

    private MainActivityPresenter presenter;

    private DataPreference preference;
    private List<Venue> venueList;

    public MainActivityModel() {
        preference = StartUp.getPreference();
    }

    public void setPresenter(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void callVenueCollection(String url) {
        GetData getData = new GetData(url, this);
        getData.execute();
    }

    @Override
    public void getVenueCollection(String responseText) {
        Log.d(TAG, "getVenueCollection: \n" + responseText);
        if (responseText != null && !responseText.isEmpty()) {
            venueList = (new Gson().fromJson(responseText, Response.class)).getVenues();
            presenter.setVenueCollection(venueList);
            sortList();
        }else{
            presenter.errorOccurred("Error# API Response");
        }
        System.out.println(venueList);
    }

    @Override
    public void setFavoriteVenue(Venue favoriteVenue) {
        preference.saveVenueId(favoriteVenue.getId());
        Venue.Companion.setFavoriteVenueId(favoriteVenue.getId());
        Venue.Companion.setHasFavorite(true);
        sortList();
    }

    @Override
    public void removeFavoriteVenue(Venue removeFavoriteVenue) {
        if (removeFavoriteVenue.getId().equals(Venue.Companion.getFavoriteVenueId())) {
            Venue.Companion.setHasFavorite(false);
            Venue.Companion.setFavoriteVenueId("");
        }
        sortList();
    }

    @Override
    public String getFavoriteVenueID() {
        return preference.getVenueID();
    }

    @Override
    public void sortList() {
        Collections.sort(venueList);
        if (Venue.Companion.getHasFavorite()) {
            int favoriteVenueIndex = 0;
            for (int index = 0; index < venueList.size(); index++) {
                if (venueList.get(index).getId().equals(Venue.Companion.getFavoriteVenueId())) {
                    favoriteVenueIndex = index;
                    break;
                }
            }
            if (favoriteVenueIndex != 0) {
                Venue favoriteVenue = venueList.remove(favoriteVenueIndex);
                venueList.add(0, favoriteVenue);
            }
        }

        presenter.notifyListChange();
    }
}
