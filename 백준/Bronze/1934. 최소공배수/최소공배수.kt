package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        sb.append(lcm(a,b)).append("\n")
    }
    println(sb)

}

fun gcd(a: Int, b: Int): Int{
    return if (b == 0) a else gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int{
    return (a * b) / gcd (a,b)
}
