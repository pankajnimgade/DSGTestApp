package com.test.sdg.dsgtestapp.first.page.model

import android.util.Log
import org.junit.Test

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */
class VenueTest{


    @Test
    fun testParsing(){
        // not in use,
        // once business logic is independent of android class, redo this
        val TAG = "TESTING"
        val venueList = mutableListOf<Venue>()
        for (single in venueList){
            Log.d(TAG, "id: ${single.id}")
            Log.d(TAG, "name: ${single.name}")
            Log.d(TAG, "canonicalUrl: ${single.canonicalUrl}")
            Log.d(TAG, "verified: ${single.verified}")
            Log.d(TAG, "url: ${single.url}")
            Log.d(TAG, "ratingColor: ${single.ratingColor}")
            Log.d(TAG, "ratingSignals: ${single.ratingSignals}")
            Log.d(TAG, "rating: ${single.rating}")
            Log.d(TAG, "description: ${single.description}")
            Log.d(TAG, "storeId: ${single.storeId}")
            Log.d(TAG, "shortUrl: ${single.shortUrl}")
            Log.d(TAG, "timeZone: ${single.timeZone}")
            Log.d(TAG, "location: ${single.location}")

            for (contact in single.contacts){
                Log.d(TAG, "facebook: ${contact.facebook}")
                Log.d(TAG, "facebookName: ${contact.facebookName}")
                Log.d(TAG, "phone: ${contact.phone}")
                Log.d(TAG, "twitter: ${contact.twitter}")

            }
        }
    }
}