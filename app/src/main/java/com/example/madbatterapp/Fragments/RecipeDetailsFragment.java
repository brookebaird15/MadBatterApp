package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madbatterapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailsFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;
    private boolean mParam4;
    private boolean mParam5;

    public RecipeDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoolFactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeDetailsFragment newInstance(int param1, int param2, boolean param4, boolean param5) {
        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putBoolean(ARG_PARAM4, param4);
        args.putBoolean(ARG_PARAM5, param5);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam4 = getArguments().getBoolean(ARG_PARAM4);
            mParam5 = getArguments().getBoolean(ARG_PARAM5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_details, container, false);
        TextView fact = view.findViewById(R.id.recipeTitle);
        if (mParam1 != 0) {
            fact.setText(getString(mParam1));
        }
        TextView factText = view.findViewById(R.id.recipeText);
        if (mParam2 != 0) {
            factText.setText(getString(mParam2));
        }
        Button notes = view.findViewById(R.id.noteButton);
        if (!mParam4){
            notes.setVisibility(view.INVISIBLE);
        }
        Button timer = view.findViewById(R.id.timerButton);
        if (!mParam5){
            timer.setVisibility(view.INVISIBLE);
        }
        return view;
    }
}