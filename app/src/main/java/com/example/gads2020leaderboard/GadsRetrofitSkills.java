package com.example.gads2020leaderboard;

import com.google.gson.annotations.SerializedName;

public class GadsRetrofitSkills {
    @SerializedName("name")
    private  String name;
    @SerializedName("score")
    private Integer score;
    @SerializedName("country")
    private String country;
    @SerializedName("batchUrl")
    private String batchUrl;

    public GadsRetrofitSkills(String name, Integer score, String country, String batchUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.batchUrl = batchUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBatchUrl() {
        return batchUrl;
    }
}

