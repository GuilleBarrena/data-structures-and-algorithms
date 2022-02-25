package data_structures.reinforcement_exercies

/**
 * Give an implementation of the size( ) method for the SingularlyLinkedList class,
 * assuming that we did not maintain size as an instance variable.
 */
class R3_9 {
    class SinglyLinkedList<T> {
        private var head: Node<T>? = null
        private var tail: Node<T>? = null

        private var size = 0;

        // Access Methods
        fun isEmpty() = size === 0
        fun first() = if (isEmpty()) null else head!!.getElement()
        fun las() = if (isEmpty()) null else tail!!.getElement()

        /**
         * Exercise function size()
         */
        fun size(): Int {
            var size = 1
            if (head == null) size = 0
            else {
                var element = head
                while (element!!.getNext() != null) {
                    size++
                    element = element.getNext()
                }
            }
            return size
        }

        fun getSecondToLast(): T? {
            if (isEmpty()) return null

            // Only one element
            if (head == tail) return null

            // Check if next element is tail
            var element = head

            for(i in 0 until size) {
                if (element!!.getNext()!!.getNext() == null) return element.getElement()
                element = element.getNext()
            }

            return null
        }

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

    class Node<T> {
        private var element: T
        private var next: Node<T>?

        constructor(element: T, node: Node<T>?) {
            this.element = element
            this.next = node
        }

        fun getElement() = element
        fun getNext() = next
        fun setNext(node: Node<T>?) { this.next = node}
    }
}