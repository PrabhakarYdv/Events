package com.prabhakar.events;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class PriceDetailsFragment extends Fragment {
    private EditText price, currency;
    private Button buttonPreview;
    private String title, description, startDate, endDate, startTime, endTime;
    private CommunicationListener communicationListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("desc");
            startDate = getArguments().getString("startDate");
            endDate = getArguments().getString("endDate");
            startTime = getArguments().getString("startTime");
            endTime = getArguments().getString("endTime");
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
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        price = view.findViewById(R.id.price);
        currency = view.findViewById(R.id.currency);
        buttonPreview = view.findViewById(R.id.preview_btn);
        buttonPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!price.getText().toString().isEmpty() && !currency.getText().toString().isEmpty()) {
                    Intent intent = new Intent(getContext(), PreviewActivity.class);
                    Model model = new Model(title, description, startDate, endDate, startTime, endTime, currency.getText().toString(), price.getText().toString());
                    intent.putExtra("model", model);
                    startActivity(intent);
                }
                else {
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