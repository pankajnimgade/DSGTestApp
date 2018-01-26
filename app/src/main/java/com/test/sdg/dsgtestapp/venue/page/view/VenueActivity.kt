package com.test.sdg.dsgtestapp.venue.page.view

import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.test.sdg.dsgtestapp.R
import com.test.sdg.dsgtestapp.first.page.model.Venue
import com.test.sdg.dsgtestapp.venue.page.model.VenueActivityModel
import com.test.sdg.dsgtestapp.venue.page.presenter.VenueActivityPresenter
import kotlinx.android.synthetic.main.activity_venue.*
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.graphics.drawable.LayerDrawable
import android.support.v7.graphics.drawable.DrawableWrapper
import android.util.Log


class VenueActivity : AppCompatActivity(), IVenueActivity {

    private val presenter = VenueActivityPresenter(VenueActivityModel())

    private lateinit var photo: ImageView
    private lateinit var storeNameTextView: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var ratingValueTextView: TextView
    private lateinit var urlTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var contactDetailsTextView: TextView

    companion object {
        const val EXTRA_KEY_TAG = "VenueActivity_EXTRA"
        const val TAG = "VenueActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUI()
    }

    private fun initializeUI() {
        photo = findViewById(R.id.VenueActivity_photo_ImageView)
        storeNameTextView = findViewById(R.id.VenueActivity_store_name_ImageView)
        ratingBar = findViewById(R.id.VenueActivity_rating_RatingBar)
        ratingValueTextView = findViewById(R.id.VenueActivity_rating_value_TextView)
        urlTextView = findViewById(R.id.VenueActivity_url_TextView)
        addressTextView = findViewById(R.id.VenueActivity_address_TextView)
        contactDetailsTextView = findViewById(R.id.VenueActivity_contact_details_TextView)
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        val venueSerialized = intent.getStringExtra(EXTRA_KEY_TAG)
        presenter.setVenueData(Gson().fromJson(venueSerialized, Venue::class.java))
    }

    override fun onStop() {
        super.onStop()
        val stars = ratingBar.progressDrawable as LayerDrawable
        stars.getDrawable(2).setColorFilter(Color.parseColor("#cacaca"), PorterDuff.Mode.SRC_ATOP)
    }
    override fun setPhoto(photoURL: String) {
        Picasso.with(applicationContext).load(photoURL).into(photo)
    }

    override fun storeName(storeName: String) {
        storeNameTextView.text = storeName
    }

    override fun setRatingBar(ratingValue: Float) {
        ratingBar.rating = ratingValue / 2
        ratingValueTextView.text = "$ratingValue"
    }

    override fun setRatingBarColor(ratingColor: String?) {
        Log.d(TAG, "ratingColor: $ratingColor")
        val stars = ratingBar.progressDrawable as LayerDrawable
        stars.getDrawable(2).setColorFilter(Color.parseColor("#$ratingColor"), PorterDuff.Mode.SRC_ATOP)
    }

    override fun setURL(url: String) {
        urlTextView.text = url
    }

    override fun setAddress(address: String) {
        addressTextView.text = address
    }

    override fun setContactDetails(contactDetails: String) {
        addressTextView.text = contactDetails
    }
}
