package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayoutAdapter tabLayoutAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private String[] tabItemNames = new String[]{"Search", "Reserved", "Stations"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        tabLayoutAdapter = new TabLayoutAdapter(this);
        viewPager2.setAdapter(tabLayoutAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(tabItemNames[position]))).attach();
    }
}