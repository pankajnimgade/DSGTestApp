package com.test.sdg.dsgtestapp.first.page.model;

import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue;
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;
import com.test.sdg.dsgtestapp.first.page.view.MainActivity;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 * <p>
 * Implementation of this class provides concrete logic to be used in {@link MainActivity}
 */

public interface IMainActivityModel {

    /**
     * Used to call the REST API response
     * @param url
     */
    void callVenueCollection(String url);

    /**
     * @param presenter the presenter to be associated with this model
     */
    void setPresenter(MainActivityPresenter presenter);

    /**
     * to save (set) Venue to shared preference
     * @param favoriteVenue venue instance to be saved
     */
    void setFavoriteVenue(Venue favoriteVenue);

    /**
     * Used to remove favorite venue as it is invalid now
     * @param removeFavoriteVenue venue instance to be removed
     */
    void removeFavoriteVenue(Venue removeFavoriteVenue);

    /**
     * @return get id for favorite venue
     */
    String getFavoriteVenueID();

    /**
     * Used to sort the Venue List with respect to the favorite venue and ascending order
     * in distance from current location
     */
    void sortList();

    /**
     * Its implementation class would receive the REST API response
     */
    interface VenueCollection {

        /**
         * @param responseText  REST API response
         */
        void getVenueCollection(String responseText);

    }
}


