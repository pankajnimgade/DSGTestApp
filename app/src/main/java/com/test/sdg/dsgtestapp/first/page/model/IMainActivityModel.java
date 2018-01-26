package com.test.sdg.dsgtestapp.first.page.model;

import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public interface IMainActivityModel {

    void callVenueCollection(String url);

    void setPresenter(MainActivityPresenter presenter);

    interface VenueCollection {

        void getVenueCollection(String responseText);

    }
}

