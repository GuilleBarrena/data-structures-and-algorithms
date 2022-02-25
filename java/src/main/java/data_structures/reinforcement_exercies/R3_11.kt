package data_structures.reinforcement_exercies

/**
 * Give an implementation of the size( ) method for the DoublyLinkedList class
 * assuming that we did not maintain size as an instance variable.
 */
class R3_11 {
    class DoublyLinkedList<E> {
        //---------------- nested Node class ----------------
        private class Node<E>(e: E?, p: Node<E>?, n: Node<E>?) {
            private var element = e; // reference to the element stored at this node
            private var prev = p; // reference to the previous node in the list
            private var next = n; // reference to the subsequent node in the list

            // Getters
            public fun getElement() = element
            public fun getPrev() = prev
            public fun getNext() = next

            // Setters
            public fun setPrev(p: Node<E>) {
                prev = p
            }

            public fun setNext(n: Node<E>) {
                next = n
            }
        } //----------- end of nested Node class -----------


        // instance variables of the DoublyLinkedList
        private var header = Node<E>(null, null, null) ; // header sentinel
        private var trailer = Node <E> (null, header, null); // trailer sentinel
        private var size = 0; // number of elements in the list

        // Constructs a new empty list.
        constructor() {
            header.setNext(trailer)
        }

        // Returns the number of elements in the linked list.
        fun size() = size

        /**
         * Exercise function
         */
        fun sizeExercise(): Int {
            var elNumber = 0

            if (trailer.getPrev() == header) elNumber = 0
            else {
                var element = header
                while (element.getNext()!!.getNext() != null) {
                    elNumber++
                    element = element.getNext()!!
                }
            }

            return elNumber
        }

        // Tests whether the linked list is empty.
        fun isEmpty() = size == 0

        // Returns (but does not remove) the first element of the list.
        fun first() = if (isEmpty()) null else header.getNext()!!.getElement()

        // Returns (but does not remove) the last element of the list.
        fun last() = if(isEmpty()) null else trailer.getPrev()!!.getElement()
    }
}