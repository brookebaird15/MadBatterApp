package com.example.madbatterapp;

import com.example.madbatterapp.Pojo.Product;

import java.util.ArrayList;

public class ShoppingCartCatalogue {
    private static ShoppingCartCatalogue instance;
    private ArrayList<Product> menuOptions = new ArrayList<>();
    private ArrayList<Product> cart = new ArrayList<>();

    private ShoppingCartCatalogue(){
        menuOptions.add(new Product(R.drawable.chocomouse, R.string.chocolate_mousse, R.string.mousse_description, 35.00));
        menuOptions.add(new Product(R.drawable.caramelcake,R.string.caramel_cake, R.string.caramel_description, 35.00));
        menuOptions.add(new Product(R.drawable.sunflowercake,R.string.sun_cake, R.string.sun_description, 55.00));
        menuOptions.add(new Product(R.drawable.blackberrycake,R.string.berry_cake, R.string.berry_description, 49.00));
        menuOptions.add(new Product(R.drawable.lemoncake,R.string.lemon_cake, R.string.lemon_description, 35.00));
        menuOptions.add(new Product(R.drawable.birthdaycake,R.string.birth_cake, R.string.birth_description, 30.00));
        menuOptions.add(new Product(R.drawable.vanillacake,R.string.vanilla_cake, R.string.vanilla_description, 30.00));
        menuOptions.add(new Product(R.drawable.funfetticake,R.string.fun_cake, R.string.fun_description, 30.00));
        menuOptions.add(new Product(R.drawable.rosecake,R.string.rose_cake, R.string.rose_description, 55.00));
    }

    public static ShoppingCartCatalogue getInstance(){
        if (instance == null){
            instance = new ShoppingCartCatalogue();
        }
        return instance;
    }
    public ArrayList<Product> getMenuOptions(){ return menuOptions;}
    public ArrayList<Product> getCart(){return cart;}


}
