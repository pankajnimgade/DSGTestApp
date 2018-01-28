package com.test.sdg.dsgtestapp.dsg.app;

import android.app.Application;
import android.util.Log;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Location;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.dsg.app.preferences.DataPreference;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 */

public class StartUp extends Application {

    private static final String TAG = StartUp.class.getSimpleName();

    private static DataPreference preference;

    @Override
    public void onCreate() {
        super.onCreate();
        preference = new DataPreference(getApplicationContext());
        initializeFavoriteVenue();
        initializeLastKnownLocation();
    }


    private void initializeFavoriteVenue() {
        String venueID = preference.getVenueID();
        if (venueID != null && !venueID.isEmpty()) {
            Venue.Companion.setFavoriteVenueId(venueID);
            Venue.Companion.setHasFavorite(true);
        }
    }

    public static DataPreference getPreference() {
        return preference;
    }

    private static void initializeLastKnownLocation() {
        Location location = preference.retriveLastKnownLocation();
        Log.d(TAG, "initializeLastKnownLocation: "+location.getLatitude()+" "+location.getLongitude());
        Location.Companion.setCurrent_latitude(location.getLatitude());
        Location.Companion.setCurrent_longitude(location.getLongitude());
    }

    public static void setLocation(Location location) {
        preference.saveCurrentLocation(location);
        initializeLastKnownLocation();
    }
}
