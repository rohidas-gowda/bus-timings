package com.andromojo.bustimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToUserDataAdapter extends RecyclerView.Adapter<ToUserDataAdapter.ViewHolder> {
    private ArrayList<String> toSearchArrayList;
    private ToUserDataAdapter.ItemClickListener mItemClickListener;

    public ToUserDataAdapter(ArrayList<String> toSearchArrayList, ItemClickListener mItemClickListener) {
        this.toSearchArrayList = toSearchArrayList;
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ToUserDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_single_to_data,parent,false);
        return new ToUserDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToUserDataAdapter.ViewHolder holder, int position) {
        holder.displayToChoice.setText(toSearchArrayList.get(position));
        holder.displayToChoice.setOnClickListener(view -> {
            mItemClickListener.onItemClick(toSearchArrayList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return toSearchArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView displayToChoice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            displayToChoice = (TextView) itemView.findViewById(R.id.to_choice_display);
        }
    }

    public void filterList(ArrayList<String> filteredData){
        this.toSearchArrayList = filteredData;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClick(String toData);
    }
}
