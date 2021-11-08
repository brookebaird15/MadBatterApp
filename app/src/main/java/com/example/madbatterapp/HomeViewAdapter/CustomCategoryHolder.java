package com.example.madbatterapp.HomeViewAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madbatterapp.R;

public class CustomCategoryViewAdapter extends RecyclerView.Adapter<CustomCategoryHolder>{

    @NonNull
    @Override
    public CustomCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCategoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
public class CustomCategoryHolder extends RecyclerView.ViewHolder {
    protected ImageView image;

    public CustomCategoryHolder(@NonNull View itemView){
        super(itemView);
        this.image = itemView.findViewById(R.id.categoryBtn);

    }
}
