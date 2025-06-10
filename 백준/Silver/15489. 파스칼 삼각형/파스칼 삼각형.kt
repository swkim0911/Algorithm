package org.example

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r,c,w) = br.readLine().split(" ").map{ it.toInt()}
    val dp =  Array(30) {IntArray(30)}
    // 초기화
    dp[1][1] = 1
    for(i in 2 until 30){
        for(j in 1 .. i){
            if(j == 1){
                dp[i][j] = 1
            }else if(j == i){
                dp[i][j] = 1
            }else{
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            }
        }
    }
    var answer:Long = 0L
    for(i in r until r+w){
        for(j in c .. c + (i - r)){
            answer += dp[i][j]
        }
    }
    println(answer)
}
