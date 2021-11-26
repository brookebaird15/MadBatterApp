package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.madbatterapp.CartListView.CustomCartListAdapter;
import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.CartListView.ShoppingCartCatalogue;
import com.example.madbatterapp.R;

import java.util.List;

public class CartFragment extends Fragment {

    private List<Product> shoppingCartList;
    private CustomCartListAdapter customCartListAdapter;
    ListView listViewCatalog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        //Clear checkboxes of selections
        for (int i = 0; i < shoppingCartList.size(); i++) {
            shoppingCartList.get(i).selected = false;
        }
        //Create the list
        listViewCatalog = view.findViewById(R.id.productCatalogListView);
        listViewCatalog.setAdapter(new CustomCartListAdapter(shoppingCartList, getLayoutInflater(), false));
        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Make it so the data from the details fragment gets added to the list
                //I THINK THIS IS WHERE IT'D BE CREATED???
            }
        });




        return view;
    }
}