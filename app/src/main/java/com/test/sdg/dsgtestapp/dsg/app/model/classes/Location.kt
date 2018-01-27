package com.test.sdg.dsgtestapp.dsg.app.model.classes

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */
class Location(val latitude: Double, val longitude: Double
) {

    constructor(address: String,
                latitude: Double,
                longitude: Double,
                postalCode: String,
                cc: String,
                city: String,
                state: String,
                country: String) : this(latitude = latitude, longitude = longitude)

    companion object {
        var current_latitude: Double = 0.0
        var current_longitude: Double = 0.0
    }

    var address: String = ""
        get() = address

    var postalCode: String = ""
        get() = postalCode

    var cc: String = ""
        get() = cc

    var city: String = ""
        get() = city

    var state: String = ""
        get() = state

    var country: String = ""
        get() = country

}