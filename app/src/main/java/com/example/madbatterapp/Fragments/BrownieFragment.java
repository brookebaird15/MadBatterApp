package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madbatterapp.ProductsViewAdapter.CustomRecyclerViewAdapter;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrownieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrownieFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brownie, container, false);

        //Use either one adapter or the other depending on the screen width
        RecyclerView recyclerView = view.findViewById(R.id.largeBrownieRecyclerView);
        if (recyclerView != null) {
            //Large Screen
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        } else {
            //small screen
            recyclerView = view.findViewById(R.id.brownieRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        }
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(ShoppingCartCatalogue.getInstance().getMenuOptions()));
        return view;
    }
}