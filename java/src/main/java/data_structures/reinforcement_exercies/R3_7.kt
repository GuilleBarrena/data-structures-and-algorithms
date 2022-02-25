package data_structures.reinforcement_exercies

import data_structures.linked_lists.Node

/**
 * Consider the implementation of CircularlyLinkedList.addFirst, in Code Fragment
 * 3.16. The else body at lines 39 and 40 of that method relies on a locally
 * declared variable, newest. Redesign that clause to avoid use of any local variable.
 */
class R3_7 {


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