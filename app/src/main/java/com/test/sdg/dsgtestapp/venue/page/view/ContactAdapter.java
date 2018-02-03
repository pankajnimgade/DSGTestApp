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

package com.test.sdg.dsgtestapp.venue.page.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.sdg.dsgtestapp.R;
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Contact;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 *
 * RecyclerView adapter used for Contact list associated with the Store
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    private List<Contact> contactList;
    private LayoutInflater layoutInflater;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_contact_in_list, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        final Contact contact = contactList.get(position);
        holder.phoneTextView.setText(contact.getPhone() + "");
        holder.twitterTextView.setText(contact.getTwitter());
        holder.facebookNameTextView.setText(contact.getFacebookName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView phoneTextView;
        private TextView twitterTextView;
        private TextView facebookNameTextView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            phoneTextView = itemView.findViewById(R.id.single_contact_in_list_phone_TextView);
            twitterTextView = itemView.findViewById(R.id.single_contact_in_list_twitter_TextView);
            facebookNameTextView = itemView.findViewById(R.id.single_contact_in_list_facebook_TextView);
        }
    }
}
