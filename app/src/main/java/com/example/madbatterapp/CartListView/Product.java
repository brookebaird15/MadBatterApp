package com.example.madbatterapp.CartListView;

import android.graphics.drawable.Drawable;

public class Product {
    public String title;
    public int productImg;
    public String description;
    public double price;
    public boolean selected;

    public Product(int productImg, String title, String description, double price) {
        this.productImg = productImg;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
