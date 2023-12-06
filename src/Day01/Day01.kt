package Day01
import readInput

class Day01() {

    private fun calibrationValue(line: String): Int {
        val digits = line.filter { it.isDigit() }
        return if (digits.isNotEmpty()) "${digits.first()}${digits.last()}".toInt() else 0
    }

    fun solvePartOne(input: List<String>): Int {
        return input.sumOf { calibrationValue(it) }
    }

    fun checkPartOne(input: List<String>, expected: Int) {
        val actual = solvePartOne(readInput("Day01/test1"))
        check(actual == expected) {
            "Part One Check Failed: Expected $expected but got $actual"
        }
    }

    private val words: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    private fun String.possibleWordsAt(startingAt: Int): List<String> =
        (3..5).map { len: Int ->
            substring(startingAt, (startingAt + len).coerceAtMost(length))
        }

    fun solvePartTwo(input: List<String>): Int {
        return input.sumOf { row: String ->
            calibrationValue(
                row.mapIndexedNotNull { index: Int, c: Char ->
                    if (c.isDigit()) c
                    else
                        row.possibleWordsAt(index).firstNotNullOfOrNull { candidate: String ->
                            words[candidate]
                        }
                }.joinToString()
            )
        }
    }

    fun checkPartTwo(input: List<String>, expected: Int) {
        val actual = solvePartTwo(readInput("Day01/test2"))
        check(actual == expected) {
            "Part Two Check Failed: Expected $expected but got $actual"
        }
    }
}

fun main() {
    val input = readInput("Day01/input")
    val day = Day01()
    println("Part One Result: ${day.solvePartOne(input)}")
    println("Part Two Result: ${day.solvePartTwo(input)}")
    val test1 = readInput("Day01/test1")
    day.checkPartOne(test1, 142)
    val test2 = readInput("Day01/test2")
    day.checkPartTwo(test2, 281)
}
