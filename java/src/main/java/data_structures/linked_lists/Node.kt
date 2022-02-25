package data_structures.linked_lists

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