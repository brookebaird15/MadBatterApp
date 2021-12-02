package com.example.madbatterapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.madbatterapp.CartViewAdapter.CustomCartViewAdapter;
import com.example.madbatterapp.MainActivity;
import com.example.madbatterapp.Product;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private ArrayList<Product> cartItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        MainActivity.fab.hide();
        RecyclerView recyclerView = view.findViewById(R.id.productCatalogRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new CustomCartViewAdapter(ShoppingCartCatalogue.getInstance().getCart(), getContext()));

        Button checkoutBtn = view.findViewById(R.id.checkoutBtn);
        if (ShoppingCartCatalogue.getInstance().getCart() != null) {
            checkoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] emailAddress = {"madbatterbakery@gmail.com"};
                    Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                    i.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    i.putExtra(Intent.EXTRA_TEXT, "Thank you for your purchase of: " + ShoppingCartCatalogue.getInstance().getCart() + ". " +
                            "You will receive an email when your order is ready for pickup. Please pay in person for your order");
                    startActivity(i);
                }
            });
        } else {
            checkoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Your cart is empty! Please add to the cart.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
        return view;
    }
}