package com.example.madbatterapp.CakeViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.R;

import java.util.ArrayList;

public class CustomCakeViewAdapter extends RecyclerView.Adapter<CustomCakeHolder> {
    private ArrayList<CakeItem> cakeItems;
    public CustomCakeViewAdapter(ArrayList<CakeItem> cakeItems){this.cakeItems = cakeItems;}

    @NonNull
    @Override
    public CustomCakeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cake_card, parent, false);
        return new CustomCakeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCakeHolder holder, int position) {
        CakeItem cakeItem = cakeItems.get(position);
        holder.image.setImageResource(cakeItem.getImage());
        holder.name.setText(cakeItem.getName());
        holder.description.setText(cakeItem.getDescription());

    }

    @Override
    public int getItemCount() {
        if (cakeItems != null){
            return cakeItems.size();
        }
        return 0; 
    }
}
class CustomCakeHolder extends RecyclerView.ViewHolder{
    protected ImageView image;
    protected TextView name;
    protected TextView description;

    public CustomCakeHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.cakeImg);
        this.name = itemView.findViewById(R.id.name);
        this.description = itemView.findViewById(R.id.description);

    }
}
