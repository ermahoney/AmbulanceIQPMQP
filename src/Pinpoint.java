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
    public Pinpoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static void main (String[] args){
        //two sample locations
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);

        //testing out Euclidean distance calculator
        double eDistPinpoints = eDistance(pinpoint1, pinpoint2);

        //testing out Manhattan distance calculator
        double mDistPinpoints = mDistance(pinpoint1, pinpoint2);
        System.out.print("For points (" + pinpoint1.x + "," + pinpoint1.y + ") and (" + pinpoint2.x + "," + pinpoint2.y + "), Euclidean Distance = " + eDistPinpoints + " and Manhattan Distance = " + mDistPinpoints);
    }

    /*
    Description: Euclidean distance calculator
    Input: Two Pinpoint locations
    Output: Euclidean distance between two Pinpoints
     */
    public static double eDistance(Pinpoint pinpoint1, Pinpoint pinpoint2){
        //square the two x coordinates and subtract them
        double x = Math.pow(pinpoint2.x - pinpoint1.x, 2);
        //square the two y coordinates and subtract them
        double y = Math.pow(pinpoint2.y - pinpoint1.y, 2);
        //add together the x and y coordinates and take the square root
        return Math.sqrt(x + y);
    }

    /*
    Description: Manhattan distance calculator
    Input: Two Pinpoint locations
    Output: Manhattan distance between two Pinpoints
     */
    public static double mDistance(Pinpoint pinpoint1, Pinpoint pinpoint2){
        //subtract x1 from x2 and y1 from y2, take absolute value of x and y, add x and y
        return Math.abs(pinpoint2.x - pinpoint1.x) + Math.abs(pinpoint2.y - pinpoint1.y);
    }

}
