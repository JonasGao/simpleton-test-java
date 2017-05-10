package com.jonas.test.json.jackson.dates

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.ObjectMapper
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

/**
 * 测试 Jackson 的时间序列化
 * Created by jonas on 2017/3/31.
 */

fun main1(args: Array<String>) {
    var model = Model2()
    val timestamp = LocalDateTime.now()
    model.created = Timestamp.valueOf(timestamp)
    val objectMapper = ObjectMapper()
    val json = objectMapper.writeValueAsString(model)
    println(json)
    println(timestamp)
    model = objectMapper.readValue(json, Model2::class.java)
    println(model.created)
}

fun main(args: Array<String>) {
    val json = """{"created":"2017-03-31 14:54:51"}"""
    val objectMapper = ObjectMapper()
    val model = objectMapper.readValue(json, Model1::class.java)
    println(model.created)

//    for (zone in TimeZone.getAvailableIDs(0)) {
//        println(zone)
//    }
}

class Model1 {

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    var created: Date? = null;
}

class Model2 {
    var created: Timestamp? = null;
}

class Model3 {
    var created: Instant? = null;
}