package prj5;

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
        double CFR = (deaths / Math.abs(cases)) * 100;
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
            return (int)(this.getCFR() - o.getCFR());
        }
        else {
            return this.ethnicity.compareTo(o.ethnicity);
        }
    }

}
