package com.andromojo.bustimings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReservedStateAdapter extends RecyclerView.Adapter<ReservedStateAdapter.ViewHolder> {
    List<String> stateName;
    List<Integer> stateMap;
    private StatesClickListener statesClickListener;

    public ReservedStateAdapter(List<String> stateName, List<Integer> stateMap, StatesClickListener statesClickListener) {
        this.stateName = stateName;
        this.stateMap = stateMap;
        this.statesClickListener = statesClickListener;
    }

    @NonNull
    @Override
    public ReservedStateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.display_reserved_state, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservedStateAdapter.ViewHolder holder, int position) {
        holder.displayState.setText(stateName.get(position));
        holder.mapImage.setImageResource(stateMap.get(position));
    }

    public interface StatesClickListener{
        void onClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return stateName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView displayState;
        ImageView mapImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            displayState = itemView.findViewById(R.id.displayState);
            mapImage = itemView.findViewById(R.id.mapImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            statesClickListener.onClick(view, getAdapterPosition());
        }
    }
}
