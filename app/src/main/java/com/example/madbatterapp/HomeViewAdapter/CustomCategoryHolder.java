package com.example.madbatterapp.HomeViewAdapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.R;


class CustomCategoryHolder extends RecyclerView.ViewHolder{
    protected ImageView image;

    public CustomCategoryHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.categoryBtn);
    }
}

