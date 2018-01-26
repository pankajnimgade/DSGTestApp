package com.test.sdg.dsgtestapp.dsg.app;

import android.app.Application;

import com.test.sdg.dsgtestapp.dsg.app.preferences.FavoriteVenuePreference;
import com.test.sdg.dsgtestapp.first.page.model.Venue;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 */

public class StartUp extends Application {

    private static FavoriteVenuePreference preference;

    @Override
    public void onCreate() {
        super.onCreate();
        preference = new FavoriteVenuePreference(getApplicationContext());
        initializeFavoriteVenue();
    }

    private void initializeFavoriteVenue() {
        String venueID = preference.getVenueID();
        if (venueID != null && !venueID.isEmpty()) {
            Venue.Companion.setFavoriteVenueId(venueID);
            Venue.Companion.setHasFavorite(true);
        }
    }

    public static FavoriteVenuePreference getPreference() {
        return preference;
    }
}
