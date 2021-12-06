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




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        TextView getapp = view.findViewById(R.id.cookieCredit1);
        getapp.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}