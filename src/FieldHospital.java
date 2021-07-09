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
    public static LinkedList<String> fieldHospitals;
    //name of field hospital
    private String fHName;
    //location/coordinates of field hospital
    private Pinpoint fHLocation;

    //variable set of factors to judge field hospitals on
    public static LinkedList<Double> factors;
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
    - a list of factors to rank the field hospital by
    - the location/coordinates of the field hospital
    - the location/coordinates of the given poi
    - a name
    - factors like danger, unavailability, and routeDistance
     */
    public FieldHospital(LinkedList<Double> factors, Pinpoint fHLocation, Pinpoint poi) {
        this.fHName = fHName;
        this.factors = factors;
        this.fHLocation = fHLocation;
        this.danger = getDanger();
        this.unavailability = getUnavailability();
        this.routeDistance = getRouteDistance(fHLocation, poi);
    }

    public static void main(String[] args) {
        //WEIGHTED SUM
        //setting my poi to be at the origin
        Pinpoint poi = new Pinpoint(0,0);
        //making a field hospital with factors and a location
        Pinpoint locationFH1 = new Pinpoint(-3,-5);
        LinkedList<Double> factors1 = new LinkedList<>();
        FieldHospital fh1 = new FieldHospital(factors1, locationFH1, poi);

        //adding my 3 factors to a list of factors
        factors1.add(0, fh1.getDanger());
        factors1.add(1, fh1.getUnavailability());
        factors1.add(2, fh1.getRouteDistance(locationFH1, poi));

        //making a vector of 3 weights for the 3 factors
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);

        //testing out the method that calculates the weighted sum of the factors for a given field hospital and weights
        double fH1WeightedDesirablity = weightedSumCalculator(myWeights, fh1);
        System.out.println("The route score for the given weight values is: " + fH1WeightedDesirablity);


        //TOP 3 FIELD HOSPITALS
        //making 4 samples of field hospitals
        //Field Hospital A
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,9);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital(factorsA, locationA, poi); //TODO is this getting the wrong location for factors? (see line 33)
        fhA.setFHName("The A FH");
        factorsA.add(0, fhA.getDanger());
        factorsA.add(1, fhA.getUnavailability());
        factorsA.add(2, fhA.getRouteDistance(locationA, poi));

        //Field Hospital B
        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,11);
        FieldHospital fhB = new FieldHospital(factorsB, locationB, poi);
        fhB.setFHName("The B FH");
        factorsB.add(0, fhB.getDanger());
        factorsB.add(1, fhB.getUnavailability());
        factorsB.add(2, fhB.getRouteDistance(locationB, poi));

        //Field Hospital C
        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(3,6);
        FieldHospital fhC = new FieldHospital(factorsC, locationC, poi);
        fhC.setFHName("The C FH");
        factorsC.add(0, fhC.getDanger());
        factorsC.add(1, fhC.getUnavailability());
        factorsC.add(2, fhC.getRouteDistance(locationC, poi));

        //Field Hospital D
        LinkedList<Double> factorsD = new LinkedList<>();
        Pinpoint locationD = new Pinpoint(7,0);
        FieldHospital fhD = new FieldHospital(factorsD, locationD, poi);
        fhD.setFHName("The D FH");
        factorsD.add(0, fhD.getDanger());
        factorsD.add(1, fhD.getUnavailability());
        factorsD.add(2, fhD.getRouteDistance(locationD, poi));

        //adding the 4 sample field hospitals to a list
        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);
        myFieldHospitals.add(fhD);

        //testing out the method that ranks my list of field hospitals according to the given poi
        top3FieldHospitalsCalculator(myFieldHospitals, poi);

    }

    /*
    Description: Calculates the weighed sum for a given set of weights and factors for a given field hospital
    Input: vector of weights, field hospital
    Output: weightedSum
     */
    public static double weightedSumCalculator(Vector<Double> weights, FieldHospital myFH) { //TODO test this next, see tests that are failing and check that the route distance is right
        double weightedSum = 0;
        //loop through the weights
        for (int i = 0; i < weights.size(); i++) {
            //check that value of weight is not zero, if zero then skip that factor, else get value of weight
            if (weights.get(i) != 0.0) {
                /* multiply the value of the weight by its coordinating factor (corresponding factors and weights should
                have the same index i) and make that the value of weighted sum */
                weightedSum += weights.get(i) * myFH.factors.get(i); //TODO factors need to figure out how to make
                                                                        // it get the right factor for locations
                                                                        // a, b, c, d
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
    public static ArrayList<String> top3FieldHospitalsCalculator(LinkedList<FieldHospital> fieldHospitals, Pinpoint poi) {
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        HashMap<FieldHospital, Double> allFHWeightedSums = new HashMap<FieldHospital, Double>();
        ArrayList<String> top3FH = new ArrayList<>();
        double first, second, third;

        /* loop through list of field hospitals to put them into a hashmap with the field hospital names as the keys
        and the weighted sums as the values */
        for (FieldHospital fh : fieldHospitals) {
            //get weighted sum for each field hospital
            double thisWeightedSum = weightedSumCalculator(myWeights, fh);
            //add each fh with its weighted sum to a hashmap
            allFHWeightedSums.put(fh, thisWeightedSum);
        }

        // Check if list of field hospitals is zero or less and stops if true
        if (allFHWeightedSums.size() < 1) {
            System.out.println("Invalid input");
        }

        //setting the first, second, and third values to be a high value
        first = second = third = Integer.MAX_VALUE;
        //loop through the values of the hashmap and save the 3 fh's with the least weighted sums to a linked list
        for (Map.Entry<FieldHospital, Double> entry : allFHWeightedSums.entrySet()) {
            /* If current value is smaller than first
              then update first, second, and third */
            if (entry.getValue() < first) {

                third = second = first;
                //set value of first to the weighted sum of this best entry (least weighted sum)
                first = entry.getValue();
                //add the name of the best field hospital to a list of the top 3 field hospitals
                top3FH.add(entry.getKey().getFHName());

                /* If allFHWeightedSums.get(i) is in between first and second
               then update second  */
            } else if (entry.getValue() < second && entry.getValue() != first) {
                //set value of second to the weighted sum of second best this entry (second least weighted sum)
                second = entry.getValue();
                //add the name of the second best field hospital to a list of the top 3 field hospitals
                top3FH.add(entry.getKey().getFHName());

                /* If allFHWeightedSums.get(i) is in between second and third
               then update third  */
            } else {
                if (entry.getValue() < third && entry.getValue() != second && entry.getValue() != first) {
                    //set value of third to the weighted sum of third best this entry (third least weighted sum)
                    third = entry.getValue();
                    //add the name of the third best field hospital to a list of the top 3 field hospitals
                    top3FH.add(entry.getKey().getFHName());
                }
            }
        }

        //print out the weighted sums of the field hospitals in ranked order
        //there are only two field hospitals provided
        if (third == Integer.MAX_VALUE) {
            System.out.println("There is no third smallest element");
            System.out.println("The smallest element is " + first + " and second Smallest" + " element is " + second);
            //there is only one field hospital provided
        } else if (second == Integer.MAX_VALUE && third == Integer.MAX_VALUE) {
            System.out.println("There is no second or third smallest element");
            System.out.println("The smallest element is " + first);
            //there are at least 3 field hospitals provided
        } else {
            System.out.println("The smallest element is " + first + " and second Smallest" +
                    " element is " + second + " and third Smallest" +
                    " element is " + third);
        }

        //return the names of the best three field hospitals in order
        return top3FH;
    }

    //FACTOR METHODS
    //method to calculate the danger level of the route from a poi to a given field hospital
    //dummy method currently
    public double getDanger() {
        return this.danger = 0.8;
    }

    //method to calculate the unavailability level of the route from a poi to a given field hospital
    //dummy method currently
    public double getUnavailability() {
        return this.unavailability = 0.8;
    }

    //method to calculate the distance of the route from a poi to a given field hospital
    //this seems to work; test passes
    public double getRouteDistance(Pinpoint fHLocation, Pinpoint poi) {
        return Pinpoint.eDistance(fHLocation, poi);
    }


    //GETTER AND SETTER METHODS
    //getter for field hospital name
    public String getFHName(){
        return this.fHName;
    }

    //setter for field hospital name
    public void setFHName(String fHName){
        this.fHName = fHName;
    }

    //getter for field hospital location/coordinates
    public Pinpoint getFHLocation(){
        return this.fHLocation;
    }

    //setter for field hospital location/coordinates
    public void setfHLocation(Pinpoint fHLocation){
        this.fHLocation = fHLocation;
    }


}
