package com.example.madbatterapp.HomeViewAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.Fragments.ProductFragment;
import com.example.madbatterapp.Pojo.Product;
import com.example.madbatterapp.R;

import java.util.ArrayList;

public class CustomCategoryViewAdapter extends RecyclerView.Adapter<CustomCategoryViewAdapter.CustomCategoryHolder>{

    private ArrayList<CategoryItem> categoryItems;
    public CustomCategoryViewAdapter(ArrayList<CategoryItem> categoryItems) {this.categoryItems = categoryItems;}

    @NonNull
    @Override
    public CustomCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_category_card, parent, false);
        return new CustomCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCategoryHolder holder, int position) {
        CategoryItem categoryItem = categoryItems.get(position);
        holder.image.setImageResource(categoryItems.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        if (categoryItems != null) {
            return categoryItems.size();
        }
        return 0;
    }
    class CustomCategoryHolder extends RecyclerView.ViewHolder{
        protected ImageView image;

        public CustomCategoryHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.categoryBtn);
        }

    }
}


