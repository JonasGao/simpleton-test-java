package com.jonas.test.utils.io

import java.io.File

/**
 * Created by jonas on 2017/4/19.
 */
fun main(args: Array<String>) {
    val path1 = "/Users/jonas/"
    val path2 = "Desktop/temp/a/b/c"

    val file = File(path1, path2)

//    println(file.mkdirs())
    println(file.mkdir())
}