package com.test.sdg.dsgtestapp.dsg.app.network.calls;

import android.os.AsyncTask;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class GetData extends AsyncTask<Void, Void, String> {

    private String url;
    final private IMainActivityModel.VenueCollection venueCollection;


    public GetData(String url, IMainActivityModel.VenueCollection venueCollection) {
        this.url = url;
        this.venueCollection = venueCollection;
    }

    @Override
    protected String doInBackground(Void... voids) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(this.url).build();
        String resultantResponse = null;
        try {
            resultantResponse = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultantResponse;
    }

    @Override
    protected void onPostExecute(String resultantResponse) {
        super.onPostExecute(resultantResponse);
        this.venueCollection.getVenueCollection(resultantResponse);
    }
}
