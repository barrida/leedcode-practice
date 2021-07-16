package solutions.ava;

/**
 * @author Suleyman Yildirim
 */
public class DoublyLinkedNode {
    int data; // Data or a reference to data
    DoublyLinkedNode next; // A reference to the next node
    DoublyLinkedNode prev; // A reference to the previous node

    public DoublyLinkedNode(int data, DoublyLinkedNode next, DoublyLinkedNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    DoublyLinkedNode(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    public DoublyLinkedNode setNext(DoublyLinkedNode next) {
        this.next = next;
        return this;
    }

    public DoublyLinkedNode getPrev() {
        return prev;
    }

    public DoublyLinkedNode setPrev(DoublyLinkedNode prev) {
        this.prev = prev;
        return this;
    }

}
