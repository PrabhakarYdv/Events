package com.prabhakar.events;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView eventTitle, eventDescription, eventStartDate, eventStartTime, eventEndDate, eventEndTime, eventPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        setEventData();
    }

    private void initViews() {
        eventTitle = findViewById(R.id.event_title);
        eventDescription = findViewById(R.id.event_desc);
        eventStartDate = findViewById(R.id.event_start_date);
        eventEndDate = findViewById(R.id.event_end_date);
        eventStartTime = findViewById(R.id.event_start_time);
        eventEndTime = findViewById(R.id.event_end_time);
        eventPrice = findViewById(R.id.event_price);
    }

    private void setEventData() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        eventTitle.setText(model.getTitle());
        eventDescription.setText(model.getDescription());
        eventStartDate.setText(model.getStartDate());
        eventEndDate.setText(model.getEndDate());
        eventStartTime.setText(model.getStartTime());
        eventEndTime.setText(model.getEndTime());
        eventPrice.setText(model.getCurrency() + " " + model.getPrice());
    }
}