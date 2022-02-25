package data_structures.using_arrays

import java.util.*

class Scoreboard(capacity: Int) {
    private var numEntries: Int = 0
    private val board: Array<GameEntry?> = arrayOfNulls(capacity);

    fun add(entry: GameEntry) {
        val newScore = entry.getScore()

        if (numEntries < board.size || newScore > board[numEntries - 1]!!.getScore()) {
            if (numEntries < board.size)
                numEntries++

            var j = numEntries - 1
            while (j > 0 && board[j - 1]!!.getScore() < newScore) {
                board[j] = board[j - 1]
                j--
            }
            board[j] = entry
        }
    }

    fun remove(index: Int): GameEntry? {
        if ( index< 0 || index >= numEntries)
            throw  IndexOutOfBoundsException("Invalid index $index")

        val tempEntry = board[index]
        for (i in 0 until numEntries)
            board[i] = board[i + 1]

        board[numEntries - 1] = null
        numEntries--
        return tempEntry
    }

    fun insertionSort(data: CharArray) {
        val n = data.size
        for (i in 0 until n) {
            val current = data[i]
            var j = i
            while (j > 0 && data[j - i] > current){
                data[j] = data[j-1]
                j--
            }
            data[j] = current
        }
    }
}