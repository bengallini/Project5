package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly Linked List with sentinel nodes
 * 
 * @author Benjamin Gallini(bengallini)
 * @version 2022.4.20
 * 
 * @param <T>
 *            The type being stored in the list
 */
public class DoublyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Creates new DoublyLinkList object
     */
    public DoublyLinkedList() {
        size = 0;
        head = new DoublyLinkedList.Node<T>(null);
        tail = new DoublyLinkedList.Node<T>(null);
        head.setNextNode(tail);
        tail.setPreviousNode(head);
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
        head = new DoublyLinkedList.Node<T>(null);
        tail = new DoublyLinkedList.Node<T>(null);
        head.setNextNode(tail);
        tail.setPreviousNode(head);
    }


    /**
     * Adds a new item to the list
     * 
     * @param item
     *            The item being added
     * @param index
     *            The index of the item
     * @throws IllegalArgumentException
     *             If the item is null
     * @throws IndexOutOfBoundsException
     *             If the item is not inside of the bounds of the list
     */
    public void add(T item, int index) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = new Node<T>(item);
        Node<T> after;
        if (index == size) {
            after = tail;
        }
        else {
            after = nodeAtIndex(index);
        }
        current.setPreviousNode(after.getPreviousNode());
        current.setNextNode(after);
        after.getPreviousNode().setNextNode(current);
        after.setPreviousNode(current);
        size++;
    }


    /**
     * Adds and item to the end of the list
     * 
     * @param item
     *            The item being added
     */
    public void add(T item) {
        add(item, size);
    }


    /**
     * Removes a specified item from the list
     * 
     * @param item
     *            The item being removed
     * @throws IllegalArgumentException
     *             If the item is null
     */
    private void remove(Node<T> item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        item.previous.setNextNode(item.next);
        item.next.setPreviousNode(item.previous);
        size--;
    }


    /**
     * Removes an item at an index
     * 
     * @param index
     *            The index having a item removed
     * @throws IndexOutOfBoundsException
     *             If the index is not in bounds
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        remove(nodeAtIndex(index));
    }


    /**
     * Gets the node at an index
     */
    private Node<T> nodeAtIndex(int index) {
        Node<T> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current;
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
            while (current != tail) {
                str.append(current.getData().toString());
                if (current.getNextNode() != tail) {
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
     * Creates a reverse iterator
     * 
     * @return reverse iterator
     */
    public Iterator<T> reverseIterator() {
        return new reverseListIterator<T>();
    }

    /**
     * Node class
     * 
     * @author Benjamin Gallini (bengallini)
     * @version 2022.4.20
     * @param <T>
     *            The type being stored in the list
     */
    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
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
         * Sets the previous node
         * 
         * @param node
         *            The previous node
         */
        public void setPreviousNode(Node<T> node) {
            previous = node;
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
         * Gets the previous node
         * 
         * @return the previous node
         */
        public Node<T> getPreviousNode() {
            return previous;
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
            return (next != tail);
        }


        @Override
        /**
         * The next iterator object
         * 
         * @return the next item
         */
        public T next() {
            if (next == tail) {
                throw new NoSuchElementException();
            }
            T item = next.data;
            next = next.getNextNode();
            calledNext = true;
            return item;
        }

    }


    /**
     * Reverse list iterator class
     * 
     * @author Benjamin Gallini (bengallini)
     * @version 2022.4.29
     * @param <B>
     *            The type being stored in the list
     */
    private class reverseListIterator<B> implements Iterator<T> {
        private Node<T> rnext;
        private boolean calledNext;

        /**
         * Creates a reverse list iterator object
         */
        public reverseListIterator() {
            rnext = tail.previous;
            calledNext = false;
        }


        @Override
        /**
         * Returns if the iterator has a previous object
         * 
         * @return true if there is a previous
         */
        public boolean hasNext() {
            return (rnext != head);
        }


        @Override
        /**
         * Gets the iterator for the previous item
         * 
         * @return the iterator
         */
        public T next() {
            if (rnext == head) {
                throw new NoSuchElementException();
            }
            T item = rnext.data;
            rnext = rnext.previous;
            calledNext = true;
            return item;
        }

    }
}
