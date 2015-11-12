package com.example.administrator.myapplication.API;

import com.example.administrator.myapplication.MODEL.MoselClass;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Administrator on 11/6/2015.
 */
public interface ApiClass {
     //@GET("/place/nearbysearch/json")
     @GET("/maps/api/place/nearbysearch/json")
     void getCurators(@Query("location") String location,
                     @Query("radius")String radius,
                     @Query("type")String types,
                     @Query("key")String key,Callback<MoselClass> cb);

//    @GET("/maps/api/place/photo")
//    void getPhoto(@Query("maxwidth")String maxwidth,
//            @Query("photoreference")String photoreference,
//            @Query("key")String key,Callback<MoselClass> cb);
                     }

