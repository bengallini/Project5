package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly Linked List with sentinel nodes
 * 
 * @author Benjamin Gallini(bengallini)
 * @version 2022.4.20
 * 
 * @param <T>
 *            The type being stored in the list
 */
public class LinkedList<T> {

    private int size;
    private Node<T> head;

    /**
     * Creates new LinkList object
     */
    public LinkedList() {
        size = 0;
        head = new LinkedList.Node<T>(null);
        head.setNextNode(null);
    }


    /**
     * Gets the size of the list
     * 
     * @return size
     *         The list's size
     */
    public int getSize() {
        return size;
    }


    /**
     * Returns the head
     * 
     * @return head
     */
    public Node<T> getHead() {
        return head;
    }


    /**
     * Gets if the string is empty
     * 
     * @return true if size is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Clears the list
     */
    public void clear() {
        size = 0;
        head = new LinkedList.Node<T>(null);
        head.setNextNode(null);
    }


    /**
     * Adds and item to the end of the list
     * 
     * @param item
     *            The item being added
     */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<T> insert = new Node<T>(item);
        Node<T> before = head;
        while (before.next != null) {
            before = before.getNextNode();
        }
        before.setNextNode(insert);
        size++;
    }


    /**
     * Converts a list to a string
     * "{}" if empty
     * 
     * @returns the string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        if (!isEmpty()) {
            Node<T> current = head.getNextNode();
            while (current != null) {
                str.append(current.getData().toString());
                if (current.getNextNode() != null) {
                    str.append(",");
                }
                current = current.getNextNode();

            }
        }

        str.append("}");
        return str.toString();
    }


    /**
     * Creates an iterator
     * 
     * @return iterator
     */
    public Iterator<T> iterator() {
        return new listIterator<T>();
    }

    /**
     * Node class
     * 
     * @author Benjamin Gallini (bengallini)
     * @version 2022.4.20
     * @param <T>
     *            The type being stored in the list
     */
    static class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Creates a node object
         * 
         * @param d
         *            The item stored in the node
         */
        public Node(T d) {
            data = d;
        }


        /**
         * Sets the next node
         * 
         * @param node
         *            The next node
         */
        public void setNextNode(Node<T> node) {
            next = node;
        }


        /**
         * Gets the next node
         * 
         * @return the next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * Gets the data in the node
         * 
         * @return the data
         */
        public T getData() {
            return data;
        }

    }


    /**
     * List iterator class
     * 
     * @author Benjamin Gallini (bengallini)
     * @version 2022.4.29
     * @param <A>
     *            The type being stored in the list
     */
    private class listIterator<A> implements Iterator<T> {
        private Node<T> next;
        private boolean calledNext;

        /**
         * Creates an list iterator object
         */
        public listIterator() {
            next = head.getNextNode();
            calledNext = false;
        }


        @Override
        /**
         * Returns if there is a next node
         * 
         * @return true if there is a next node
         */
        public boolean hasNext() {
            return (next != null);
        }


        @Override
        /**
         * The next iterator object
         * 
         * @return the next item
         */
        public T next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            T item = next.data;
            next = next.getNextNode();
            calledNext = true;
            return item;
        }

    }
}
