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
        return view;
    }
}