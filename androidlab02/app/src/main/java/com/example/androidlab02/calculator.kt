package com.example.androidlab02

class Calculator() {
    var li = mutableListOf<Double>()

    private fun add(a: Double, b: Double) {
        li.add(a+b)
    }
    private fun subtract(a: Double, b: Double) {
        li.add(a-b)
    }
    private fun multiple(a: Double, b: Double) {
        li.add(a*b)
    }
    private fun division(a: Double, b: Double) {
        if(b==0.0) println("ERROR : number can not be divided with zero.")
        else li.add(a/b)
    }
    fun load() {
        for(i in 0 until li.size) println(li[i])
    }
    fun cal(a: Double, b: Double, type: String) {
        if(type=="add") add(a, b)
        else if(type=="subtract") subtract(a, b)
        else if(type=="multiple") multiple(a, b)
        else division(a, b)
    }
    fun print_calculated_number() {
        if(li.size == 0) println(0.0)
        else println(li.last())
    }
}

fun main() {
    var calculator = Calculator()
    calculator.cal(1.0, 2.0, "add")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0, 0.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "multiple")
    calculator.print_calculated_number()
    println("---------------------")
    calculator.load()
}