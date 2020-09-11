package com.example.gads2020leaderboard;

import com.example.gads2020leaderboard.services.ApiPost;

public class ApiUtil {
    private  ApiUtil(){}
    private static final String BASE_URL="https://docs.google.com/forms/d/e/";
    public static  ApiPost getApiPost(){
        return RetroClassPost.getRetrofitInstancePost(BASE_URL).create(ApiPost.class);
    }
}

