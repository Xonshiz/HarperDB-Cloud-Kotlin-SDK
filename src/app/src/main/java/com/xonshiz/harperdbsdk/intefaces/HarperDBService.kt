package com.xonshiz.harperdbsdk.intefaces

import com.xonshiz.harperdbsdk.models.*
import com.xonshiz.harperdbsdk.models.createSchema
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface HarperDbService {
    @POST("/")
    fun createSchema(@Header("Authorization") authorization: String, @Body createSchema: createSchema): Call<CreateSchemaResponse>

    @POST("/")
    fun createDogTableCall(@Header("Authorization") authorization: String, @Body createDogTable: createDogTableOb): Call<CreateDogTaleResponse>

    @POST("/")
    fun insertDogsCall(@Header("Authorization") authorization: String, @Body insertDogs: insertDogsOb): Call<CreateDogTaleResponse>

    @POST("/")
    fun sqlCall(@Header("Authorization") authorization: String, @Body sqlActionsOb: sqlActionsOb): Call<CreateDogTaleResponse>
}