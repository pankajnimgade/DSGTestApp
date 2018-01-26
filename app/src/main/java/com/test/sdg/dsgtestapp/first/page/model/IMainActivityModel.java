package com.test.sdg.dsgtestapp.first.page.model;

import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public interface IMainActivityModel {

    void callVenueCollection(String url);

    void setPresenter(MainActivityPresenter presenter);

    void setFavoriteVenueID(String favoriteVenueID);

    String getFavoriteVenueID();

    interface VenueCollection {

        void getVenueCollection(String responseText);

    }
}


