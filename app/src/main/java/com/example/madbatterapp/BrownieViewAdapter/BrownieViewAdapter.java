package com.example.madbatterapp.BrownieViewAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.CakeViewAdapter.CustomCakeViewAdapter;
import com.example.madbatterapp.Pojo.Product;
import com.example.madbatterapp.R;

import java.util.ArrayList;

public class BrownieViewAdapter extends RecyclerView.Adapter<BrownieViewAdapter.CustomBrownieHolder> {

    private ArrayList<Product> brownieItems;

    public BrownieViewAdapter(ArrayList<Product> brownieItems){
        this.brownieItems = brownieItems;}


    @NonNull
    @Override
    public BrownieViewAdapter.CustomBrownieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cake_card, parent, false);
        return new CustomBrownieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrownieViewAdapter.CustomBrownieHolder holder, int position) {
        Product currentItem = brownieItems.get(position);
        holder.image.setImageResource(currentItem.getProductImg());
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
    }


    @Override
    public int getItemCount() {
        if (brownieItems != null){
            return brownieItems.size();
        }
        return 0;
    }

    class CustomBrownieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected ImageView image;
        protected TextView name;
        protected TextView description;

        public CustomBrownieHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.brownieImg);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product currentItem = brownieItems.get(getAbsoluteAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putInt("NAME", ((currentItem.getName())));
            bundle.putInt("IMAGE", currentItem.getProductImg());
            bundle.putInt("POST", getAbsoluteAdapterPosition());
            bundle.putInt("DESC", ((currentItem.getDescription())));
            Navigation.findNavController(view).navigate(R.id.action_nav_brownies_to_nav_product_details, bundle);


        }
    }
}
