package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t = br.readLine().toInt()
    val answer = buildString {
        repeat(t) {
            val tokens = br.readLine().split(" ")
            var result = tokens[0].toFloat()

            for(token in tokens.drop(1)){
                when (token) {
                    "@" -> result *= 3
                    "%" -> result += 5
                    else -> result -= 7
                }
            }
            append("%.2f\n".format(result))
        }
    }
    println(answer)
}