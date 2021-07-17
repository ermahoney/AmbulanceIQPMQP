import java.util.*;

/*
============================================================================
Name : FieldHospital.java
Author : Emily Mahoney
Version :
Copyright : Your copyright notice
Description : weightedSumCalculator and top3FieldHospitalsCalculator in Java
============================================================================
*/

public class FieldHospital {
    //list of field hospitals to rank
    public static LinkedList<FieldHospital> fieldHospitals;
    //name of field hospital
    private String fHName;
    //location/coordinates of field hospital
    private Pinpoint fHLocation;
    //location/coordinates of injured soldier
    private Pinpoint poi;

    //variable set of factors to judge field hospitals on
    private LinkedList<Double> factors;
    //how dangerous it is to get from poi to given field hospital
    private double danger;
    //how unavailable the given field hospital is
    private double unavailability;
    //how far it is to get from poi to given field hospital
    private double routeDistance;

    /*
    Field Hospital Object
    Description: an object to act as a field hospital in the area of a poi on a map
    Properties:
    - a name
    - a list of factors to rank the field hospital by
    - the location/coordinates of the field hospital
    - factors like danger, unavailability, and routeDistance
     */
    public FieldHospital() {
        this.fHName = fHName;
        this.factors = factors;
        this.fHLocation = fHLocation;
        this.danger = danger;
        this.unavailability = unavailability;
        this.routeDistance = routeDistance;
    }

    public static void main(String[] args) {
        AllMyTests at = new AllMyTests();
        if (at.tests()) {
            System.out.println("The tests are passed we are going to call production!");
            Production pd = new Production();
            pd.prod(args);
        } else {
            System.out.println("Some tests did not pass. Better luck next time!");
        }

    }

    /*
    Description: Calculates the weighed sum for a given set of weights and factors for a given field hospital
    Input: vector of weights, field hospital
    Output: weightedSum
     */
    public static double weightedSumCalculator(Vector<Double> weights, LinkedList<Double> myFactors, FieldHospital myFH) {
        double weightedSum = 0;
        for (int i = 0; i < weights.size(); i++) {
            //check that value of weight is not zero, if zero then skip that factor, else get value of weight
            if (weights.get(i) != 0.0) {
                weightedSum += weights.get(i) * myFactors.get(i);
            }
        }
        return weightedSum;
    }

