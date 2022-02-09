package com.andromojo.bustimings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusStationInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusStationInfo extends Fragment {
    List<String> stationName;
    RecyclerView busStationNames;
    private BusStationAdapter.StationClickListener stationClickListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BusStationInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusStationInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static BusStationInfo newInstance(String param1, String param2) {
        BusStationInfo fragment = new BusStationInfo();
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
        View view = inflater.inflate(R.layout.fragment_bus_station_info, container, false);

        busStationNames = view.findViewById(R.id.busStationNameDisplay);
        busStationNames.setLayoutManager(new LinearLayoutManager(getContext()));

        stationName = new ArrayList<>();

        stationName.add("KEMPE GOWDA BUS STATION MAJESTIC");
        stationName.add("Andhra Pradesh");
        stationName.add("Goa");
        stationName.add("Kerala");
        stationName.add("Maharashtra");
        stationName.add("Tamil Nadu");
        stationName.add("Telangana");

        setStationClickListener();
        busStationNames.setAdapter(new BusStationAdapter(stationName, stationClickListener));

        return view;
    }

    private void setStationClickListener() {
        stationClickListener = new BusStationAdapter.StationClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), BusStationDataActivity.class);
                intent.putExtra("station_name", stationName.get(position));
                startActivity(intent);
            }
        };
    }
}