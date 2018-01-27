package com.test.sdg.dsgtestapp.first.page.presenter;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.first.page.view.MainActivity;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class MainActivityPresenter {

    private IMainActivityModel model;

    private MainActivity view;

    public MainActivityPresenter(IMainActivityModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }

    public void setView(MainActivity view) {
        this.view = view;
    }

    public void requestData(String url) {
        this.model.callVenueCollection(url);
    }

    public void setVenueCollection(List<Venue> venueList) {
        System.out.println(venueList);
        this.view.loadInformation(venueList);
    }


    public void saveFavoriteStoreID(String favoriteVenueID) {
        model.setFavoriteVenueID(favoriteVenueID);
    }

    public String getVenueID() {
        return model.getFavoriteVenueID();
    }
}
