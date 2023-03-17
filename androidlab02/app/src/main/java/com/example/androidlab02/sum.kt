package com.example.androidlab02

import java.util.*

fun main() {
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()

    val sc: Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for (i: Int in 0..num-1 step(1)) {
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for (i: Int in 0..num-1 step(1)) {
        print("Pairs for "+pairList[i].toString()+ " : ")

        var a = 1
        var b = pairList[i] - 1

        while(a < b) {
            if(a!=1) print(",")
            print("("+a.toString()+" "+b.toString()+")")
            a = a+1
            b = b-1
        }
        println()
    }
}