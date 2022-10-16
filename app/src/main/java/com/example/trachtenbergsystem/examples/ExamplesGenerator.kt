package com.example.trachtenbergsystem.examples

import com.github.keelar.exprk.Expressions
import kotlin.math.pow

// Todo
// 1. Throw exceptions correctly (or validate data somehow else)

class ExamplesGenerator {
    fun generate(type: ExampleType, size: Int, min_dif: Int, max_dif: Int) : ArrayList<List<Any>> {
        // if (min_dif < 1) throw IllegalArgumentException("Minimum difficulty can't be less than 1")
        // if (min_dif < max_dif) throw IllegalArgumentException("Maximum difficulty should be more than minimum difficulty")

        val list : ArrayList<List<Any>> = ArrayList()
        var dif = 0
        var num = 0
        var example = ""

        for (i in 0 until size) {
            when (type) {
                ExampleType.ELEVEN -> {
                    // Choose random difficulty
                    dif = (min_dif..max_dif).random()

                    // Generate a number according to give difficulty
                    num = (10.0.pow(dif).toInt() .. 10.0.pow(dif + 1).toInt()).random()

                    // Push example and answer to it to the list
                    example = "$num * 11"
                    list.add(ArrayList(listOf(example, Expressions().eval(example).toString())))
                }
            }
        }

        return list
    }
}