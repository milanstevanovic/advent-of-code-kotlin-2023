package Day03

import readInput

class Day03 {
    
    fun solvePartOne(input: List<String>): Int {
        val numbers = mutableSetOf<Int>()
        val height = input.size
        val width = input[0].length

        fun isAdjacentToSymbol(y: Int, startX: Int, endX: Int): Boolean {
            for (x in startX..endX) {
                for (dy in -1..1) {
                    for (dx in -1..1) {
                        if (dy == 0 && dx == 0) continue

                        val ny = y + dy
                        val nx = x + dx
                        if (ny in 0 until height && nx in 0 until width) {
                            if (input[ny][nx] != '.' && input[ny][nx] != ' ' && !input[ny][nx].isDigit()) {
                                return true
                            }
                        }
                    }
                }
            }
            return false
        }

        for (y in input.indices) {
            var x = 0
            while (x < width) {
                if (input[y][x].isDigit()) {
                    val startX = x
                    while (x < width && input[y][x].isDigit()) {
                        x++
                    }
                    val endX = x - 1
                    val number = input[y].substring(startX, x).toInt()

                    if (isAdjacentToSymbol(y, startX, endX)) {
                        numbers.add(number)
                    }
                } else {
                    x++
                }
            }
        }

        return numbers.sum()
    }

    fun checkPartOne(input: List<String>, expected: Int) {
        val actual = solvePartOne(input)
        check(actual == expected) {
            "Part One Check Failed: Expected $expected but got $actual"
        }
    }

    fun solvePartTwo(lines: List<String>): Int {

        return 0
    }

    fun checkPartTwo(input: List<String>, expected: Int) {
        val actual = solvePartTwo(input)
        check(actual == expected) {
            "Part Two Check Failed: Expected $expected but got $actual"
        }
    }
}

fun main() {
    val input = readInput("Day03/input")
    val day = Day03()
    println("Part One Result: ${day.solvePartOne(input)}")
    val test1 = readInput("Day03/test1")
    day.checkPartOne(test1, 4361)
//    println("Part Two Result: ${day.solvePartTwo(input)}")
//    val test2 = readInput("Day03/test2")
//    day.checkPartTwo(test2, 0)
}