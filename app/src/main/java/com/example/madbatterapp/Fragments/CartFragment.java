package com.example.madbatterapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.CartViewAdapter.CustomCartViewAdapter;
import com.example.madbatterapp.MainActivity;
import com.example.madbatterapp.Product;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;
import com.google.android.material.snackbar.Snackbar;

public class CartFragment extends Fragment {
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);


        MainActivity.fab.hide();
        RecyclerView recyclerView = view.findViewById(R.id.productCatalogRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new CustomCartViewAdapter(ShoppingCartCatalogue.getInstance().getCart(), getContext()));

        Button checkoutBtn = view.findViewById(R.id.checkoutBtn);
        if (ShoppingCartCatalogue.getInstance().getCart().size() > 0) {

            checkoutBtn.setOnClickListener(view1 -> {
                if (ShoppingCartCatalogue.getInstance().getCart().size() > 0) { //not null its suppose to be .size() < 0
                    String[] emailAddress = {"madbatterbakery@gmail.com"};
                    StringBuilder sb = new StringBuilder();
                    for (Product s : ShoppingCartCatalogue.getInstance().getCart()) {
                        sb.append(s.toString(requireContext()));
                        sb.append("\n");
                    }
                    Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                    i.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    i.putExtra(Intent.EXTRA_TEXT, "I am ordering " + sb.toString() + "from your bakery.");
                    startActivity(i);
                } else {
                    Snackbar.make(view, "Your cart is empty! Please add to the cart.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
//            System.out.println("I'm here");
                }
            });

        }
        return view;
    }
}
