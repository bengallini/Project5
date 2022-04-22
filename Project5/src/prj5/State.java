package prj5;

import java.util.Iterator;

/**
 * State Class
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.21
 */
public class State extends LinkedList<Race> {
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
            Node<Race> unsorted = getHead().getNextNode().getNextNode();
            Node<Race> sorted = getHead().getNextNode();
            sorted.setNextNode(null);
            while (unsorted != null) {
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
        Node<Race> current = getHead().getNextNode();
        Node<Race> previous = null;

        while ((current != null) && item.compareToAlpha(current
            .getData()) > 0) {
            previous = current;
            current = current.getNextNode();
        }

        if (previous != null) {
            previous.setNextNode(insert);

            insert.setNextNode(current);

        }
        else {
            if (getHead().getNextNode() != null) {
                insert.setNextNode(getHead().getNextNode());
            }
            getHead().setNextNode(insert);
        }
    }


    /**
     * Sorts the state by CFR
     */
    public void sortCFR() {
        if (getSize() > 1) {
            Node<Race> unsorted = getHead().getNextNode().getNextNode();
            Node<Race> sorted = getHead().getNextNode();
            sorted.setNextNode(null);
            while (unsorted != null) {
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
        Node<Race> current = getHead().getNextNode();
        Node<Race> previous = null;

        while ((current != null) && item.compareTo(current.getData()) > 0) {
            previous = current;
            current = current.getNextNode();
        }

        if (previous != null) {
            previous.setNextNode(insert);
            insert.setNextNode(current);
        }
        else {
            if (getHead().getNextNode() != null) {
                insert.setNextNode(getHead().getNextNode());
            }
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
        str.append("\n");
        sortAlpha();
        Iterator<Race> itr = iterator();
        while (itr.hasNext()) {
            str.append(itr.next().toString());
            str.append("\n");
        }
        str.append("=====\n");
        sortCFR();
        Iterator<Race> itr2 = iterator();
        while (itr2.hasNext()) {
            str.append(itr2.next().toString());
            str.append("\n");
        }
        str.append("=====");
        return str.toString();
    }
}
