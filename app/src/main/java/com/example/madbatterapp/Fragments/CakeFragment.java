package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madbatterapp.CakeViewAdapter.CustomCakeViewAdapter;
import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.CartListView.ShoppingCartCatalogue;
import com.example.madbatterapp.MainActivity;
import com.example.madbatterapp.R;
import com.example.madbatterapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CakeFragment extends Fragment {

    private List<Product> productList;
    private @NonNull
    ActivityMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //ADD THIS TO YOUR ACTUAL ITEM FRAGMENT
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        MainActivity.fab.setImageResource(R.drawable.ic_baseline_add_24);
        MainActivity.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action2", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View view = inflater.inflate(R.layout.fragment_cake, container, false);

        //Use either one adapter or the other depending on the screen width
        RecyclerView recyclerView = view.findViewById(R.id.largeCakeRecyclerView);
        if(recyclerView != null){
            //Large Screen
             recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        } else{
            //small screen
            recyclerView = view.findViewById(R.id.cakeRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        }

        recyclerView.setAdapter(new CustomCakeViewAdapter(ShoppingCartCatalogue.getInstance().getMenuOptions()));
        return view;
    }

}