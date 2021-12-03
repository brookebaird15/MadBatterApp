package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madbatterapp.CakeViewAdapter.CustomCakeViewAdapter;
import com.example.madbatterapp.Pojo.Product;
import com.example.madbatterapp.ShoppingCartCatalogue;
import com.example.madbatterapp.R;

import java.util.List;

public class CakeFragment extends Fragment {

    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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