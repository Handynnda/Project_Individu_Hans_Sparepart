package com.example.hanssparepart;

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
        // Tentukan fragment untuk setiap tab
        switch (position) {
            case 0:
                return new HomeFragmen();
            case 1:
                return new ProdukFragment();
            case 2:
                return new AboutMeFragment();
            default:
                return new HomeFragmen();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
