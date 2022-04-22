package prj5;

import java.io.FileNotFoundException;

/**
 * Runs the project
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.22
 */
public class Input {

    /**
     * Main method, file names can be given as
     * program arguments
     * 
     * @param args
     *            File names
     * @throws FileNotFoundException
     *             If there is no file found under the given name
     */
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length > 0) {
            FileReader filereader = new FileReader(args[0]);
        }
        else {
            FileReader filereader = new FileReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
