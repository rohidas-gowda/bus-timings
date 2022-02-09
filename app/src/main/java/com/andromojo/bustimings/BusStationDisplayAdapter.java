package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusStationDisplayAdapter extends RecyclerView.Adapter<BusStationDisplayAdapter.stationDataHolder> {
    ArrayList<SearchBusParameters> searchBusStationInfoArrayList;

    public BusStationDisplayAdapter(ArrayList<SearchBusParameters> searchBusStationInfoArrayList) {
        this.searchBusStationInfoArrayList = searchBusStationInfoArrayList;
    }

    @NonNull
    @Override
    public BusStationDisplayAdapter.stationDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_bus_station_data,parent,false);
        return new stationDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStationDisplayAdapter.stationDataHolder holder, int position) {
        holder.SetStationSerialNo.setText(String.valueOf(searchBusStationInfoArrayList.get(position).getStationSerialNo()));
        holder.SetStationFrom.setText(searchBusStationInfoArrayList.get(position).getSource());
        holder.SetStationTo.setText(searchBusStationInfoArrayList.get(position).getDestination());
        holder.SetStationService.setText(searchBusStationInfoArrayList.get(position).getService());
        holder.SetStationTime.setText(searchBusStationInfoArrayList.get(position).getTimings());
        holder.SetStationVia.setText(searchBusStationInfoArrayList.get(position).getVia());
    }

    @Override
    public int getItemCount() {
        return searchBusStationInfoArrayList.size();
    }

    public class stationDataHolder extends RecyclerView.ViewHolder {
        TextView SetStationSerialNo, SetStationFrom, SetStationTo, SetStationService, SetStationTime, SetStationVia;
        public stationDataHolder(@NonNull View itemView) {
            super(itemView);
            SetStationSerialNo = (TextView) itemView.findViewById(R.id.displayStationSerialNo);
            SetStationFrom = (TextView) itemView.findViewById(R.id.displayStationFrom);
            SetStationTo = (TextView) itemView.findViewById(R.id.displayStationTo);
            SetStationService = (TextView) itemView.findViewById(R.id.displayStationService);
            SetStationTime = (TextView) itemView.findViewById(R.id.displayStationTime);
            SetStationVia = (TextView) itemView.findViewById(R.id.displayStationVia);
        }
    }
}
