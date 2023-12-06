package Day02
import readInput

class Day02() {

    fun solvePartOne(lines: List<String>): Int {
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
        return sum
    }

    fun checkPartOne(input: List<String>, expected: Int) {
        val actual = solvePartOne(input)
        check(actual == expected) {
            "Part One Check Failed: Expected $expected but got $actual"
        }
    }

    fun solvePartTwo(lines: List<String>): Int {
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
        return sum
    }

    fun checkPartTwo(input: List<String>, expected: Int) {
        val actual = solvePartTwo(input)
        check(actual == expected) {
            "Part Two Check Failed: Expected $expected but got $actual"
        }
    }
}

fun main() {
    val input = readInput("Day02/input")
    val day = Day02()
    println("Part One Result: ${day.solvePartOne(input)}")
    println("Part Two Result: ${day.solvePartTwo(input)}")
    val test1 = readInput("Day02/test1")
    day.checkPartOne(test1, 8)
    val test2 = readInput("Day02/test2")
    day.checkPartTwo(test2, 2286)
}