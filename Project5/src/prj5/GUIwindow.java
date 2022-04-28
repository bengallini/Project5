package prj5;

import java.awt.Color;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * GUI window class
 * 
 * @author Benjamin Gallini (bengallini)
 * @version 2022.4.27
 *
 */
public class GUIwindow {

    private Window window;
    private State[] states;
    private State currentState;
    private Button alpha;
    private Button quit;
    private Button cfr;
    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;

    /**
     * GUI window object
     * 
     * @param state
     */
    GUIwindow(State[] state) {
        window = new Window();
        window.setTitle("Project 5");
        states = state;
        currentState = null;

        alpha = new Button("Sort by Alpha");
        window.addButton(alpha, WindowSide.NORTH);
        alpha.onClick(this, "clickedAlpha");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        cfr = new Button("Sort by CFR");
        window.addButton(cfr, WindowSide.NORTH);
        cfr.onClick(this, "clickedCFR");

        dc = new Button("Represent DC");
        window.addButton(dc, WindowSide.SOUTH);
        dc.onClick(this, "clickedDC");

        ga = new Button("Represent GA");
        window.addButton(ga, WindowSide.SOUTH);
        ga.onClick(this, "clickedGA");

        md = new Button("Represent MD");
        window.addButton(md, WindowSide.SOUTH);
        md.onClick(this, "clickedMD");

        nc = new Button("Represent NC");
        window.addButton(nc, WindowSide.SOUTH);
        nc.onClick(this, "clickedNC");

        tn = new Button("Represent TN");
        window.addButton(tn, WindowSide.SOUTH);
        tn.onClick(this, "clickedTN");

        va = new Button("Represent VA");
        window.addButton(va, WindowSide.SOUTH);
        va.onClick(this, "clickedVA");
    }


    /**
     * Updates the screen by removing all shapes
     */
    public void updateScreen() {
        if (currentState != null) {
            window.removeAllShapes();
            createScreen(currentState);
        }
    }


    /**
     * Creates a screen with the specified state
     * 
     * @param state
     *            The state to display
     */
    public void createScreen(State state) {
        StringBuilder str = new StringBuilder();
        str.append(state.getName());
        str.append(" Case Fatility Ratios by Race");
        TextShape title = new TextShape(250, 10, str.toString());
        window.addShape(title);

        Iterator<Race> itr = state.iterator();
        for (int i = 1; i < 6; i++) {
            createShapes(i, itr.next());
        }
    }


    /**
     * Creates individual shapes for the race
     * 
     * @param x
     *            The x coordinate multipier
     * @param race
     *            The race class being displayed
     */
    public void createShapes(int x, Race race) {
        if (race.getCFR() < 0) {
            Shape shape = new Shape(x * 110, 190, 35, 10, Color.BLUE);
            window.addShape(shape);
            TextShape name = new TextShape(x * 110, 220, race.getEthnicity());
            window.addShape(name);
            TextShape cfr = new TextShape(x * 110, 240, "N/A");
            window.addShape(cfr);
        }
        else {
            Shape shape = new Shape(x * 110, 190 - 12 * (int)race.getCFR(), 35,
                10 + 12 * (int)race.getCFR(), Color.BLUE);
            window.addShape(shape);

            TextShape name = new TextShape(x * 110, 220, race.getEthnicity());
            window.addShape(name);

            StringBuilder str = new StringBuilder();
            String temp = String.format("%.1f", race.getCFR());
            if (temp.contains(".0")) {
                temp = String.format("%.0f", race.getCFR());
            }
            str.append(temp + "%");
            TextShape cfr = new TextShape(x * 110, 240, str.toString());
            window.addShape(cfr);
        }
    }


    /**
     * Closes the window
     * 
     * @param button
     *            The button pressed
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Sorts alphabetically
     * 
     * @param button
     *            The button pressed
     */
    public void clickedAlpha(Button button) {
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Sorts by CFR
     * 
     * @param button
     *            The button pressed
     */
    public void clickedCFR(Button button) {
        currentState.sortCFR();
        updateScreen();
    }


    /**
     * Displays DC's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedDC(Button button) {
        currentState = states[1];
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Displays Georgia's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedGA(Button button) {
        currentState = states[2];
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Displays Maryland's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedMD(Button button) {
        currentState = states[3];
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Displays North Carolina's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedNC(Button button) {
        currentState = states[4];
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Displays Tennessee's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedTN(Button button) {
        currentState = states[5];
        currentState.sortAlpha();
        updateScreen();
    }


    /**
     * Displays Virginia's info
     * 
     * @param button
     *            The button pressed
     */
    public void clickedVA(Button button) {
        currentState = states[6];
        currentState.sortAlpha();
        updateScreen();
    }
}
