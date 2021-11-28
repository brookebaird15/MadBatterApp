package com.example.madbatterapp.CakeViewAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.R;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomCakeViewAdapter extends RecyclerView.Adapter<CustomCakeViewAdapter.CustomCakeHolder> {

    private ArrayList<Product> cakeItems;

    public CustomCakeViewAdapter(ArrayList<Product> cakeItems){
        this.cakeItems = cakeItems;}


    @NonNull
    @Override
    public CustomCakeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cake_card, parent, false);
        return new CustomCakeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCakeHolder holder,  int position) {
        Product currentItem = cakeItems.get(position);
        holder.image.setImageResource(currentItem.getProductImg());
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        if (cakeItems != null){
            return cakeItems.size();
        }
        return 0;
    }
    class CustomCakeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected ImageView image;
        protected TextView name;
        protected TextView description;

        public CustomCakeHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.cakeImg);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product currentItem = cakeItems.get(getAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putString("NAME", String.valueOf((currentItem.getName())));
            bundle.putInt("IMAGE", currentItem.getProductImg());
            bundle.putString("DESC", String.valueOf((currentItem.getDescription())));
            Navigation.findNavController(view).navigate(R.id.action_nav_cake_to_product_details_fragment, bundle);


        }
    }
}


