package com.test.sdg.dsgtestapp.first.page.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.test.sdg.dsgtestapp.R;
import com.test.sdg.dsgtestapp.first.page.model.Venue;
import com.test.sdg.dsgtestapp.venue.page.view.VenueActivity;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private Context context;
    private List<Venue> venues;
    private LayoutInflater layoutInflater;

    public VenueAdapter(Context context, List<Venue> venues) {
        this.context = context;
        this.venues = venues;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_venue_in_list, parent, false);
        return new VenueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        final Venue venue = venues.get(position);
        holder.nameTextView.setText(venue.getName());
        holder.ratingBar.setRating(venue.getRating() / 2);
        holder.ratingTextView.setText(venue.getRating() + "");
        LayerDrawable stars = (LayerDrawable) holder.ratingBar.getProgressDrawable();
        if (venue.getRatingColor() != null && !venue.getRatingColor().isEmpty()) {
            stars.getDrawable(2).setColorFilter(
                    Color.parseColor("#" + venue.getRatingColor()), PorterDuff.Mode.SRC_ATOP);
        } else {
            stars.getDrawable(2).setColorFilter(
                    Color.parseColor("#cacaca"), PorterDuff.Mode.SRC_ATOP);
        }
        holder.rootLayoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent venueActivityIntent = new Intent(context, VenueActivity.class);
                venueActivityIntent.putExtra(VenueActivity.EXTRA_KEY_TAG, (new Gson()).toJson(venue));
                context.startActivity(venueActivityIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }


    public class VenueViewHolder extends RecyclerView.ViewHolder {

        private CardView rootLayoutCardView;
        private TextView nameTextView;
        private RatingBar ratingBar;
        private TextView ratingTextView;

        public VenueViewHolder(View itemView) {
            super(itemView);
            rootLayoutCardView = itemView.findViewById(R.id.single_venue_in_list_name_root_CardView);
            nameTextView = itemView.findViewById(R.id.single_venue_in_list_name_textView);
            ratingBar = itemView.findViewById(R.id.single_venue_in_list_ratingBar);
            ratingTextView = itemView.findViewById(R.id.single_venue_in_list_rating_textView);
        }
    }

}
