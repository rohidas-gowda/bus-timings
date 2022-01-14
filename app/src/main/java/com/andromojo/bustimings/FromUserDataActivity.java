package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Set;

public class FromUserDataActivity extends AppCompatActivity {
    RecyclerView fromSearchRecycler;
    EditText fromSearchInput;
    private Set uniqueSearchFrom;
    private ArrayList<String> fromSearchArrayList;
    FromUserDataAdapter fromUserDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_user_data);

        SearchBusDBHandler searchBusDBHandler = new SearchBusDBHandler(this,null,null,1);

        fromSearchRecycler = (RecyclerView) findViewById(R.id.search_from_choice);
        fromSearchInput = (EditText) findViewById(R.id.search_from_input);

        uniqueSearchFrom = searchBusDBHandler.searchFromInfoFromDB();
        fromSearchArrayList = new ArrayList<String>(uniqueSearchFrom);
        fromSearchRecycler.setHasFixedSize(true);
        fromSearchRecycler.setLayoutManager(new LinearLayoutManager(this));
        fromUserDataAdapter = new FromUserDataAdapter(fromSearchArrayList);
        fromSearchRecycler.setAdapter(fromUserDataAdapter);
    }
}