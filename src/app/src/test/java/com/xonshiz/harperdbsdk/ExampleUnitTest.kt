package com.xonshiz.harperdbsdk

import org.junit.Test

import org.junit.Assert.*
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val instanceLink = "https://sdktest-xonshiz.harperdbcloud.com/"
    val username = "test_user"
    val password = "GuessMe24!"
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun createHarperDBInstance(){
        val value: HarperDB = HarperDB(URL(""), "", "");
        print(value.errorMessage)
        value.errorMessage = "bla bla"
        print(value.errorMessage)
    }

    @Test
    fun createDevSchema(){
        val value: HarperDB = HarperDB(URL(this.instanceLink), this.username, this.password);
        val response = value.createDevSchema("KotlinDevSchema")
        print("Response: $response")
    }

    @Test
    fun createTable(){
        val value: HarperDB = HarperDB(URL(this.instanceLink), this.username, this.password);
        val response = value.createTable("KotlinDevSchema", "newDoggo")
        print("Response: $response")
    }

    @Test
    fun insertRecord(){
        var records: ArrayList<record> = ArrayList()
        records.add(record("Mark Kotlin", "Kotlin Bark"))
        val value: HarperDB = HarperDB(URL(this.instanceLink), this.username, this.password);
        val response = value.insertRecord("KotlinDevSchema", "newDoggo", records)
        print("Response: $response")
    }

    @Test
    fun updateRecord(){
        var records: ArrayList<record> = ArrayList()
        records.add(record("Mark Kotlin 1", "Kotlin Bark 1", "e12b54f7-39ed-4a93-b645-ff3772da7827"))
        val value: HarperDB = HarperDB(URL(this.instanceLink), this.username, this.password);
        val response = value.updateRecord("KotlinDevSchema", "newDoggo", records)
        print("Response: $response")
    }

    @Test
    fun sqlAction(){
        val value: HarperDB = HarperDB(URL(this.instanceLink), this.username, this.password);
        val response = value.sqlAction("SELECT * FROM KotlinDevSchema.newDoggo")
        print("Response: $response")
    }
}


data class record(
    val name: String,
    val work: String,
    val id: String = ""
)