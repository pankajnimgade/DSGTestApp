package com.test.sdg.dsgtestapp.dsg.app.model.classes

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */
data class Venue(val id: String,
                 val name: String,
                 val canonicalUrl: String,
                 val verified: String,
                 val url: String,
                 val ratingColor: String,
                 val ratingSignals: String,
                 val rating: Float,
                 val description: String,
                 val storeId: String,
                 val shortUrl: String,
                 val timeZone: String,
                 val location: Location,
                 val contacts: List<Contact>,
                 val photos: List<Photo>,
                 var isFavorite: Boolean
) {
    companion object {
        var favoriteVenueId = ""
        var hasFavorite = false
    }
}