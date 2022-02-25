package data_structures.reinforcement_exercies

import kotlin.random.Random
import kotlin.random.nextInt

class R3_2 {

    private fun generateRandomArray(size: Int) = Array<Int>(size) { Random.nextInt() }

    private fun deleteRandomEntry(array: Array<Int>) {
        val entry = Random.nextInt(array.size)
        array.drop(entry)
        println("Deleted entry $entry")
    }

    fun main(args: Array<String>) {
        var NUMBER_ENTRIES = 100;
        val array = generateRandomArray(NUMBER_ENTRIES)

        while (NUMBER_ENTRIES >= 0) {
            deleteRandomEntry(array);
            NUMBER_ENTRIES--
        }
    }
}
