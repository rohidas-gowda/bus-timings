package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReservedStateDetailsAdapter extends RecyclerView.Adapter<ReservedStateDetailsAdapter.reservedStateHolder> {
    ArrayList<ReservedStateParameters> reservedStateParametersArrayList;

    public ReservedStateDetailsAdapter(ArrayList<ReservedStateParameters> reservedStateParametersArrayList) {
        this.reservedStateParametersArrayList = reservedStateParametersArrayList;
    }

    @NonNull
    @Override
    public reservedStateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.display_single_reserved_state, parent, false);
        return new reservedStateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull reservedStateHolder holder, int position) {
        holder.setReservedStateSerialNo.setText(String.valueOf(reservedStateParametersArrayList.get(position).getReservedId()));
        holder.setReservedFromData.setText(reservedStateParametersArrayList.get(position).getReservedSource());
        holder.setReservedToData.setText(reservedStateParametersArrayList.get(position).getReservedDestination());
        holder.setReservedTimeData.setText(reservedStateParametersArrayList.get(position).getReservedTimings());
    }

    @Override
    public int getItemCount() {
        return reservedStateParametersArrayList.size();
    }

    public class reservedStateHolder extends RecyclerView.ViewHolder {
        TextView setReservedStateSerialNo, setReservedFromData, setReservedToData, setReservedTimeData;
        public reservedStateHolder(@NonNull View itemView) {
            super(itemView);
            setReservedStateSerialNo = (TextView) itemView.findViewById(R.id.reservedStateSerialNo);
            setReservedFromData = (TextView) itemView.findViewById(R.id.reservedFromData);
            setReservedToData = (TextView) itemView.findViewById(R.id.reservedToData);
            setReservedTimeData = (TextView) itemView.findViewById(R.id.reservedTimeData);
        }
    }
}
