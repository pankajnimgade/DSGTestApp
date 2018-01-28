package com.test.sdg.dsgtestapp.dsg.app.model.classes

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 *
 * Model class that represents Location json object in REST API
 */
class Location(val address: String,
               val latitude: Double,
               val longitude: Double,
               val postalCode: String,
               val cc: String,
               val city: String,
               val state: String,
               val country: String) {

    constructor(latitude: Double, longitude: Double) :
            this(
                    address = "",
                    latitude = latitude,
                    longitude = longitude,
                    postalCode = "",
                    cc = "",
                    city = "",
                    state = "",
                    country = ""
            )

    companion object {
        var current_latitude: Double = 40.448685
        var current_longitude: Double = -80.239625
    }
}