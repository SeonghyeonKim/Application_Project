package com.example.androidlab03

import java.lang.Exception
import java.util.*

val sc: Scanner = Scanner(System.`in`)
val menu = arrayOf("참깨라면이", "햄버거가", "콜라가", "핫바가", "초코우유가")
var flag = 0

class vending() {
    fun printMenu() {
        println("""============== MENU ==============
            || (1) 참깨라면   - 1,000원    |
            || (2) 햄버거     - 1,500원    |
            || (3) 콜라      -   800원    |
            || (4) 핫바      - 1,200원    |
            || (5) 초코우유   - 1,500원    |
        """.trimMargin())
    }

    fun getChange(num: Int, money: Int) {
        println("감사합니다. 잔돈반환:${money-getPrice(num)}")
    }

    fun getCoin(num: Int) {
        println("${menu[num-1]} 선택되었습니다.")

        while(true) {
            try {
                println("Insert coin")
                var money = sc.nextLine().toInt()
                println("${money} 원을 넣었습니다.")

                if(money < getPrice(num)) {
                    println("현금이 부족합니다.")
                }
                else {
                    getChange(num, money)
                }

                flag = 1
                return
            }
            catch (e: Exception) {
                println("""돈을 넣지 않았습니다.
                    |다시 돈을 넣어주세요.
                """.trimMargin())
            }
        }
    }

    fun getMenu(): Int {
        println("Choose menu:")
        var num: String? = sc.nextLine()

        try {
            return num!!.toInt()
        }
        catch(e: Exception) {
            return 0
        }
    }

    fun getPrice(num: Int): Int {
        when(num) {
            1 -> return 1000
            2, 5 -> return 1500
            3 -> return 800
            4 -> return 1200
            else -> return 0
        }
    }
}

fun main() {
    var vd = vending()
    while(true) {
        vd.printMenu()

        var op = vd.getMenu()

        when(op) {
            1,2,3,4,5 -> vd.getCoin(op)
            else -> println("""아무것도 선택되지 않았습니다.
                            |다시 선택해주세요.""".trimMargin())
        }

        if(flag==1) break
    }
}
