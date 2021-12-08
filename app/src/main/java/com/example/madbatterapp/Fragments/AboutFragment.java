package com.example.madbatterapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.madbatterapp.R;


public class AboutFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ImageView profileImg = view.findViewById(R.id.profile_image);
        //Animation for image
        Animation fadeImg = AnimationUtils.loadAnimation(getContext(), R.anim.anime_fade);
        //Toggle the animation from settings
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int animationToggle = Integer.parseInt(sharedPreferences.getString("animationsMenu", "1"));

        //if 0, animation is off, if 1 animation is on
        if(animationToggle == 0) {
            fadeImg.setDuration(0);
        }
        profileImg.startAnimation(fadeImg);
        return view;

    }
}