package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.CartListView.ShoppingCartCatalogue;
import com.example.madbatterapp.MainActivity;
import com.example.madbatterapp.R;
import com.example.madbatterapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailsFragment extends Fragment {
    private @NonNull
    ActivityMainBinding binding;
    Bundle extras;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment product_details_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetailsFragment newInstance(String param1, String param2) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);
        //ADD THIS TO YOUR ACTUAL ITEM FRAGMENT
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        MainActivity.fab.show();
        MainActivity.fab.setImageResource(R.drawable.ic_baseline_add_24);
        MainActivity.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(extras != null) {
                    ShoppingCartCatalogue.getInstance().getCart().add(ShoppingCartCatalogue.getInstance().getMenuOptions().get(extras.getInt("POST")));
                    //ArrayList<Product> currentList = ShoppingCartCatalogue.getInstance().getCart();
                    Snackbar.make(view, "Item added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        extras = getArguments();
        if (extras != null){
            ImageView productImage = view.findViewById(R.id.ImageViewProduct);
            productImage.setImageResource(extras.getInt("IMAGE"));
            TextView productName = view.findViewById(R.id.TextViewProductTitle);
            productName.setText(getString(extras.getInt("NAME")));
            TextView productDetails = view.findViewById(R.id.TextViewProductDetails);
            productDetails.setText(getString(extras.getInt("DESC")));
        }
        return view;
    }
}