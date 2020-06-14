package com.xonshiz.harperdbsdk.models

import java.util.*

data class insertDogsOb(
    val operation: String,
    val schema: String,
    val table: String,
    val records: ArrayList<*>
)