package com.example.lab5unitswift;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return appropriate fragment based on tab position
        if (position == 0) {
            return new TempFragment();      // First tab
        } else {
            return new DistanceFragment();   // Second tab
        }
    }

    @Override
    public int getItemCount() {
        return 2;  // We have 2 tabs
    }
}