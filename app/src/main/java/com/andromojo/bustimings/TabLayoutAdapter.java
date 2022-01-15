package com.andromojo.bustimings;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {
    private String[] tabItemNames = new String[]{"Search", "Reserved", "Stations"};

    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new SearchBusInfo();
            case 1: return new ReservedServicesInfo();
            case 2: return new BusStationInfo();
        }
        return new SearchBusInfo();
    }

    @Override
    public int getItemCount() {
        return tabItemNames.length;
    }
}
