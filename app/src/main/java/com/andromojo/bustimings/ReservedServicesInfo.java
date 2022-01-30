package com.andromojo.bustimings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservedServicesInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReservedServicesInfo extends Fragment {
    RecyclerView reservedForState;
    List<String> stateName;
    List<Integer> stateMap;
    ReservedStateAdapter reservedStateAdapter;
    private ReservedStateAdapter.StatesClickListener statesClickListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReservedServicesInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReservedServicesInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static ReservedServicesInfo newInstance(String param1, String param2) {
        ReservedServicesInfo fragment = new ReservedServicesInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reserved_services_info, container, false);
        reservedForState = view.findViewById(R.id.reservedForState);

        stateName = new ArrayList<>();
        stateMap = new ArrayList<>();

        stateName.add("Karnataka");
        stateName.add("Andhra Pradesh");
        stateName.add("Goa");
        stateName.add("Kerala");
        stateName.add("Maharashtra");
        stateName.add("Tamil Nadu");
        stateName.add("Telangana");

        stateMap.add(R.drawable.ic_karnataka);
        stateMap.add(R.drawable.ic_andhra_pradesh);
        stateMap.add(R.drawable.ic_goa);
        stateMap.add(R.drawable.ic_kerala);
        stateMap.add(R.drawable.ic_maharashtra);
        stateMap.add(R.drawable.ic_tamil_nadu);
        stateMap.add(R.drawable.ic_telangana);

        setStateClickListener();
        reservedStateAdapter = new ReservedStateAdapter(stateName, stateMap, statesClickListener);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        reservedForState.setLayoutManager(gridLayoutManager);
        reservedForState.setAdapter(reservedStateAdapter);

        return view;
    }

    private void setStateClickListener() {
        statesClickListener = new ReservedStateAdapter.StatesClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), ReservedStateDetailsActivity.class);
                intent.putExtra("state_name", stateName.get(position));
                startActivity(intent);
            }
        };
    }
}