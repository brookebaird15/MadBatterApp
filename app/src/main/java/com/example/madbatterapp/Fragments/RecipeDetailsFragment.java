package com.example.madbatterapp.Fragments;

import static com.google.android.gms.actions.NoteIntents.*;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madbatterapp.R;
import com.google.android.gms.actions.NoteIntents;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailsFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final int PERMISSION_CREATE_NOTE = 0;
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
        if (!mParam4) {
            notes.setVisibility(view.INVISIBLE);
        }
        //So this intent doesnt work or it's out of date???
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    //Check to see if asked
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext()).create();
                        alertDialog.setTitle("Create Note Permission");
                        alertDialog.setMessage("We need access to Notes to add the ingredients");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertDialog.dismiss();
                                //request the permission
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        PERMISSION_CREATE_NOTE);
                            }
                        });
                        alertDialog.show();

                    } else {
                        //Ask for the permission
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                PERMISSION_CREATE_NOTE);
                    }
                } else {
                    //We have the permission
                    Intent intent = new Intent(ACTION_CREATE_NOTE)
                            .putExtra(EXTRA_NAME, getString(R.string.ingredienttitle))
                            .putExtra(EXTRA_TEXT, getString(R.string.ingredients));
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getContext(),
                                "No software installed", Toast.LENGTH_LONG).show();
                        Snackbar.make(getActivity().findViewById(android.R.id.content),
                                "No software installed", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
        Button timer = view.findViewById(R.id.timerButton);
        if (!mParam5) {
            timer.setVisibility(view.INVISIBLE);
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int alarmToggle = Integer.parseInt(sharedPreferences.getString("alarmMenu", "0"));
        if (alarmToggle == 1) {
            timer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                            .putExtra(AlarmClock.EXTRA_MESSAGE, "Set a timer for baking")
                            .putExtra(AlarmClock.EXTRA_LENGTH, 1200)
                            .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getContext(),
                                "No software installed", Toast.LENGTH_LONG).show();
                        Snackbar.make(getActivity().findViewById(android.R.id.content),
                                "No software installed", Snackbar.LENGTH_LONG).show();
                    }
                }
            });
        }
            return view;
        }
}