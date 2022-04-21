package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import student.IOHelper;

public class FileReader {

    private State[] states;
    private Race race;
    public final static int NUM_STATES = 6;

    public FileReader(String fileName) {
        //comments
    }

    private State[] CFRReader(String fileName) throws FileNotFoundException {
        states = new State[NUM_STATES];

        File news = new File(fileName);
        Scanner file = new Scanner(news);
        int lineCount = 0;

        while (file.hasNextLine() && lineCount < 6) {
            if (lineCount > 0) {
                String line = file.nextLine();
                Scanner currLine = new Scanner(line).useDelimiter(",\\s*");
                String vals[] = new String[11];

                int tokenCount = 0;
                while (currLine.hasNext() && tokenCount < 11) {
                    vals[tokenCount] = currLine.next();
                    tokenCount++;
                }
                currLine.close();
                String name = vals[0];
                int white = Integer.valueOf(vals[1]);
                int black = Integer.valueOf(vals[2]);
                int latinx = Integer.valueOf(vals[3]);
                int asian = Integer.valueOf(vals[4]);
                int other = Integer.valueOf(vals[5]);
                int whitedeath = Integer.valueOf(vals[6]);
                int blackdeath = Integer.valueOf(vals[7]);
                int latinodeath = Integer.valueOf(vals[8]);
                int asiandeath = Integer.valueOf(vals[9]);
                int otherdeath = Integer.valueOf(vals[10]);

                /**
                Race whiterace = new Race("white", white, whitedeath);
                Race blackrace = new Race("black", black, blackdeath);
                Race latinorace = new Race("latinx", latinx, latinodeath);
                Race asianrace = new Race("asian", asian, asiandeath);
                Race otherrace = new Race("other", other, otherdeath);

                State tempz = new State(name);
                tempz.add(whiterace);
                tempz.add(blackrace);
                tempz.add(latinxrace);
                tempz.add(asianrace);
                tempz.add(otherrace);
                
                states[lineCount] = tempz;
                **/  
            } 
        }
        return states;
    }

}
