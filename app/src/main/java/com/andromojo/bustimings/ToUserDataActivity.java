package com.andromojo.bustimings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Set;

public class ToUserDataActivity extends AppCompatActivity {
    RecyclerView toSearchRecycler;
    EditText toSearchInput;
    private Set uniqueSearchTo;
    private ArrayList<String> toSearchArrayList;
    ToUserDataAdapter toUserDataAdapter;
    String fromJourney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_user_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fromJourney = extras.getString("TOFILTER");
        }

        SearchBusDBHandler searchBusDBHandler = new SearchBusDBHandler(this,null,null,1);

        toSearchRecycler = (RecyclerView) findViewById(R.id.search_to_choice);
        toSearchInput = (EditText) findViewById(R.id.search_to_input);

        uniqueSearchTo = searchBusDBHandler.searchToInfoFromDB(fromJourney);
        toSearchArrayList = new ArrayList<String>(uniqueSearchTo);

        toSearchRecycler.setHasFixedSize(true);
        toSearchRecycler.setLayoutManager(new LinearLayoutManager(this));

        toUserDataAdapter = new ToUserDataAdapter(toSearchArrayList, new ToUserDataAdapter.ItemClickListener() {
            @Override
            public void onItemClick(String toData) {
                Intent toIntent = new Intent();
                toIntent.putExtra("MSGTO", toData);
                setResult(-2, toIntent);
                finish();
            }
        });

        toSearchRecycler.setAdapter(toUserDataAdapter);

        toSearchInput.requestFocus();

        toSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void filter(String searchText){
        ArrayList<String> filteredData = new ArrayList<>();

        for(String searchData: toSearchArrayList){
            if(searchData.toLowerCase().contains(searchText.toLowerCase())){
                filteredData.add(searchData);
            }
        }
        toUserDataAdapter.filterList(filteredData);
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