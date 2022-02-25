package data_structures.linked_lists

class SinglyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size = 0;

    // Access Methods
    fun isEmpty() = size === 0
    fun first() = if (isEmpty()) null else head!!.getElement()
    fun las() = if (isEmpty()) null else tail!!.getElement()

    // Update Methods
    fun addFirst(element: T) {
        head = Node(element, this.head);
        if (isEmpty())
            tail = head;

        size++
    }

    fun addLast(element: T) {
        val newest = Node(element, this.tail)
        if (isEmpty())
            head = newest
        else
            tail!!.setNext(newest)
        tail = newest
        size++
    }
}