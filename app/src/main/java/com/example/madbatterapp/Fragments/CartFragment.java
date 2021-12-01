package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.madbatterapp.CartViewAdapter.CustomCartViewAdapter;
import com.example.madbatterapp.MainActivity;
import com.example.madbatterapp.Product;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;

import java.util.List;

public class CartFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        MainActivity.fab.hide();
        RecyclerView recyclerView = view.findViewById(R.id.productCatalogRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new CustomCartViewAdapter(ShoppingCartCatalogue.getInstance().getCart(), getContext()));
        return view;
    }
}