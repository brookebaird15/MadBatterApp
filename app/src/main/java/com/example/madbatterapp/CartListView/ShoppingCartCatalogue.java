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
            catalogue.add(new CakeItem(R.drawable.chocomouse,res.getString(R.string.chocolate_mousse), "Lorem Ipsum", 35.00));
            catalogue.add(new CakeItem(R.drawable.caramelcake,res.getString(R.string.caramel_cake), "Lorem Ipsum", 35.00));
            catalogue.add(new CakeItem(R.drawable.sunflowercake,res.getString(R.string.sun_cake), "Lorem Ipsum", 55.00));
            catalogue.add(new CakeItem(R.drawable.blackberrycake,res.getString(R.string.berry_cake), "Lorem Ipsum", 49.00));
            catalogue.add(new CakeItem(R.drawable.lemoncake,res.getString(R.string.lemon_cake), "Lorem Ipsum", 35.00));
            catalogue.add(new CakeItem(R.drawable.birthdaycake,res.getString(R.string.birth_cake), "Lorem Ipsum", 30.00));
            catalogue.add(new CakeItem(R.drawable.vanillacake,res.getString(R.string.vanilla_cake), "Lorem Ipsum", 30.00));
            catalogue.add(new CakeItem(R.drawable.funfetticake,res.getString(R.string.fun_cake), "Lorem Ipsum", 30.00));
            catalogue.add(new CakeItem(R.drawable.rosecake,res.getString(R.string.rose_cake), "Lorem Ipsum", 55.00));
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
