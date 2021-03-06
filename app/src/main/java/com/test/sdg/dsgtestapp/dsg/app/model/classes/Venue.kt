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

package com.test.sdg.dsgtestapp.dsg.app.model.classes

typealias AndroidLocation = android.location.Location

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 *
 * Model class that represents Venue json object in REST API
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
                 var isFavorite: Boolean) : Comparable<Venue> {

    companion object {
        var favoriteVenueId = ""
        var hasFavorite = false
    }

    override fun compareTo(otherVenue: Venue): Int {

        val usersLastKnownLocation = AndroidLocation("User Last Know Location")
        usersLastKnownLocation.latitude = Location.current_latitude
        usersLastKnownLocation.longitude = Location.current_longitude

        val thisObjectLocation = AndroidLocation("thisObjectLocation")
        if (location != null) {
            thisObjectLocation.latitude = location.latitude
            thisObjectLocation.longitude = location.longitude
        } else {
            thisObjectLocation.latitude = Double.MAX_VALUE
            thisObjectLocation.longitude = Double.MAX_VALUE
        }

        val otherObjectLocation = AndroidLocation("otherLocation")
        if (otherVenue.location != null) {
            otherObjectLocation.latitude = otherVenue.location.latitude
            otherObjectLocation.longitude = otherVenue.location.longitude
        } else {
            otherObjectLocation.latitude = Double.MAX_VALUE
            otherObjectLocation.longitude = Double.MAX_VALUE
        }

        val distanceFromThisLocation = usersLastKnownLocation.distanceTo(thisObjectLocation)
        val distanceFromOtherLocation = usersLastKnownLocation.distanceTo(otherObjectLocation)

        if (distanceFromThisLocation > distanceFromOtherLocation) {
            return 1
        }  else if(distanceFromThisLocation < distanceFromOtherLocation){
            return -1
        }
        return 0
    }
}