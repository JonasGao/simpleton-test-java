package com.jonas.test.g2d

import java.awt.image.BufferedImage
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.imageio.ImageIO

/**
 * Created by jonas on 2017/6/15.
 */
fun main(args: Array<String>) {
    val image = ImageIO.read(File("/Users/jonas/Desktop/1.jpeg"))
    val bufferedWidth = 1200.0
    val bufferedHeight = 1200.0
    val width: Double
    val height: Double
    when {
        image.width > image.height -> {
            width = bufferedWidth
            height = image.height * (bufferedWidth / image.width)
        }
        image.width < image.height -> {
            width = image.width * (bufferedHeight / image.height)
            height = bufferedHeight
        }
        else -> {
            val length = if (bufferedHeight > bufferedWidth)
                bufferedWidth
            else
                bufferedHeight
            width = length
            height = length
        }
    }

    val bufferedImage = BufferedImage(bufferedWidth.toInt(), bufferedHeight.toInt(), BufferedImage.TYPE_INT_ARGB)
    val g2d = bufferedImage.graphics
    g2d.drawImage(image, 0, 0, width.toInt(), height.toInt(), null)
    g2d.dispose()
    val out: FileOutputStream
    try {
        out = FileOutputStream(File("/Users/jonas/Desktop/2.png"))
        ImageIO.write(bufferedImage, "png", out)//写图片
        out.close()
    } catch (e1: IOException) {
        e1.printStackTrace()
    }
}