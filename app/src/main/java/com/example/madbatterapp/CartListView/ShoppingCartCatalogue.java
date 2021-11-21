package com.example.madbatterapp.CartListView;

import android.content.res.Resources;

import com.example.madbatterapp.CakeViewAdapter.CakeItem;
import com.example.madbatterapp.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartCatalogue {
    public static final String INDEX = "INDEX";

    private static List<Product> catalogue;
    private static List<Product> cart;

    //Create new product to be added to catalogue
    public static List<Product> getCatalogue (Resources res){
        if (catalogue == null){
            //make new catalogue list
            catalogue = new ArrayList<Product>();
            catalogue.add(new Product("Chocolate Mousse", R.drawable.chocomouse, "Lorem Ipsum", 35.00));
        }
    }
}
