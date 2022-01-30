package com.andromojo.bustimings;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchBusInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchBusInfo extends Fragment {
    TextView fromUserData, toUserData;
    Button searchBusData;
    String fromJourney, toJourney;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == -1){
                String fromMessage = result.getData().getStringExtra("MSGFRM");
                fromJourney = fromMessage;
                fromUserData.setText(fromMessage);
            }
            if(result.getResultCode() == -2){
                String toMessage = result.getData().getStringExtra("MSGTO");
                toJourney = toMessage;
                toUserData.setText(toMessage);
            }
        }
    });
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchBusInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchBusInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchBusInfo newInstance(String param1, String param2) {
        SearchBusInfo fragment = new SearchBusInfo();
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
        View view = inflater.inflate(R.layout.fragment_search_bus_info, container, false);
        fromUserData = view.findViewById(R.id.from_user_data);
        toUserData = view.findViewById(R.id.to_user_data);
        searchBusData = view.findViewById(R.id.search_bus_data);

        fromUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fromUserIntent = new Intent(getActivity(), FromUserDataActivity.class);
                startForResult.launch(fromUserIntent);
            }
        });

            validateToUserInput();
            validateSearchBusData();



        return view;
    }

    private void validateToUserInput() {
        toUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fromJourney != null){
                    Intent toUserIntent = new Intent(getActivity(), ToUserDataActivity.class);
                    toUserIntent.putExtra("TOFILTER", fromJourney);
                    startForResult.launch(toUserIntent);
                } else {
                    Toast.makeText(getActivity(),"Please Enter \"From\"' Details First!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void validateSearchBusData() {
        searchBusData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fromJourney != null && fromJourney != toJourney && toJourney != null){
                    Intent intent = new Intent(getActivity(), SearchBusDataActivity.class);
                    intent.putExtra("FROMDATA", fromJourney);
                    intent.putExtra("TODATA", toJourney);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(),"Please Enter Journey Details!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}