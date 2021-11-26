package com.example.madbatterapp.CartListView;

import android.graphics.drawable.Drawable;

public class Product {
    public int title;
    public int productImg;
    public int description;
    public double price;
    public boolean selected;

    public Product(int productImg, int title, int description, double price) {
        this.productImg = productImg;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getName() {
        return title;
    }

    public void setName(int title) {
        this.title = title;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
