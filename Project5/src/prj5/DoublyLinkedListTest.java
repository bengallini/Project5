package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test class for DoublyLinkedList
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.20
 */
public class DoublyLinkedListTest extends TestCase {
    private DoublyLinkedList<String> list;
    private Iterator<String> iter;
    private Iterator<String> riter;

    /**
     * Sets up the tests
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
        DoublyLinkedList<String> listA = new DoublyLinkedList<String>();
        listA.add("A");
        listA.add("B");
        listA.add("C");
        iter = listA.iterator();
        riter = listA.reverseIterator();
    }


    /**
     * Tests get size
     */
    public void testGetSize() {
        assertEquals(list.getSize(), 0);
        list.add("A");
        assertEquals(list.getSize(), 1);
        list.remove(0);
        assertEquals(list.getSize(), 0);
    }


    /**
     * Tests isEmpty
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Tests clear
     */
    public void testClear() {
        list.clear();
        assertTrue(list.isEmpty());
        list.add("A");
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * Tests add
     */
    public void testAdd() {
        list.add("A");
        assertEquals(list.getSize(), 1);
        list.add("B", 1);
        assertEquals(list.getSize(), 2);
        list.add("C", 0);
        assertEquals(list.getSize(), 3);
    }


    /**
     * Tests add exception
     */
    public void testAddException() {
        Exception e = null;
        try {
            list.add("B", 1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add("B", -1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(null, 1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * Tests remove
     */
    public void testRemove() {
        list.add("A");
        list.add("B");
        list.remove(1);
        assertEquals(list.getSize(), 1);
        list.remove(0);
        assertEquals(list.getSize(), 0);
    }


    /**
     * Tests remove exception
     */
    public void testRemoveException() {
        Exception e = null;
        try {
            list.remove(0);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests toString
     */
    public void testToString() {
        assertEquals(list.toString(), "{}");
        list.add("A");
        assertEquals(list.toString(), "{A}");
        list.add("B");
        assertEquals(list.toString(), "{A,B}");
        list.add("C", 0);
        assertEquals(list.toString(), "{C,A,B}");
    }

    /**
     * Tests hasNext
     */
    public void testHasNext() {
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertFalse(iter.hasNext());
        
    }
    
    /**
     * Tests next
     */
    public void testNext() {
        assertEquals(iter.next(), "A");
        assertEquals(iter.next(), "B");
        assertEquals(iter.next(), "C");
    }

    /**
     * Tests reverse hasNext
     */
    public void testRHasNext() {
        assertTrue(riter.hasNext());
        riter.next();
        assertTrue(riter.hasNext());
        riter.next();
        assertTrue(riter.hasNext());
        riter.next();
        assertFalse(riter.hasNext());
    }
    
    /**
     * Tests reverse next
     */
    public void testRNext() {
        assertEquals(riter.next(), "C");
        assertEquals(riter.next(), "B");
        assertEquals(riter.next(), "A");
    }
    /**
     * Tests iterator exceptions
     */
    public void testIteratorException() {
        iter.next();
        iter.next();
        iter.next();
        Exception e = null;
        try {
           iter.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);

    }


    /**
     * Tests reverse iterator exceptions
     */
    public void testReverseIteratorException() {
        riter.next();
        riter.next();
        riter.next();
        Exception e = null;
        try {
           riter.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
    }
}
