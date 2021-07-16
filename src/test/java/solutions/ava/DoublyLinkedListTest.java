package solutions.ava;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Suleyman Yildirim
 */
@RunWith(MockitoJUnitRunner.class)
public class DoublyLinkedListTest {


    @Before
    public void setUp() {
    }

    @Test
    public void readFirst() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(1);
        assertEquals(1, linkedList.readFirst(linkedList));
    }

    @Test
    public void readLast() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(1);
        assertEquals(3, linkedList.readLast(linkedList));
    }

    @Test
    public void insertBeginning() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(1);
        linkedList.insertEnd(5);
        linkedList.insertBeginning(3);
        assertEquals(3, linkedList.readFirst(linkedList));
    }

    @Test
    public void insertBeginningToEmptyLinkedList() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(3);
        assertEquals(3, linkedList.readFirst(linkedList));
    }

    @Test
    public void insertEnd() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(3);
        linkedList.insertEnd(7);
        linkedList.insertEnd(5);
        assertEquals(7, linkedList.getFirstNode().next.data);
        assertEquals(linkedList.getLastNode().getData(), linkedList.readLast(linkedList));
    }

    @Test
    public void insertEndToEmptyLinkedList() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertEnd(7);
        assertEquals(7, linkedList.getLastNode().getData());
    }

    @Test
    public void findNode() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(1);
        linkedList.insertEnd(2);
        assertNotNull(linkedList.findNode(2));
        assertEquals(2, linkedList.findNode(2).getData());
        assertEquals(1, linkedList.findNode(2).prev.getData());
        assertNull( linkedList.findNode(2).next);
    }

    @Test
    public void remove() throws Exception {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertBeginning(3);
        linkedList.insertEnd(5);
        linkedList.insertEnd(7);
        linkedList.insertEnd(9);
        linkedList.remove(7);
        assertNull(linkedList.findNode(7));
        assertEquals(5, linkedList.getFirstNode().next.data);
        assertEquals(5, linkedList.getLastNode().prev.data);
    }
}