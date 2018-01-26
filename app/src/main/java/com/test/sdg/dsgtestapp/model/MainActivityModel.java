package com.test.sdg.dsgtestapp.model;

import android.util.Log;

import com.test.sdg.dsgtestapp.network.calls.GetData;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class MainActivityModel implements IMainActivityModel, IMainActivityModel.VenueCollection {

    private static final String TAG = "MainActivityModel";

    @Override
    public void callVenueCollection(String url) {
        GetData getData = new GetData(url, this);
        getData.execute();
    }

    @Override
    public void getVenueCollection(String responseText) {
        Log.d(TAG, "getVenueCollection: \n" + responseText);
    }
}
