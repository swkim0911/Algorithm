package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        if(a == 0 && b == 0) break
        if(a > b){
            sb.append("Yes\n")
        }else{
            sb.append("No\n")
        }
    }
    println(sb)

}



