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
    private FromUserDataAdapter.ItemClickListener mItemClickListener;

    public FromUserDataAdapter(ArrayList<String> fromSearchArrayList, ItemClickListener mItemClickListener) {
        this.fromSearchArrayList = fromSearchArrayList;
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public FromUserDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_single_from_data,parent,false);
        return new FromUserDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FromUserDataAdapter.ViewHolder holder, int position) {
        holder.displayFromChoice.setText(fromSearchArrayList.get(position));
        holder.displayFromChoice.setOnClickListener(view -> {
            mItemClickListener.onItemClick(fromSearchArrayList.get(position));
        });
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

    public void filterList(ArrayList<String> filteredData){
        this.fromSearchArrayList = filteredData;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClick(String fromData);
    }
}
