package prj5;

import student.TestCase;

/**
 * Test class for Race
 * 
 * @author Prakash Jawahar (jprakash)
 * @version 2022.4.21
 */
public class RaceTest extends TestCase {

    private Race race;

    /**
     * Sets up each test
     */
    public void setUp() {
        race = new Race("white", 100, 50);
    }


    /**
     * Tests the getter methods
     */
    public void testGetters() {
        assertEquals(race.getCases(), 100);
        assertEquals(race.getDeaths(), 50);
        assertEquals(race.getEthnicity(), "white");

        Race temp1 = new Race("asian", -1, -1);
        assertEquals(race.getCFR(), 50, .0001);
        assertEquals(temp1.getCFR(), -1, .0001);
    }


    /**
     * Tests alphaCompare
     */
    public void testAlphaCompare() {
        Race temp1 = new Race("white", 242, 23);
        assertEquals(race.compareToAlpha(temp1), 0);
        Race temp2 = new Race("black", 242, 23);
        assertTrue(race.compareToAlpha(temp2) > 0);
        Race temp3 = new Race("asian", 242, 23);
        assertTrue(temp3.compareTo(temp2) < 0);
    }


    /**
     * Tests compareTo
     */
    public void testNormCompare() {
        Race temp1 = new Race("white", 100, -70);
        assertEquals(race.compareTo(temp1), -5100);
        Race temp2 = new Race("black", 100, -50);
        assertTrue(race.compareTo(temp2) < 0);
    }


    /**
     * Tests toString
     */
    public void testToString() {
        String str = "white: 100 cases, 50% CFR";
        Race temp2 = new Race("black", 105, 67);
        String str2 = "black: 105 cases, 63.8% CFR";
        Race temp3 = new Race("black", 112, 3);
        String str3 = "black: 112 cases, 2.7% CFR";

        assertEquals(race.toString(), str);
        assertEquals(temp2.toString(), str2);
        assertEquals(temp3.toString(), str3);
    }
}
