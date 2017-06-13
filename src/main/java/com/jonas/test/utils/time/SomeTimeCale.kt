package com.jonas.test.utils.time

import java.sql.Timestamp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * 测试时间计算
 * Created by jonas on 2017/4/17.
 */
fun main(args: Array<String>) {
    val a = System.currentTimeMillis()
    val b = getTimeMillis("00:00:01")
    val time = a - b
    println(Date(a))
    println(Date(b))
    @Suppress("DEPRECATION")
    println(Timestamp(time).minutes)

    val c = LocalDateTime.now()
            .withHour(0)
            .withMinute(0)
            .withSecond(1)
            .withNano(0)

    val d = c
            .toInstant(ZoneOffset.ofHours(8))
            .toEpochMilli()

    val e = c
            .toInstant(ZoneOffset.UTC)
            .toEpochMilli()

//    val f = LocalDateTime.now()
//            .atOffset(ZoneOffset.UTC)
//            .withHour(0)
//            .withMinute(0)
//            .withSecond(1)
//            .withNano(0)
//            .toEpochSecond()

    val g = LocalDateTime.now()
            .atOffset(ZoneOffset.UTC)
            .withHour(0)
            .withMinute(0)
            .withSecond(1)
            .withNano(0)
            .toInstant()
            .toEpochMilli()

    println("b = $b")
    println("c = $c")
    println("d = $d")
    println("e = $e")
//    println("f = $f")
    println("g = $g")
}

private fun getTimeMillis(time: String): Long {
    try {
        val dateFormat = SimpleDateFormat("yy-MM-dd HH:mm:ss")
        val dayFormat = SimpleDateFormat("yy-MM-dd")
        val curDate = dateFormat.parse(dayFormat.format(Date()) + " " + time)
        return curDate.time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return 0
}