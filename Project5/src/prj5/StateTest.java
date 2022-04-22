package prj5;

import java.util.Iterator;
import student.TestCase;

public class StateTest extends TestCase {
    private State state;
    private Race white;
    private Race black;
    private Race latinx;

    public void setUp() {
        state = new State("VA");
        white = new Race("white", 100, 10);
        state.add(white);
        black = new Race("black", 100, 30);
        state.add(black);
        latinx = new Race("latinx", 100, 20);
        state.add(latinx);
    }


    /**
     * Test get name
     */
    public void testGetName() {
        assertEquals(state.getName(), "VA");
    }


    public void testToString() {
        StringBuilder str = new StringBuilder();
        str.append("VA");
        str.append("\n");
        str.append(black.toString());
        str.append("\n");
        str.append(latinx.toString());
        str.append("\n");
        str.append(white.toString());
        str.append("\n");
        str.append("=====\n");
        str.append(white.toString());
        str.append("\n");
        str.append(latinx.toString());
        str.append("\n");
        str.append(black.toString());
        str.append("\n");
        str.append("=====");
        assertEquals(state.toString(), str.toString());
        }
}
