package com.example.madbatterapp;

import static com.google.android.gms.actions.NoteIntents.ACTION_CREATE_NOTE;
import static com.google.android.gms.actions.NoteIntents.EXTRA_NAME;
import static com.google.android.gms.actions.NoteIntents.EXTRA_TEXT;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.madbatterapp.Fragments.RecipeDetailsFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.madbatterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_recipe)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case RecipeDetailsFragment.PERMISSION_CREATE_NOTE:
                if(grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //We have the permission
                   Intent intent = new Intent(ACTION_CREATE_NOTE)
                            .putExtra(EXTRA_NAME, getString(R.string.ingredienttitle))
                            .putExtra(EXTRA_TEXT, getString(R.string.ingredients));
                    try{
                        startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        Toast.makeText(this,
                                "No software installed", Toast.LENGTH_LONG).show();
                        Snackbar.make(this.findViewById(android.R.id.content),
                                "No software installed", Snackbar.LENGTH_LONG).show();
                    }
                }
        }
    }
}