package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.madbatterapp.CakeViewAdapter.CakeItem;
import com.example.madbatterapp.CakeViewAdapter.CustomCakeViewAdapter;
import com.example.madbatterapp.CartListView.Product;
import com.example.madbatterapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CakeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CakeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CakeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CakeFragment newInstance(String param1, String param2) {
        CakeFragment fragment = new CakeFragment();
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
        View view = inflater.inflate(R.layout.fragment_cake, container, false);

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

        recyclerView.setAdapter(new CustomCakeViewAdapter(cakeItemArrayList));
        return view;
    }
}