    /*
    Description: Calculates weighted desirability with respect to point of injury for a given list of field hospitals
    and returns the top 3 field hospitals in ranked order
    Input: list of field hospitals, poi
    Output: list of best 3 field hospitals
    */
    public static ArrayList<String> top3FieldHospitalsCalculator(LinkedList<FieldHospital> fieldHospitals, LinkedList<Double> factors) {
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        LinkedHashMap<FieldHospital, Double> allFHWeightedSums = new LinkedHashMap<FieldHospital, Double>();
        ArrayList<String> top3FH = new ArrayList<>();
        double first, second, third;

        /* loop through list of field hospitals to put them into a hashmap with the field hospital names as the keys
        and the weighted sums as the values */
        for (FieldHospital fh : fieldHospitals) {
            LinkedList<Double> myFactors = new LinkedList<>();
            myFactors = fh.getFactors1FH(fh);
            double thisWeightedSum = weightedSumCalculator(myWeights, myFactors, fh);
            allFHWeightedSums.put(fh, thisWeightedSum);
        }

        // Check if list of field hospitals is zero or less and stops if true
        if (allFHWeightedSums.size() < 1) {
            System.out.println("Invalid input");
        }

        first = second = third = Integer.MAX_VALUE;
        //loop through the values of the hashmap and save the 3 fh's with the least weighted sums to a linked list
        for (Map.Entry<FieldHospital, Double> entry : allFHWeightedSums.entrySet()) {
            /* If current value is smaller than first
              then update first, second, and third */
            if (entry.getValue() < first) {

                third = second = first;
                first = entry.getValue();
                top3FH.add(entry.getKey().getFHName());

                /* If allFHWeightedSums.get(i) is in between first and second
               then update second  */
            } else if (entry.getValue() < second) {
                second = entry.getValue();
                top3FH.add(entry.getKey().getFHName());

                /* If allFHWeightedSums.get(i) is in between second and third
               then update third  */
            } else {
                if (entry.getValue() < third) {
                    third = entry.getValue();
                    top3FH.add(entry.getKey().getFHName());
                }
            }
        }

        //print out the weighted sums of the field hospitals in ranked order
        if (first == second && second == third && first != Integer.MAX_VALUE) { //case for first, second, and third tied
            System.out.println("There is a tie for first second, and third smallest element");
            System.out.println("First, second, and third are tied for smallest element at: " + first);
        } else if (first == second && first != Integer.MAX_VALUE && third == Integer.MAX_VALUE) { //case for first and second tied
            System.out.println("There is a tie for first and second smallest element");
            System.out.println("First and second are tied for smallest element at: " + first);
        } else if (first == second && first != Integer.MAX_VALUE && third != Integer.MAX_VALUE) { //case for first and second tied
            System.out.println("There is a tie for first and second smallest element, but not third");
            System.out.println("First and second are tied for smallest element at: " + first + " and the third smallest element is " + third);
        } else if (second == third && second != Integer.MAX_VALUE && first != Integer.MAX_VALUE) { //case for second and third tied
            System.out.println("There is a tie for second and third smallest element, but not first");
            System.out.println("The smallest element is " + first + " and second and third are tied for smallest element at: " + second);
        } else if (third == Integer.MAX_VALUE && second != Integer.MAX_VALUE) { //case for 2 field hospitals provided
            System.out.println("There is no third smallest element");
            System.out.println("The smallest element is " + first + " and second smallest" + " element is " + second);
        } else if (second == Integer.MAX_VALUE && third == Integer.MAX_VALUE) { //case for 1 field hospital provided
            System.out.println("There is no second or third smallest element");
            System.out.println("The smallest element is " + first);
        } else { //case for 3 field hospitals provided
            System.out.println("The smallest element is " + first + " and second smallest" + " element is " + second + " and third smallest" + " element is " + third);
        }

        //return the names of the best three field hospitals in order
        return top3FH;
    }

    //FACTOR METHODS
    //method to calculate the danger level of the route from a poi to a given field hospital
    //dummy method currently
    public static double danger() {
        return 0.8;
    }

    //method to calculate the unavailability level of the route from a poi to a given field hospital
    //dummy method currently
    public static double unavailability() {
        return 0.8;
    }

    //method to calculate the distance of the route from a poi to a given field hospital
    public static double routeDistance(Pinpoint fHLocation, Pinpoint poi) {
        return Pinpoint.eDistance(fHLocation, poi);
    }

    //GETTER AND SETTER METHODS
    //getter for field hospital name
    public String getFHName() {
        return this.fHName;
    }

    //setter for field hospital name
    public void setFHName(String fHName) {
        this.fHName = fHName;
    }

    //getter for field hospital location/coordinates
    public Pinpoint getFHLocation() {
        return this.fHLocation;
    }

    //setter for field hospital location/coordinates
    public void setfHLocation(Pinpoint fHLocation) {
        this.fHLocation = fHLocation;
    }

    //getter for 1 field hospital's factors
    public LinkedList<Double> getFactors1FH(FieldHospital fieldHospital) {
        return this.factors;
    }

    //setter for field hospital location/coordinates
    public void setFactors(LinkedList<Double> factors) {
        this.factors = factors;
    }

    //getter for multiple field hospitals' factors
    public static LinkedList<Double> getFactorsFHList(LinkedList<FieldHospital> fieldHospitals) {
        LinkedList<Double> myFactors = new LinkedList<>();
        for (FieldHospital fh : fieldHospitals) {
            myFactors = fh.getFactors1FH(fh);
        }
        return myFactors;
    }
}