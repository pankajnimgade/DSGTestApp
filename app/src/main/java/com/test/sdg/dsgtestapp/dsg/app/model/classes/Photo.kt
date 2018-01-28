package com.test.sdg.dsgtestapp.dsg.app.model.classes

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 *
 * Model class that represents Photo json object in REST API
 */
data class Photo(val photoId: String, val createdAt: Long, val url: String)