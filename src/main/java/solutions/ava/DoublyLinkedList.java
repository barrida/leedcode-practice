package solutions.ava;

import java.util.Optional;

/**
 * Implement a doubly linked list (of integers) class which allows new integers to be added to either end of the list,
 * any referenced node to be removed, and the first and last integers to be read quickly.
 *
 * @author Suleyman Yildirim
 */
public class DoublyLinkedList {

    private DoublyLinkedNode firstNode;   // points to first node of list
    private DoublyLinkedNode lastNode;   // points to last node of list

    public DoublyLinkedList() {

    }

    /**
     * Retrieve the last node from the list
     *
     * @param linkedList
     * @return
     */
    public int readFirst(DoublyLinkedList linkedList) {
        return getNodeData(linkedList.getFirstNode());
    }

    /**
     * Retrieve the first node from the list
     *
     * @param linkedList
     * @return
     */
    public int readLast(DoublyLinkedList linkedList) {
        return getNodeData(linkedList.getLastNode());
    }

    /**
     * Find a node with provided data
     *
     * @param data
     * @return
     */
    public DoublyLinkedNode findNode(int data) {
        DoublyLinkedNode currentNode = this.getFirstNode();
        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * Insert a node to the end of the list
     *
     * @param data
     */
    public void insertEnd(int data) {
        if (this.getLastNode() == null)
            insertBeginning(data);
        else
            insertAfter(this.getLastNode(), data);
    }

    /**
     * Insert a node to the beginning of the list
     *
     * @param data
     */
    public void insertBeginning(int data) {
        if (this.getFirstNode() == null) {
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            this.setFirstNode(newNode);
            this.setLastNode(newNode);
            newNode.prev = null;
            newNode.next = null;
        } else
            insertBefore(this.getFirstNode(), data);
    }

    /**
     * Removes any referenced node from list
     *
     * @param data
     */
    public void remove(int data) {
        DoublyLinkedNode node = findNode(data);
        if (node != null) {
            if (node.prev == null) {
                this.setFirstNode(node.next);
            } else {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                this.setLastNode(node.prev);
            } else {
                node.next.prev = node.prev;
            }
        } else {
            throw new NullPointerException("node with " + data + " index not found");
        }
    }

    ////Helper functions
    private void insertBefore(DoublyLinkedNode firstNode, int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.next = firstNode;
        if (firstNode.prev == null) {
            newNode.prev = null;
            this.setFirstNode(newNode);
        } else {
            newNode.prev = firstNode.prev;
            //firstNode.prev.next = newNode;
            firstNode.setPrev(firstNode.setNext(newNode));
        }
        firstNode.prev = newNode;
    }

    private void insertAfter(DoublyLinkedNode lastNode, int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.prev = lastNode;
        if (lastNode.next == null) {
            newNode.next = null;
            this.setLastNode(newNode);
        } else {
            newNode.next = lastNode.next;
            lastNode.next.prev = newNode;
        }
        lastNode.next = newNode;
    }

    private int getNodeData(DoublyLinkedNode node) {
        return Optional.of(node)
                .map(DoublyLinkedNode::getData)
                .orElseThrow(() -> new NullPointerException("Exception in getting node data: Linked list or the node is null"));
    }


    //Getters and setters
    public DoublyLinkedNode getFirstNode() {
        return firstNode;
    }

    public DoublyLinkedNode getLastNode() {
        return lastNode;
    }

    public DoublyLinkedList setFirstNode(DoublyLinkedNode firstNode) {
        this.firstNode = firstNode;
        return this;
    }

    public DoublyLinkedList setLastNode(DoublyLinkedNode lastNode) {
        this.lastNode = lastNode;
        return this;
    }

}
