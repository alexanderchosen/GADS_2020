package com.example.gads2020leaderboard.services;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiPost {
        @Headers({
                "content-type:application/x-www-form-urlencoded"
        })
        @FormUrlEncoded
        @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
        Call<Void> savePost(

                @Field("entry.1877115667") String firstName,
                @Field("entry.2006916086") String lastName,
                @Field("entry.1824927963") String emailAddress,
                @Field("entry.284483984") String gitHubLink



        );
    }

