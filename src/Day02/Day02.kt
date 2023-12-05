package Day02
import Day01.Day01
import readInput

class Day02(private val input: List<String>, private val testOneInput: List<String>, private val testTwoInput: List<String>) {

    fun solvePartOne(lines: List<String> = input): Int {
        var sum = 0
        for (line in lines) {
            val gameID = line.substringAfter("Game ").substringBefore(":").trim().toInt()
            val rounds = line.substringAfter(":").split(";").map { it.trim() }
            var blue = 0
            var red = 0
            var green = 0
            rounds.forEach { round ->
                val colorCounts = round.split(", ").associate {
                    val (count, color) = it.split(" ")
                    color to count.toInt()
                }
                blue = maxOf(blue, colorCounts["blue"] ?: 0)
                red = maxOf(red, colorCounts["red"] ?: 0)
                green = maxOf(green, colorCounts["green"] ?: 0)
            }
            if (red <= 12 && green <= 13 && blue <= 14) {
                sum += gameID
            }
        }
        return  sum
    }

    fun testPartOne(expected: Int = 8) {
        val actual = solvePartOne(testOneInput)
        check(actual == expected) {
            "Part One Test Failed: Expected $expected but got $actual"
        }
    }

    fun solvePartTwo(lines: List<String> = input): Int {
        var sum = 0
        for (line in lines) {
            val gameID = line.substringAfter("Game ").substringBefore(":").trim().toInt()
            val rounds = line.substringAfter(":").split(";").map { it.trim() }
            var blue = 0
            var red = 0
            var green = 0
            rounds.forEach { round ->
                val colorCounts = round.split(", ").associate {
                    val (count, color) = it.split(" ")
                    color to count.toInt()
                }
                blue = maxOf(blue, colorCounts["blue"] ?: 0)
                red = maxOf(red, colorCounts["red"] ?: 0)
                green = maxOf(green, colorCounts["green"] ?: 0)
            }
            sum += red * green * blue
        }
        return  sum
    }

    fun testPartTwo(expected: Int = 2286) {
        val actual = solvePartTwo(testTwoInput)
        check(actual == expected) {
            "Part One Test Failed: Expected $expected but got $actual"
        }
    }
}

fun main() {
    val day = Day02(readInput("Day02/input"), readInput("Day02/test1"), readInput("Day02/test2"))
    println("Part One: ${day.solvePartOne()}")
    println("Part Two: ${day.solvePartTwo()}")
    day.testPartOne()
    day.testPartTwo()
}