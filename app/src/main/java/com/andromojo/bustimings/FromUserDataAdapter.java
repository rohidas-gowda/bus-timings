package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FromUserDataAdapter extends RecyclerView.Adapter<FromUserDataAdapter.ViewHolder>{
    private ArrayList<String> fromSearchArrayList;

    public FromUserDataAdapter(ArrayList<String> fromSearchArrayList) {
        this.fromSearchArrayList = fromSearchArrayList;
    }

    @NonNull
    @Override
    public FromUserDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_single_from_data,parent,false);
        return new FromUserDataAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FromUserDataAdapter.ViewHolder holder, int position) {
        holder.displayFromChoice.setText(fromSearchArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return fromSearchArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView displayFromChoice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            displayFromChoice = (TextView) itemView.findViewById(R.id.from_choice_display);
        }
    }
}
