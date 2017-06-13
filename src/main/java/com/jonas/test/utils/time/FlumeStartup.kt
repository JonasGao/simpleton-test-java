package com.jonas.test.utils.time

import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * test get delay to tomorrow first second
 * Created by jonas on 2017/6/13.
 */
fun main(args: Array<String>) {

    val utcZoneOffset = ZoneOffset.UTC

    val flumeStartupTime = LocalDateTime.of(2017, 6, 12, 16, 30, 0)

    val tomorrowUTCFirstSecond = flumeStartupTime
            .plusDays(1)
            .withHour(0)
            .withMinute(0)
            .withSecond(1)
            .withNano(0)
            .toInstant(utcZoneOffset)
            .toEpochMilli()

    val utcNow = flumeStartupTime.toInstant(utcZoneOffset).toEpochMilli()

    val delayTomorrowFirstSecond = tomorrowUTCFirstSecond - utcNow

    println("tomorrowUTCFirstSecond = $tomorrowUTCFirstSecond")
    println("utcNow = $utcNow")
    println("delayTomorrowFirstSecond = $delayTomorrowFirstSecond")
}