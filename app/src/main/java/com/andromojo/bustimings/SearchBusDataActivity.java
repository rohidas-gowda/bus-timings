package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SearchBusDataActivity extends AppCompatActivity {
    ArrayList<SearchBusParameters> searchBusParametersArrayList;
    RecyclerView searchBusDataRecyclerView;
    String fromJourney, toJourney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bus_data);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fromJourney = extras.getString("FROMDATA");
            toJourney = extras.getString("TODATA");
        }

        SearchBusDBHandler searchBusDBHandler = new SearchBusDBHandler(this, null, null, 1);
        searchBusParametersArrayList = new ArrayList<>();
        searchBusParametersArrayList.clear();

        searchBusParametersArrayList = searchBusDBHandler.searchBusInfoFromDB(fromJourney, toJourney);

        searchBusDataRecyclerView = (RecyclerView) findViewById(R.id.search_bus_data_recyclerView);
        searchBusDataRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchBusDataRecyclerView.setAdapter(new SearchBusDataAdapter(searchBusParametersArrayList));

    }
}