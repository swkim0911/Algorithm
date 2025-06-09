package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (A, I) = br.readLine().split(" ").map {
        it.toInt()
    }
    println(A * (I - 1) + 1)
}