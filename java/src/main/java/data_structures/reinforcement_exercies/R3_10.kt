package data_structures.reinforcement_exercies

import data_structures.linked_lists.Node

/**
 * Give an implementation of the size( ) method for the SingularlyLinkedList class,
 * assuming that we did not maintain size as an instance variable.
 */
class R3_10 {
    class CircularlyLinkedList<T> {
        private var tail: Node<T>? = null
        private var size = 0

        // Access methods
        private fun isEmpty() = size === 0

        fun getFirst() = if (isEmpty()) null else tail!!.getNext()!!.getElement()
        fun getLast() = if (isEmpty()) null else tail!!.getElement()

        /**
         * Exercise function
         */
        fun size(): Int {
            var size = 1
            if (tail == null) size = 0
            else if (tail!!.getNext() == null) size = 1
            else {
                var element = tail
                while (element!!.getNext() != tail) {
                    size++
                    element = element.getNext()
                }
            }
            return size
        }

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
                this.tail!!.setNext(Node(element, this.tail!!.getNext()))
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
}