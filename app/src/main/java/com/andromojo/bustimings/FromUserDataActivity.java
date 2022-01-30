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
import android.widget.Toast;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchBusDBHandler searchBusDBHandler = new SearchBusDBHandler(this,null,null,1);

        fromSearchRecycler = (RecyclerView) findViewById(R.id.search_from_choice);
        fromSearchInput = (EditText) findViewById(R.id.search_from_input);

        uniqueSearchFrom = searchBusDBHandler.searchFromInfoFromDB();
        fromSearchArrayList = new ArrayList<String>(uniqueSearchFrom);
        fromSearchRecycler.setHasFixedSize(true);
        fromSearchRecycler.setLayoutManager(new LinearLayoutManager(this));

        fromUserDataAdapter = new FromUserDataAdapter(fromSearchArrayList, new FromUserDataAdapter.ItemClickListener() {
            @Override
            public void onItemClick(String fromData) {
                Intent fromIntent = new Intent();
                fromIntent.putExtra("MSGFRM", fromData);
                setResult(-1, fromIntent);
                finish();
            }
        });

        fromSearchRecycler.setAdapter(fromUserDataAdapter);

        fromSearchInput.requestFocus();

        fromSearchInput.addTextChangedListener(new TextWatcher() {
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

        for(String searchData : fromSearchArrayList){
            if(searchData.toLowerCase().contains(searchText.toLowerCase())){
                filteredData.add(searchData);
            }
        }
        fromUserDataAdapter.filterList(filteredData);
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