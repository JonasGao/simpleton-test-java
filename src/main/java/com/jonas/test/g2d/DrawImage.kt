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
    val image = ImageIO.read(File("/Users/jonas/Desktop/1.png"))
    val bufferedWidth = 1200.0
    val bufferedHeight = 1200.0
    val width: Double
    val height: Double
    val x: Double
    val y: Double
    when {
        image.width > image.height -> {
            width = bufferedWidth
            height = image.height * (bufferedWidth / image.width)
            x = 0.0
            y = Math.abs(bufferedHeight - height) / 2
        }
        image.width < image.height -> {
            width = image.width * (bufferedHeight / image.height)
            height = bufferedHeight
            x = 0.0
            y = Math.abs(bufferedWidth - width) / 2
        }
        else -> {
            val length: Double
            if (bufferedHeight > bufferedWidth) {
                length = bufferedWidth
                x = 0.0
                y = Math.abs(bufferedHeight - bufferedWidth) / 2
            } else {
                length = bufferedHeight
                x = Math.abs(bufferedHeight - bufferedWidth) / 2
                y = 0.0
            }
            width = length
            height = length
        }
    }


    val bufferedImage = BufferedImage(bufferedWidth.toInt(), bufferedHeight.toInt(), BufferedImage.TYPE_INT_ARGB)
    val g2d = bufferedImage.graphics
    g2d.drawImage(image, x.toInt(), y.toInt(), width.toInt(), height.toInt(), null)
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