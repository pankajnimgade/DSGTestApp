package com.test.sdg.dsgtestapp.dsg.app;

import android.app.Application;
import android.util.Log;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Location;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.dsg.app.preferences.DataPreference;
import com.test.sdg.dsgtestapp.first.page.dagger.DaggerMainActivityComponent;
import com.test.sdg.dsgtestapp.first.page.dagger.MainActivityComponent;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 * Application level class used to keep reference to {@link DataPreference} and to Use {@linkplain Dagger}
 */
public class StartUp extends Application {

    private static final String TAG = StartUp.class.getSimpleName();

    private static DataPreference preference;

    private MainActivityComponent mainActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainActivityComponent = DaggerMainActivityComponent.create();

        preference = new DataPreference(getApplicationContext());
        initializeFavoriteVenue();
        initializeLastKnownLocation();
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }

    /**
     * Initializes favorite venue from shared preference if it exits
     */
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

    /**
     * Initializes last Known {@link Location} from shared preference if it exits
     */
    private static void initializeLastKnownLocation() {
        Location location = preference.retriveLastKnownLocation();
        Log.d(TAG, "initializeLastKnownLocation: "+location.getLatitude()+" "+location.getLongitude());
        Location.Companion.setCurrent_latitude(location.getLatitude());
        Location.Companion.setCurrent_longitude(location.getLongitude());
    }

    /**
     * Saves the last known {@link Location} to the shared preferences
     * @param location current last known location
     */
    public static void setLocation(Location location) {
        preference.saveCurrentLocation(location);
        initializeLastKnownLocation();
    }
}
