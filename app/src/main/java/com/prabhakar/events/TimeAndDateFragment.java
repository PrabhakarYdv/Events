package com.prabhakar.events;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TimeAndDateFragment extends Fragment {
    private EditText startDate, endDate, startTime, endTime;
    private Button buttonNext;
    private CommunicationListener communicationListener;
    private String title, description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("desc");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        startDate = view.findViewById(R.id.start_date);
        endDate = view.findViewById(R.id.end_date);
        startTime = view.findViewById(R.id.start_time);
        endTime = view.findViewById(R.id.end_time);
        buttonNext = view.findViewById(R.id.btn_next2);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!startDate.getText().toString().isEmpty() && !endDate.getText().toString().isEmpty()
                        && !startTime.getText().toString().isEmpty() && !endTime.getText().toString().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", title);
                    bundle.putString("desc", description);
                    bundle.putString("startDate", startDate.getText().toString());
                    bundle.putString("endDate", endDate.getText().toString());
                    bundle.putString("startTime", startTime.getText().toString());
                    bundle.putString("endTime", endTime.getText().toString());
                    communicationListener.launchPriceDetailsFragment(bundle);
                } else {
                    new AlertDialog.Builder(getContext()).setTitle("Information ")
                            .setMessage("All field are require !")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }
            }
        });
    }
}