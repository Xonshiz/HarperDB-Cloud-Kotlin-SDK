package com.xonshiz.harperdbsdk

import com.xonshiz.harperdbsdk.intefaces.*
import com.xonshiz.harperdbsdk.models.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.util.Base64


class HarperDB (val instanceLink: URL, val username: String, val password: String): HarperDBResponse() {

    override var errorMessage: String = ""
    var response: String = ""

    init {
        if (instanceLink.host == "" || username.trim() == "" || password.trim() == ""){
            this.errorMessage = "A Property Is Missing."
        }
    }

    private fun getBasicAuth(): String {
        val headerString = this.username + ":" + this.password
        return "Basic " + Base64.getEncoder().encodeToString(headerString.toByteArray());
    }

    fun createDevSchema(schemaName: String): String {
        if(schemaName.trim() == "")
            return ""
        val encodedString: String = getBasicAuth()
        val retrofit = Retrofit.Builder()
            .baseUrl(instanceLink.toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HarperDbService::class.java)
        val call = service.createSchema(encodedString, createSchema("create_schema", schemaName))
        val result = call.execute().body()
        return result.message
    }

    fun createTable(schemaName: String, tableName: String, hashAttribute: String = "id"): String {
        if(schemaName.trim() == "" || tableName.trim() == "")
            return ""
        val encodedString: String = getBasicAuth()
        val retrofit = Retrofit.Builder()
            .baseUrl(instanceLink.toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HarperDbService::class.java)
        val call = service.createDogTableCall(encodedString, createDogTableOb("create_table", schemaName, tableName, hashAttribute))
        val result = call.execute().body()
        return result.message
    }

    fun insertRecord(schemaName: String, tableName: String, records: ArrayList<*>): String {
        if(schemaName.trim() == "" || tableName.trim() == "" || records.isEmpty())
            return ""
        val encodedString: String = getBasicAuth()
        val retrofit = Retrofit.Builder()
            .baseUrl(instanceLink.toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HarperDbService::class.java)
        val call = service.insertDogsCall(encodedString, insertDogsOb("insert", schemaName, tableName, records))
        val result = call.execute().body()
        return result.message
    }

    fun updateRecord(schemaName: String, tableName: String, records: ArrayList<*>): String {
        if(schemaName.trim() == "" || tableName.trim() == "" || records.isEmpty())
            return ""
        val encodedString: String = getBasicAuth()
        val retrofit = Retrofit.Builder()
            .baseUrl(instanceLink.toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HarperDbService::class.java)
        val call = service.insertDogsCall(encodedString, insertDogsOb("update", schemaName, tableName, records))
        val result = call.execute().body()
        return result.message
    }

    fun sqlAction(sql: String): String {
        if(sql.trim() == "")
            return ""
        val encodedString: String = getBasicAuth()
        val retrofit = Retrofit.Builder()
            .baseUrl(instanceLink.toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HarperDbService::class.java)
        val call = service.sqlCall(encodedString, sqlActionsOb("sql", sql))
        val result = call.execute().body()
        return result.message
    }
}