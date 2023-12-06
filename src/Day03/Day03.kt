package Day03
import readInput

class Day03 {

    fun solvePartOne(lines: List<String>): Int {

        return 0
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
    println("Part Two Result: ${day.solvePartTwo(input)}")
    val test1 = readInput("Day03/test1")
    day.checkPartOne(test1, 0)
    val test2 = readInput("Day03/test2")
    day.checkPartTwo(test2, 0)
}