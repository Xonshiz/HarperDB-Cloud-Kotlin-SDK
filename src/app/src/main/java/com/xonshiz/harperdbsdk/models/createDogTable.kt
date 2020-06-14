package com.xonshiz.harperdbsdk.models

data class createDogTableOb(
    val operation: String,
    val schema: String,
    val table: String,
    val hash_attribute: String
)