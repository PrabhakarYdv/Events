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


public class EventDetailsFragment extends Fragment {
    private EditText eventTitle, eventDescription;
    private Button buttonNext;
    private CommunicationListener communicationListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        eventTitle = view.findViewById(R.id.title);
        eventDescription = view.findViewById(R.id.description);
        buttonNext = view.findViewById(R.id.btn_next1);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eventDescription.getText().toString().isEmpty() && !eventTitle.getText().toString().isEmpty()) {
                    String title = eventTitle.getText().toString();
                    String description = eventDescription.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", title);
                    bundle.putString("desc", description);
                    communicationListener.launchTimeAndDateFragment(bundle);
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