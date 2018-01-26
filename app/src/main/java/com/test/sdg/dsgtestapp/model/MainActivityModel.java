package com.test.sdg.dsgtestapp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.test.sdg.dsgtestapp.network.calls.GetData;
import com.test.sdg.dsgtestapp.presenter.MainActivityPresenter;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class MainActivityModel implements IMainActivityModel, IMainActivityModel.VenueCollection {

    private static final String TAG = "MainActivityModel";

    private MainActivityPresenter presenter;


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
        ArrayList<Venue> venues = (new Gson().fromJson(responseText, Response.class)).getVenues();
        presenter.setVenueCollection(venues);
        System.out.println(venues);
    }
}
