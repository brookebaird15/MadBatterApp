package com.example.madbatterapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.ProductViewAdapter.ProductViewAdapter;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;

public class ProductFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean layout = sharedPreferences.getBoolean("gridLayout", false);
        //Use either one adapter or the other depending on the screen width
        RecyclerView recyclerView = view.findViewById(R.id.largeProductRecyclerView);
        if (recyclerView != null) {
            if (layout) {
                //Large Screen
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            }
        } else {
            //small screen
            recyclerView = view.findViewById(R.id.productRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        }
        recyclerView.setAdapter(new ProductViewAdapter(ShoppingCartCatalogue.getInstance().getMenuOptions()));
        return view;
    }
}