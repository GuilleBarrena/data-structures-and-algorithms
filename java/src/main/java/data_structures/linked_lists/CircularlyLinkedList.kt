package data_structures.linked_lists

class CircularlyLinkedList<T> {
    private var tail: Node<T>? = null
    private var size = 0

    // Access methods
    private fun isEmpty() = size === 0

    fun getFirst() = if (isEmpty()) null else tail!!.getNext()!!.getElement()
    fun getLast() = if (isEmpty()) null else tail!!.getElement()

    // Update methods
    fun rotate() {
        if (this.tail != null)
            this.tail = this.tail!!.getNext()
    }

    fun addFirst(element: T) {
        if (isEmpty()) {
            this.tail = Node(element, null)
            this.tail!!.setNext(this.tail!!)
        } else {
            val newest = Node(element, this.tail!!.getNext())
            this.tail!!.setNext(newest)
        }
        size++
    }

    fun addLast(element: T) {
        addFirst(element)
        tail = tail!!.getNext()
    }

    fun removeFirst(): T? {
        if (isEmpty())
            return null

        val head = tail!!.getNext()

        if (head === tail) tail = null
        else tail!!.setNext(head!!.getNext())
        size--
        return head!!.getElement()
    }
}