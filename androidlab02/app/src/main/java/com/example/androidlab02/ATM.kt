package com.example.androidlab02

enum class Grade {A, B, C, D, E, F}
class MyAccount(val name: String, var money: Int, var g: Grade) {
    fun printAccount() {
        println("""계좌정보는 다음과 같습니다
|이름:      ${name} 
|계좌잔액:   ${money}
|신용등급:   ${g} 
-------------------
        """.trimIndent())
    }
    fun Deposite() {
        println("입금하실 금액을 말하세요.")
        var a = readLine()!!.toInt()
        money = money + a
        if(g==Grade.F && money>=0) println("동결계좌가 열렸습니다.")
        if(g!=Grade.A && money>=0) upGrade()
        println("${a} 원을 입금하였습니다. 잔액 : ${money}")
    }
    fun WithDraw() {
        println("출금하실 금액을 말하세요.")
        var a = readLine()!!.toInt()
        money = money - a
        if(money<-1000) {
            money = money + a
            println("잔액 부족입니다.")
            return
        }

        if(money<0) println("계좌가 마이너스 되었습니다.")

        if(g==Grade.F) println("""최저 등급의 신용을 가지고 있습니다.
            |계좌가 동결됩니다.""".trimMargin())
        else if(g!=Grade.F && money<0 && money>=-1000) {
            downGrade()
        }

        println("${a} 원을 출금하였습니다. 잔액 : ${money}")
    }
    fun downGrade() {
        var temp = g;
        if(g == Grade.A) g = Grade.B
        else if(g == Grade.B) g = Grade.C
        else if(g == Grade.C) g = Grade.D
        else if(g == Grade.D) g = Grade.E
        else if(g == Grade.E) g = Grade.F

        println("신용등급이 '${temp}->${g}'로 한단계 떨어집니다.")
    }
    fun upGrade() {
        var temp = g;
        if(g == Grade.B) g = Grade.A
        else if(g == Grade.C) g = Grade.B
        else if(g == Grade.D) g = Grade.C
        else if(g == Grade.E) g = Grade.D
        else if(g == Grade.F) g = Grade.E

        println("신용등급이 '${temp}->${g}'로 한단계 상승합니다.")
    }
}

fun main() {
    var account = MyAccount("Kim", 0, Grade.C)
    var cnt = 0;

    while(true) {
        println("""----선택하세요----
            ||(I) 계좌정보    |
            ||(D) 입금       |
            ||(W) 출금       |
            ||(E) 종료       |
            |----------------
        """.trimMargin()
        )

        var s = readLine()


        if(s=="I") account.printAccount()
        else if(s=="D") {
            account.Deposite()
            if(account.money>=0) cnt=0
        }
        else if(s=="W") {
            if(account.g == Grade.F) cnt+=1

            if(account.g!=Grade.F || cnt<2) {
                account.WithDraw()
            }
            else {
                println("동결된 계좌에서 출금하실 수 없습니다.")
            }
        }
        else if(s=="E") break
    }
}

