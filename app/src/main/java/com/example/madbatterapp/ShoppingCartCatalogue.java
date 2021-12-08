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
        menuOptions.add(new Product(R.drawable.caramelbrownie, R.string.caramel_brownie, R.string.caramelbrownie_description , 12.00));
        menuOptions.add(new Product(R.drawable.candybrownie, R.string.candy_brownie, R.string.candy_description , 14.00));
        menuOptions.add(new Product(R.drawable.chocobrownie, R.string.choco_brownie, R.string.choco_description , 12.00));
        menuOptions.add(new Product(R.drawable.coffeealmondbrownie, R.string.almond_brownie, R.string.almond_description , 12.00));
        menuOptions.add(new Product(R.drawable.doublechocobrownie, R.string.double_chocolate, R.string.doublechocolate_description , 12.00));
        menuOptions.add(new Product(R.drawable.raspberrybrownie, R.string.strawberry_brownie, R.string.strawberry_description , 12.00));
        menuOptions.add(new Product(R.drawable.walnutbrownie, R.string.walnut_brownie, R.string.walnut_description , 12.00));
        menuOptions.add(new Product(R.drawable.chocochip, R.string.chocolate_chip, R.string.chocolate_description , 5.00));
        menuOptions.add(new Product(R.drawable.chocooatmeal, R.string.chocooat_cookie, R.string.chocooat_description , 5.00));
        menuOptions.add(new Product(R.drawable.macaroon, R.string.macaroon_cookie, R.string.macaroon_description , 7.00));
        menuOptions.add(new Product(R.drawable.mnmcookie, R.string.mm_cookie, R.string.mm_description , 6.00));
        menuOptions.add(new Product(R.drawable.pecancookie, R.string.pecan_cookie, R.string.pecan_description , 5.00));
        menuOptions.add(new Product(R.drawable.pistachiocookie, R.string.pistachio_cookie, R.string.pistachio_description , 5.00));
        menuOptions.add(new Product(R.drawable.xmascookie, R.string.xmas_cookie, R.string.xmas_description , 7.00));

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
