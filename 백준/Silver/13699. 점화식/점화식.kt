package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(36) {0L}

    dp[0] = 1L
    for(i in 1 .. 35){
        for(j in 0 until i){
            dp[i] += dp[j] * dp[i-j-1]
        }
    }
    println(dp[n])

}