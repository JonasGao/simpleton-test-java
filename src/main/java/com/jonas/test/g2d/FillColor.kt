package com.jonas.test.g2d

import java.awt.Color
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.imageio.ImageIO

/**
 * Created by jonas on 2017/6/15.
 */
fun main(args: Array<String>) {
    val image = ImageIO.read(File("/Users/jonas/Desktop/1.png"))
    val g2d = image.graphics
    g2d.color = Color(244, 65, 65, 257)
    g2d.fillRect(0, 0, image.width, image.height)
    g2d.dispose()
    val out: FileOutputStream
    try {
        out = FileOutputStream(File("/Users/jonas/Desktop/2.png"))
        ImageIO.write(image, "png", out) //写图片
        out.close()
    } catch (e1: IOException) {
        e1.printStackTrace()
    }
}