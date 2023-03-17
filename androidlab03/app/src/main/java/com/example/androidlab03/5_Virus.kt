package com.example.androidlab03

import java.util.*

var N: Int = 0
var M: Int = 0
var map = Array<Array<Int>> (0, {Array<Int>(0, {0})})
val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
val dy: Array<Int> = arrayOf(0, 0, -1, 1)

fun makeWall(map: Array<Array<Int>>, cnt: Int): Int {
    if(cnt == 3) return check(map)

    var safe = -1
    for(i in 0 until N) {
        for(j in 0 until M) {
            if(map[i][j]==0) {
                map[i][j] = 1
                safe = Math.max(makeWall(map, cnt+1), safe)
                map[i][j] = 0
            }
        }
    }

    return safe
}

fun check(map: Array<Array<Int>>): Int {
    var area = 0
    var backup = copy(map)

    for(i in 0 until N) {
        for(j in 0 until M) {
            if(backup[i][j]==2) {
                virus(backup, i, j)
            }
        }
    }

    for(i in 0 until N) {
        for(j in 0 until M) {
            if(backup[i][j]==0) area++
        }
    }

    return area
}

fun copy(map: Array<Array<Int>>): Array<Array<Int>> {
    var newMap = Array<Array<Int>>(N, {Array<Int>(M, {0})})

    for(i in 0 until N) {
        for(j in 0 until M) {
            newMap[i][j] = map[i][j]
        }
    }

    return newMap
}

fun virus(map: Array<Array<Int>>, x: Int, y: Int) {
    for(i in 0 until 4) {
        var nextX = x + dx[i]
        var nextY = y + dy[i]

        if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && map[nextX][nextY]==0) {
            map[nextX][nextY] = 2
            virus(map, nextX, nextY)
        }
    }
}

fun main() {
    var sc = Scanner(System.`in`)

    N = sc.nextInt()
    M = sc.nextInt()

    map = Array<Array<Int>> (N, {Array<Int>(M, {0})})

    for(i in 0 until N) {
        for(j in 0 until M) {
            map[i][j] = sc.nextInt()
        }
    }

    println(makeWall(map, 0))
}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
*/