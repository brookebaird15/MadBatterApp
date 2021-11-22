package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.madbatterapp.CakeViewAdapter.CakeItem;
import com.example.madbatterapp.CakeViewAdapter.CustomCakeViewAdapter;
import com.example.madbatterapp.CakeViewAdapter.ItemClickListener;
import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.CartListView.ShoppingCartCatalogue;
import com.example.madbatterapp.R;

import java.util.ArrayList;
import java.util.List;

public class CakeFragment extends Fragment implements ItemClickListener {

    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cake, container, false);

        //Obtain reference to catalogue
        productList = ShoppingCartCatalogue.getCatalogue(getResources());

        //Use either one adapter or the other depending on the screen width
        RecyclerView recyclerView = view.findViewById(R.id.largeCakeRecyclerView);
        if(recyclerView != null){
            //Large Screen
             recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        } else{
            //small screen
            recyclerView = view.findViewById(R.id.cakeRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        }
        ArrayList<CakeItem> cakeItemArrayList = new ArrayList<>();
        cakeItemArrayList.add(new CakeItem(R.drawable.chocomouse,getString(R.string.chocolate_mousse), "Lorem Ipsum", 35.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.caramelcake,getString(R.string.caramel_cake), "Lorem Ipsum", 35.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.sunflowercake,getString(R.string.sun_cake), "Lorem Ipsum", 55.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.blackberrycake,getString(R.string.berry_cake), "Lorem Ipsum", 49.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.lemoncake,getString(R.string.lemon_cake), "Lorem Ipsum", 35.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.birthdaycake,getString(R.string.birth_cake), "Lorem Ipsum", 30.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.vanillacake,getString(R.string.vanilla_cake), "Lorem Ipsum", 30.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.funfetticake,getString(R.string.fun_cake), "Lorem Ipsum", 30.00));
        cakeItemArrayList.add(new CakeItem(R.drawable.rosecake,getString(R.string.rose_cake), "Lorem Ipsum", 55.00));

        recyclerView.setAdapter(new CustomCakeViewAdapter(cakeItemArrayList, this));
        return view;
    }

    @Override
    public void onItemClick(CakeItem cakeItem) {
        Fragment fragment = ItemDetailsFragment.newInstance(cakeItem.getProductImg(), cakeItem.getName());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cakeRecyclerView, fragment).addToBackStack(null).commit();
    }
}