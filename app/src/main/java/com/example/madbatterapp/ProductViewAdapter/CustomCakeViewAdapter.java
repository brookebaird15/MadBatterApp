package com.example.madbatterapp.ProductViewAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.Product;
import com.example.madbatterapp.R;

import java.util.ArrayList;

public class CustomCakeViewAdapter extends RecyclerView.Adapter<CustomCakeViewAdapter.CustomCakeHolder> {

    private ArrayList<Product> products;

    public CustomCakeViewAdapter(ArrayList<Product> cakeItems){
        this.products = cakeItems;}


    @NonNull
    @Override
    public CustomCakeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cake_card, parent, false);
        return new CustomCakeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCakeHolder holder,  int position) {
        Product currentItem = products.get(position);
        holder.image.setImageResource(currentItem.getProductImg());
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        if (products != null){
            return products.size();
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
            Product currentItem = products.get(getAbsoluteAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putInt("NAME", ((currentItem.getName())));
            bundle.putInt("IMAGE", currentItem.getProductImg());
            bundle.putInt("POST", getAbsoluteAdapterPosition());
            bundle.putInt("DESC", ((currentItem.getDescription())));
            Navigation.findNavController(view).navigate(R.id.action_nav_cake_to_product_details_fragment, bundle);


        }
    }
}

