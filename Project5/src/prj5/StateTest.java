package prj5;

import student.TestCase;

/**
 * Test class for State
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.21
 */
public class StateTest extends TestCase {
    private State state;
    private State empty;
    private Race white;
    private Race black;
    private Race latinx;

    /**
     * Sets up each test
     */
    public void setUp() {
        empty = new State("Empty");
        state = new State("VA");
        white = new Race("white", 100, 10);
        state.add(white);
        black = new Race("black", 100, 30);
        state.add(black);
        latinx = new Race("latinx", 100, 20);
        state.add(latinx);
    }


    /**
     * Tests getName
     */
    public void testGetName() {
        assertEquals(state.getName(), "VA");
    }


    /**
     * Tests sortAlpha()
     */
    public void testSortAlpha() {
        State compare = empty;
        empty.sortAlpha();
        assertEquals(compare.toString(), empty.toString());
        compare.add(black);
        compare.add(latinx);
        compare.add(white);
        compare.add(black);
        compare.add(latinx);
        compare.sortAlpha();
        empty.add(black);
        empty.add(black);
        empty.add(latinx);
        empty.add(latinx);
        empty.add(white);
        assertEquals(compare.toString(), empty.toString());
    }


    /**
     * Tests sortCFR()
     */
    public void testSortCFR() {
        State compare = empty;
        empty.sortCFR();
        assertEquals(compare.toString(), empty.toString());
        compare.add(latinx);
        compare.add(white);
        compare.add(black);
        compare.sortCFR();
        empty.add(black);
        empty.add(latinx);
        empty.add(white);
        assertEquals(compare.toString(), empty.toString());
    }


    /**
     * Tests toString
     */
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
        str.append(black.toString());
        str.append("\n");
        str.append(latinx.toString());
        str.append("\n");
        str.append(white.toString());
        str.append("\n");
        str.append("=====");
        assertEquals(state.toString(), str.toString());
    }
}
