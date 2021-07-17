/*
============================================================================
Name : Pinpoint.java
Author : Emily Mahoney
Version :
Copyright : Your copyright notice
Description : eDistance and mDistance in Java
============================================================================
*/

public class Pinpoint {

    //x and y coordinates
    public final double x;
    public final double y;

    /*
    Pinpoint Object
    Description: an object to act as a location for either a poi or a field hospital
    Properties:
    - an x coordinate
    - a y coordinate
     */
    public Pinpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
    Description: Euclidean distance calculator
    Input: Two Pinpoint locations
    Output: Euclidean distance between two Pinpoints
     */
    public static double eDistance(Pinpoint pinpoint1, Pinpoint pinpoint2) {
        double x = Math.pow(pinpoint2.x - pinpoint1.x, 2);
        double y = Math.pow(pinpoint2.y - pinpoint1.y, 2);
        return Math.sqrt(x + y);
    }

    /*
    Description: Manhattan distance calculator
    Input: Two Pinpoint locations
    Output: Manhattan distance between two Pinpoints
     */
    public static double mDistance(Pinpoint pinpoint1, Pinpoint pinpoint2) {
        return Math.abs(pinpoint2.x - pinpoint1.x) + Math.abs(pinpoint2.y - pinpoint1.y);
    }

}
