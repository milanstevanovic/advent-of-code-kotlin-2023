package Day01
import readInput

class Day01(private val input: List<String>, private val testOneInput: List<String>, private val testTwoInput: List<String>) {

    private fun calibrationValue(line: String): Int {
        val digits = line.filter { it.isDigit() }
        return if (digits.isNotEmpty()) "${digits.first()}${digits.last()}".toInt() else 0
    }

    fun solvePartOne(lines: List<String> = input): Int {
        return lines.sumOf { calibrationValue(it) }
    }

    fun testPartOne(expected: Int = 142) {
        val actual = solvePartOne(testOneInput)
        check(actual == expected) {
            "Part One Test Failed: Expected $expected but got $actual"
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

    fun solvePartTwo(lines: List<String> = input): Int {
        return lines.sumOf { row: String ->
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

    fun testPartTwo(expected: Int = 281) {
        val actual = solvePartTwo(testTwoInput)
        check(actual == expected) {
            "Part Two Test Failed: Expected $expected but got $actual"
        }
    }
}

fun main() {
    val day = Day01(readInput("Day01/input"), readInput("Day01/test1"), readInput("Day01/test2"))
    println("Part One: ${day.solvePartOne()}")
    println("Part Two: ${day.solvePartTwo()}")
    day.testPartOne()
    day.testPartTwo()
}
