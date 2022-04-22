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

    public FileReader(String fileName) throws FileNotFoundException {
        states = CFRReader(fileName);
        
    }

    private State[] CFRReader(String fileName) throws FileNotFoundException {
        states = new State[NUM_STATES];
        File news = new File(fileName);
        Scanner file = new Scanner(news);
        int lineCount = 0;

        while (file.hasNextLine() && lineCount < 6) {
            String line = file.nextLine();
             if (lineCount > 0) {               
                Scanner currLine = new Scanner(line).useDelimiter(",\\s*");
                String vals[] = new String[11];

                int tokenCount = 0;
                while (currLine.hasNext() && tokenCount < 11) {
                    vals[tokenCount] = currLine.next();
                    tokenCount++;
                }
                currLine.close();
                Integer[] nums = new Integer[10];
                String name = vals[0];
                for (int i = 1; i < vals.length; i++) {
                    nums[i-1] = NAFinder(vals[i]);
                }
                int white = nums[0];
                int black = nums[1];
                int latinx = nums[2];
                int asian = nums[3];
                int other = nums[4];
                int whitedeath = nums[5];
                int blackdeath = nums[6];
                int latinxdeath = nums[7];
                int asiandeath = nums[8];
                int otherdeath = nums[9];
                
                Race whiterace = new Race("white", white, whitedeath);
                Race blackrace = new Race("black", black, blackdeath);
                Race latinxrace = new Race("latinx", latinx, latinxdeath);
                Race asianrace = new Race("asian", asian, asiandeath);
                Race otherrace = new Race("other", other, otherdeath);
                State tempz = new State(name);
                tempz.add(whiterace);
                tempz.add(blackrace);
                tempz.add(latinxrace);
                tempz.add(asianrace);
                tempz.add(otherrace);
                
                states[lineCount] = tempz; 
                System.out.println(tempz);
            } 
            lineCount++;
        }
        file.close();
        return states;
    }
    
    private int NAFinder(String str) {
        
        if (str.equals("NA")) {
            return -1;
        }
        return Integer.valueOf(str);
    }

}
