package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ReservedStateDetailsActivity extends AppCompatActivity {
    ArrayList<ReservedStateParameters> reservedStateParametersArrayList;
    RecyclerView reservedStateDataRecyclerView;
    String stateFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_state_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            stateFilter = extras.getString("state_name");
        }

        getSupportActionBar().setTitle(stateFilter+" Bus Details");


        ReservedStateDBHandler reservedStateDBHandler = new ReservedStateDBHandler(this, null, null, 1);
        reservedStateParametersArrayList = new ArrayList<>();
        reservedStateParametersArrayList.clear();

        reservedStateParametersArrayList = reservedStateDBHandler.reservedStateInfoFromDB(stateFilter);

        reservedStateDataRecyclerView = (RecyclerView) findViewById(R.id.reserved_state_data_recyclerView);
        reservedStateDataRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        reservedStateDataRecyclerView.setAdapter(new ReservedStateDetailsAdapter(reservedStateParametersArrayList));

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