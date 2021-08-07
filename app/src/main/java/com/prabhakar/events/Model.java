package com.prabhakar.events;

import java.io.Serializable;

public class Model implements Serializable {
    String title;
    String description;
    String startDate;
    String endDate;
    String startTime;
    String endTime;
    String currency;
    String price;

    public Model(String title, String description, String startDate, String endDate, String startTime, String endTime, String currency, String price) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.currency = currency;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrice() {
        return price;
    }
}
