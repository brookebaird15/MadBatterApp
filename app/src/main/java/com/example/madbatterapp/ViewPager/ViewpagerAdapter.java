package com.example.madbatterapp.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.madbatterapp.Fragments.RecipeDetailsFragment;
import com.example.madbatterapp.R;

public class ViewpagerAdapter extends FragmentStateAdapter {
    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return RecipeDetailsFragment.newInstance(R.string.ingredienttitle, R.string.ingredients, true, false);
            case 1: return RecipeDetailsFragment.newInstance(R.string.directiontitle, R.string.stepone, false, false);
            case 2: return RecipeDetailsFragment.newInstance(R.string.directiontitle2,R.string.steptwo,  false, false);
            case 3: return RecipeDetailsFragment.newInstance(R.string.directiontitle3,R.string.stepthree, false, true);
            default: return RecipeDetailsFragment.newInstance(0,0,false, false);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
