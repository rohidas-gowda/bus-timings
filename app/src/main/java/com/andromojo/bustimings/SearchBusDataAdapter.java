package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchBusDataAdapter extends RecyclerView.Adapter<SearchBusDataAdapter.searchBusHolder> {
    ArrayList<SearchBusParameters> searchBusParametersArrayList;

    public SearchBusDataAdapter(ArrayList<SearchBusParameters> searchBusParametersArrayList) {
        this.searchBusParametersArrayList = searchBusParametersArrayList;
    }

    @NonNull
    @Override
    public searchBusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.search_single_bus_data, parent, false);
        return new searchBusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull searchBusHolder holder, int position) {
        holder.setSource.setText(searchBusParametersArrayList.get(position).getSource());
        holder.setDestination.setText(searchBusParametersArrayList.get(position).getDestination());
        holder.setVia.setText(searchBusParametersArrayList.get(position).getVia());
        holder.setService.setText(searchBusParametersArrayList.get(position).getService());
        holder.setTimings.setText(searchBusParametersArrayList.get(position).getTimings());
        holder.setStation.setText(searchBusParametersArrayList.get(position).getStation());
    }

    @Override
    public int getItemCount() {
        return searchBusParametersArrayList.size();
    }

    public class searchBusHolder extends RecyclerView.ViewHolder {
        TextView setSource, setDestination, setVia, setService, setTimings, setStation;
        public searchBusHolder(@NonNull View itemView) {
            super(itemView);
            setSource = (TextView) itemView.findViewById(R.id.source_db);
            setDestination = (TextView) itemView.findViewById(R.id.destination_db);
            setVia = (TextView) itemView.findViewById(R.id.via_db);
            setService = (TextView) itemView.findViewById(R.id.service_db);
            setTimings = (TextView) itemView.findViewById(R.id.timings_db);
            setStation = (TextView) itemView.findViewById(R.id.station_db);
        }
    }
}
