package com.jonas.test.utils.urlencode

import org.apache.commons.codec.net.URLCodec
import java.net.URLEncoder

/**
 * Created by jonas on 2017/4/27.
 */
fun main(args: Array<String>) {
    println(Charsets.UTF_8.name())
    println(Charsets.UTF_8.displayName())
    println(URLEncoder.encode("a   b", "UTF-8"))
    println(URLCodec().encode("a   b", "GBK"))
}