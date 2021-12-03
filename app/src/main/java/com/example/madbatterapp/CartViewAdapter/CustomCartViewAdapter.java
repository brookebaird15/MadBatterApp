package com.example.madbatterapp.CartViewAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.Product;
import com.example.madbatterapp.R;
import com.example.madbatterapp.ShoppingCartCatalogue;

import java.util.ArrayList;

public class CustomCartViewAdapter extends RecyclerView.Adapter<CustomCartViewAdapter.CustomCartHolder> {
    private final ArrayList<Product> cartItems;
    private final Context context;

    public CustomCartViewAdapter(ArrayList<Product> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;

    }

    @NonNull
    @Override
    public CustomCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_catalog_layout, parent, false);
        return new CustomCartHolder(view);
    }

    @SuppressLint({"DefaultLocale", "NotifyDataSetChanged"})
    @Override
    public void onBindViewHolder(@NonNull CustomCartHolder holder, int position) {
        Product currentItem = cartItems.get(position);
        holder.image.setImageResource(currentItem.getProductImg());
        holder.title.setText(context.getString(currentItem.getName()));
        holder.price.setText(String.format("%.2f", currentItem.getPrice()));
        holder.button.setOnClickListener(view -> {
            ShoppingCartCatalogue.getInstance().getCart().remove(ShoppingCartCatalogue.getInstance().getMenuOptions().get(holder.getAbsoluteAdapterPosition()));
//                System.out.println("Delete clicked");
            notifyDataSetChanged();

    });
    }
    @Override
    public int getItemCount() {
        if (cartItems != null) {
            return cartItems.size();
        }
        return 0;
    }

    public Context getContext() {
        return context;
    }

    static class CustomCartHolder extends RecyclerView.ViewHolder {
        protected ImageView image;
        protected TextView title;
        protected TextView price;
        protected ImageView button;

        public CustomCartHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.productImg);
            this.title = itemView.findViewById(R.id.productTitle);
            this.price = itemView.findViewById(R.id.productPrice);
            this.button = itemView.findViewById(R.id.deleteButton);
        }
    }
}


