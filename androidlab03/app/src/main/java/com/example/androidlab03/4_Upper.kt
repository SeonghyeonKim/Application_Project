package com.example.androidlab03

import java.lang.Exception

fun change(string: String): String {
    try{
        for(i in 0 until string.length) {
            if(string[i] < 'a' || string[i] > 'z') string.toInt()
        }
        return string.uppercase()
    }
    catch(e: Exception) {
        var temp = ""

        for(i in 0 until string.length) {
            if(string[i] < 'a' || string[i] > 'z') temp = temp + string[i]
        }

        return "error with = ${temp}"
    }
}


fun main() {
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}