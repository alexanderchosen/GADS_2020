package com.example.gads2020leaderboard;

import com.google.gson.annotations.SerializedName;

public class GadsRetrofitLeaders {
    @SerializedName("name")
    private  String name;
    @SerializedName("hours")
    private Integer hours;
    @SerializedName("country")
    private String country;
    @SerializedName("batchUrl")
    private String batchUrl;

    public GadsRetrofitLeaders(String name, Integer hours, String country, String batchUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.batchUrl = batchUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBatchUrl() {
        return batchUrl;
    }
}


