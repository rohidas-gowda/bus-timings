package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class BusStationAdapter extends RecyclerView.Adapter<BusStationAdapter.stationHolder> {
    List<String> stationName;
    private StationClickListener stationClickListener;

    public BusStationAdapter(List<String> stationName, StationClickListener stationClickListener) {
        this.stationName = stationName;
        this.stationClickListener = stationClickListener;
    }

    @NonNull
    @Override
    public BusStationAdapter.stationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_station_name,parent,false);
        return new stationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStationAdapter.stationHolder holder, int position) {
        holder.displayStationName.setText(stationName.get(position));
    }

    public interface StationClickListener{
        void onClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return stationName.size();
    }

    public class stationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView displayStationName;
        public stationHolder(@NonNull View itemView) {
            super(itemView);
            displayStationName = (TextView) itemView.findViewById(R.id.stationName);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            stationClickListener.onClick(view, getAdapterPosition());
        }
    }
}
