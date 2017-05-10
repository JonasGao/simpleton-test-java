package com.jonas.test.utils.time

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by jonas on 2017/4/19.
 */
fun main(args: Array<String>) {
    println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE))
}