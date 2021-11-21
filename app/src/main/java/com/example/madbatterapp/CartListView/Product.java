package com.example.madbatterapp.CartListView;

import android.graphics.drawable.Drawable;

public class Product {
    public String title;
    public Drawable productImg;
    public String description;
    public double price;
    public boolean selected;

    public Product(String title, Drawable productImg, String description, double price) {
        this.title = title;
        this.productImg = productImg;
        this.description = description;
        this.price = price;
    }
}