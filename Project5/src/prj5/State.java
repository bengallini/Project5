package prj5;

import java.util.Iterator;

/**
 * State Class
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.21
 */
public class State extends DoublyLinkedList<Race> {

    private String name;

    /**
     * State constructor
     * 
     * @param str
     *            Name of state
     */
    public State(String str) {
        super();
        name = str;
    }


    /**
     * Gets the name of the sate
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sorts the state alphabetically
     */
    public void sortAlpha() {
        if (getSize() > 1) {
            Node<Race> unsorted = getHead().getNextNode();
            Node<Race> sorted = getHead();
            sorted.setNextNode(null);
            while (unsorted != getTail()) {
                Node<Race> insert = unsorted;
                unsorted = unsorted.getNextNode();
                insertIntoSortedAlpha(insert);
            }
        }
    }


    /**
     * Compares and inserts a node
     * 
     * @param insert
     *            The node being compared
     */
    private void insertIntoSortedAlpha(Node<Race> insert) {
        Race item = insert.getData();
        Node<Race> current = insert.getNextNode();
        Node<Race> previous = null;

        while ((current != getTail()) && item.compareToAlpha(current
            .getData()) > 0) {
            previous = current;
            current = current.getNextNode();
        }

        if (previous != getHead()) {
            previous.setNextNode(insert);
            insert.setPreviousNode(previous);
            insert.setNextNode(current);
            current.setPreviousNode(insert);
        }
        else {
            getHead().getNextNode().setPreviousNode(insert);
            insert.setNextNode(getHead().getNextNode());
            insert.setPreviousNode(getHead());
            getHead().setNextNode(insert);
        }
    }


    /**
     * Sorts the state by CFR
     */
    public void sortCFR() {
        if (getSize() > 1) {
            Node<Race> unsorted = getHead().getNextNode();
            Node<Race> sorted = getHead();
            sorted.setNextNode(null);
            while (unsorted != getTail()) {
                Node<Race> insert = unsorted;
                unsorted = unsorted.getNextNode();
                insertIntoSortedCFR(insert);
            }
        }
    }


    /**
     * Compares and inserts a node
     * 
     * @param insert
     *            The node being compared
     */
    private void insertIntoSortedCFR(Node<Race> insert) {
        Race item = insert.getData();
        Node<Race> current = insert.getNextNode();
        Node<Race> previous = null;

        while ((current != getTail()) && item.compareTo(current
            .getData()) > 0) {
            previous = current;
            current = current.getNextNode();
        }

        if (previous != getHead()) {
            previous.setNextNode(insert);
            insert.setPreviousNode(previous);
            insert.setNextNode(current);
            current.setPreviousNode(insert);
        }
        else {
            getHead().getNextNode().setPreviousNode(insert);
            insert.setNextNode(getHead().getNextNode());
            insert.setPreviousNode(getHead());
            getHead().setNextNode(insert);
        }
    }
    
    /**
     * Converts the state to a string
     * 
     * @return the string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append("/n");
        sortAlpha();
        Iterator<Race> itr = iterator();
        while(itr.hasNext()) {
            str.append(itr.next().toString());
            str.append("/n");
        }
        str.append("=====/n");
        sortCFR();
        Iterator<Race> itr2 = iterator();
        while(itr2.hasNext()) {
            str.append(itr2.next().toString());
            str.append("/n");
        }
        str.append("=====");
        return str.toString();
    }
}
