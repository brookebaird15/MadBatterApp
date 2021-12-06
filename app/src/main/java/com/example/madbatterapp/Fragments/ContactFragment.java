package com.example.madbatterapp.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.madbatterapp.R;
import com.google.android.material.snackbar.Snackbar;


public class ContactFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        /**
         * Phone button to bring up the phone number for user to call
         */
        Button phoneButton = view.findViewById(R.id.phoneBtn);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5193549100"));
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e){
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * Email button to bring up an email service for user to email business with
         */
        Button emailButton = view.findViewById(R.id.emailBtn);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddress = {"madbatterbakery@gmail.com"};
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                /**TODO
                 * check if works @ college, laptop can't handle creating an email on emulator 
                 */
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e){
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * Map button to open up the location of business
         */
        Button mapButton = view.findViewById(R.id.mapBtn);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0, 0?q=42.99050434825693, -81.20547183308142");
                Intent i = new Intent(Intent.ACTION_VIEW, location);
                try {
                    startActivity(i);
                }  catch (ActivityNotFoundException e){
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Facebook button to open up facebook page
         */
        ImageView facebookButton = view.findViewById(R.id.facebookBtn);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    /**TODO
                     * Check if this goes to page, laptop too slow to run chrome emulator
                     */
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/LiLiPastries"));
                    startActivity(intent);
                } catch(Exception e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * Twitter button to open up to twitter page
         */
        ImageView twitterButton = view.findViewById(R.id.twitterBtn);
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Twitter"));
                    startActivity(intent);
                } catch(Exception e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * Instagram button to open up instragram page
         */
        ImageView instagramButton = view.findViewById(R.id.instagramBtn);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/lindt/"));
                    startActivity(intent);
                } catch(Exception e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Web intent to lead to the website of the business
         */
        ImageView websiteButton = view.findViewById(R.id.websiteBtn);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.skillshare.com/"));
                    startActivity(intent);
                } catch(Exception e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}