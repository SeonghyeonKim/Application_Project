package com.example.androidlab02

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var N = readLine().toInt()

    var T = IntArray(N + 10)
    var P = IntArray(N + 10)
    var dp = IntArray(N + 10)

    var max = 0;

    for (i in 0 until N) {
        var(a, b) = readLine()!!.split(" ").map{it.toInt()}
        T[i] = a
        P[i] = b
    }

    for (i in 0 until N) {
        if(i+T[i] <= N+1) dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i])
        dp[i+1] = Math.max(dp[i+1], dp[i])
    }

    for (i in 0 until N) max = Math.max(max, dp[i])

    println(max)

    close()
}