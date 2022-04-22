package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test class for LinkedList
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.20
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> list;
    private Iterator<String> iter;

    /**
     * Sets up the tests
     */
    public void setUp() {
        list = new LinkedList<String>();
        LinkedList<String> listA = new LinkedList<String>();
        listA.add("A");
        listA.add("B");
        listA.add("C");
        iter = listA.iterator();
    }


    /**
     * Tests get size
     */
    public void testGetSize() {
        assertEquals(list.getSize(), 0);
        list.add("A");
        assertEquals(list.getSize(), 1);
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
     * Test getHead()
     */
    public void testGetHead() {
        assertNull(list.getHead().getData());
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
        list.add("B");
        assertEquals(list.getSize(), 2);
        list.add("C");
        assertEquals(list.getSize(), 3);
    }


    /**
     * Tests add exception
     */
    public void testAddException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
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
        list.add("C");
        assertEquals(list.toString(), "{A,B,C}");
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
}
