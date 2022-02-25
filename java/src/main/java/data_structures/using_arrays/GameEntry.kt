package data_structures.using_arrays

class GameEntry {
    private var name: String
    private var score: Int

    constructor(n: String, s: Int) {
        name = n
        score = s
    }

    fun getName() = name
    fun getScore()= score
}

