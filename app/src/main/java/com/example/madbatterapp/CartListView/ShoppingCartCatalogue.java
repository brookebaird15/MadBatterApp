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
    public static List<Product> getCatalogue(Resources res){
        if (catalogue == null){
            //make new catalogue list
            catalogue = new ArrayList<Product>();
            catalogue.add(new Product(R.drawable.chocomouse,res.getString(R.string.chocolate_mousse), res.getString(R.string.mousse_description), 35.00));
            catalogue.add(new Product(R.drawable.caramelcake,res.getString(R.string.caramel_cake), res.getString(R.string.caramel_description), 35.00));
            catalogue.add(new Product(R.drawable.sunflowercake,res.getString(R.string.sun_cake), res.getString(R.string.sun_description), 55.00));
            catalogue.add(new Product(R.drawable.blackberrycake,res.getString(R.string.berry_cake), res.getString(R.string.berry_description), 49.00));
            catalogue.add(new Product(R.drawable.lemoncake,res.getString(R.string.lemon_cake), res.getString(R.string.lemon_description), 35.00));
            catalogue.add(new Product(R.drawable.birthdaycake,res.getString(R.string.birth_cake), res.getString(R.string.birth_description), 30.00));
            catalogue.add(new Product(R.drawable.vanillacake,res.getString(R.string.vanilla_cake), res.getString(R.string.vanilla_description), 30.00));
            catalogue.add(new Product(R.drawable.funfetticake,res.getString(R.string.fun_cake), res.getString(R.string.fun_description), 30.00));
            catalogue.add(new Product(R.drawable.rosecake,res.getString(R.string.rose_cake), res.getString(R.string.rose_description), 55.00));
        }
        return catalogue;
    }
    //Create cart list
    public static List<Product> getCart(){
        if (cart == null){
            cart = new ArrayList<Product>();
        }
        return cart;
    }
}
