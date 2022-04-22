package prj5;

import java.text.DecimalFormat;

/**
 * Race class
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.21
 */
public class Race implements Comparable<Race> {
    private String ethnicity;
    private int cases;
    private int deaths;

    /**
     * Race constructor
     * 
     * @param race
     *            The name of the race
     * @param cases
     *            Number of cases
     * @param death
     *            Number of deaths
     */
    public Race(String race, int cases, int death) {
        ethnicity = race;
        this.cases = cases;
        deaths = death;
    }

    /**
     * Returns the race name
     * 
     * @return name
     */
    public String getEthnicity() {
        return ethnicity;
    }


    /**
     * Gets the number of cases
     * 
     * @return cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * Gets the number of deaths
     * 
     * @return deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Calculates based the CFR
     * 
     * @return CFR
     */
    public double getCFR() {
        double CFR = ( (double) deaths / Math.abs(cases)) * 100;
        if(CFR < 0) {
            return -1;
        }
        else{
            
            return CFR;
        }
    }


    /**
     * Compares alphabetically
     * 
     * @param o
     *            The object comparing to
     * @return the comparable
     */
    public int compareToAlpha(Race o) {
        return this.ethnicity.compareTo(o.ethnicity);
    }


    @Override
    /**
     * Compares by CFR
     * 
     * @param o
     *            The object comparing to
     * @return comparable
     */
    public int compareTo(Race o) {
        if (this.getCFR() != o.getCFR()) {
            return (int)(10*(this.getCFR() - o.getCFR())); //Multiplied by 10 to avoid data loss when multiplying by 10
        }
        else {
            return compareToAlpha(o);
        }
    }
    
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(ethnicity + ": " + cases + " cases, ");
        String temp = String.format("%.1f", this.getCFR());
        if (temp.contains(".0")) {
            temp = String.format("%.0f", this.getCFR());
        }
        str.append(temp + "% CFR");
        
        return str.toString();
    }

}
