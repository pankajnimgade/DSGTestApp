package com.test.sdg.dsgtestapp.presenter;

import com.test.sdg.dsgtestapp.model.IMainActivityModel;
import com.test.sdg.dsgtestapp.model.Venue;
import com.test.sdg.dsgtestapp.view.MainActivity;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class MainActivityPresenter {

    private IMainActivityModel model;

    private MainActivity view;

    public MainActivityPresenter(IMainActivityModel model) {
        this.model = model;
    }

    public void requestData(String url) {
        this.model.callVenueCollection(url);
    }

    public void setVenueCollection(List<Venue> venueList) {
        System.out.println(venueList);
    }


}
