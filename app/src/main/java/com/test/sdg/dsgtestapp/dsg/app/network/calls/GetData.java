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

package com.test.sdg.dsgtestapp.dsg.app.network.calls;

import android.os.AsyncTask;
import android.util.Log;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 * <p>
 * This is Network call class to get Rest API response
 */

public class GetData extends AsyncTask<Void, Void, String> {

    private static final String TAG = GetData.class.getSimpleName();
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
            Log.e(TAG, "doInBackground: " + e.getMessage());
        }
        return resultantResponse;
    }

    @Override
    protected void onPostExecute(String resultantResponse) {
        super.onPostExecute(resultantResponse);
        this.venueCollection.getVenueCollection(resultantResponse);
    }
}
