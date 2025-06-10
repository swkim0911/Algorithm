package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    for(i in 1 .. 5){
        val input = br.readLine().toInt()
        sum += if (input < 40) 40 else input
    }
    println(sum / 5)
}



