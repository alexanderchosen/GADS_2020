package com.example.gads2020leaderboard.services;



import com.example.gads2020leaderboard.GadsRetrofitLeaders;
import com.example.gads2020leaderboard.GadsRetrofitSkills;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {
    @GET("/api/hours")
    Call<List<GadsRetrofitLeaders>> getAllLeaders();
    @GET("/api/skilliq")
    Call<List<GadsRetrofitSkills>> getALLSkills();
}
