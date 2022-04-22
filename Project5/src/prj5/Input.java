package prj5;

import java.io.FileNotFoundException;

public class Input {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        if(args.length > 0) {
        FileReader filereader = new FileReader(args[0]);
        }
        else {
            FileReader filereader = new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        System.out.println("test");
    }
}
