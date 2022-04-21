package prj5;

import java.util.Iterator;

public class State extends DoublyLinkedList<Race>{

    private String name;
    
    public State(String str) {
        super();
        name = str;
    }
    
    public String getName() {
        return name;
    }
    
    public void sortAlpha() {
        if(getSize() > 1){
            Iterator<Race> unsorted = iterator();
            Iterator<Race> sorted = iterator();
            sorted.next();
            sorted.setNext(null);
            while(unsorted != null){
                Iterator<Race> insert = unsorted;
                unsorted = unsorted.next();
                insertIntoSorted(insert);
            }
        }
    }
    
    
}
