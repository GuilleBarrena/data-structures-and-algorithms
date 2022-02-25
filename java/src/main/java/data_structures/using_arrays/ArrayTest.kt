package data_structures.using_arrays

import java.util.*


class ArrayTest

fun main(args: Array<String>) {
    val data = IntArray(10)
    val rand = Random()

    // a pseudo-random number generator
    rand.setSeed(System.currentTimeMillis())

    for (i in data.indices) data[i] = rand.nextInt(100)
    // the next pseudo-random number
    val orig = data.copyOf(data.size) // make a copy of the data array
    println("arrays equal before sort: " + data.contentEquals(orig))
    Arrays.sort(data)
    // sorting the data array (orig is unchanged)
    println("arrays equal after sort: " + data.contentEquals(orig))
    println("orig = " + orig.contentToString())
    println("data = " + data.contentToString())
}
