package com.jonas.test.executor

import java.time.LocalDateTime
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by jonas on 2017/4/17.
 */
fun main(args: Array<String>) {
    val executor = Executors.newSingleThreadScheduledExecutor()
    executor.scheduleWithFixedDelay({
        println(LocalDateTime.now())
        Thread.sleep(3000)
    }, 1L, 2L, TimeUnit.SECONDS)
}