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

package com.test.sdg.dsgtestapp.first.page.model

import android.util.Log
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue
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