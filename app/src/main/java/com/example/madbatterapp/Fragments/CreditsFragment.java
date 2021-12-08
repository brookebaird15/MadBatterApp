package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.madbatterapp.R;

public class CreditsFragment extends Fragment {
    TextView getapp;

    /**
     * All this is really doing is making so the textviews when click, link to html
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        getapp = view.findViewById(R.id.cookieCredit1);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cookieCredit2);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cookieCredit3);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cookieCredit8);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cookieCredit9);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.brownieCredit1);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.brownieCredit2);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.brownieCredit3);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.brownieCredit4);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit1);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit2);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit3);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit3);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit4);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit5);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit6);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit7);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit8);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.cakeCredit9);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit1);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit5);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit6);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit7);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit8);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit9);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        getapp = view.findViewById(R.id.otherCredit10);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}