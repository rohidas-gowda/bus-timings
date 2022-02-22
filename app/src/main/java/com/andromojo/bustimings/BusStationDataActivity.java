package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class BusStationDataActivity extends AppCompatActivity {
    ArrayList<SearchBusParameters> searchBusStationInfoArrayList;
    String stationFilter;
    RecyclerView displayStationRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_station_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            stationFilter = extras.getString("station_name");
        }


        SearchBusDBHandler searchBusDBHandler = new SearchBusDBHandler(this, null, null, 1);
        searchBusStationInfoArrayList = new ArrayList<>();
        searchBusStationInfoArrayList.clear();

        searchBusStationInfoArrayList = searchBusDBHandler.searchBusStationInfoFromDB(stationFilter);

        displayStationRecyclerView = (RecyclerView) findViewById(R.id.displayStationRecyclerView);
        displayStationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        displayStationRecyclerView.setAdapter(new BusStationDisplayAdapter(searchBusStationInfoArrayList));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}