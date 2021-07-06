import java.util.*;

public class FieldHospital {
    private String fHName;
    private Pinpoint fHLocation;
    private double danger;
    private double unavailability;
    private double routeDistance;
    public static LinkedList<Double> factors;
    public static LinkedList<String> fieldHospitals;


    public FieldHospital(LinkedList<Double> factors, Pinpoint fHLocation, Pinpoint poi) {
        this.fHName = fHName;
        this.factors = factors;
        this.fHLocation = fHLocation;
        this.danger = getDanger();
        this.unavailability = getUnavailability();
        this.routeDistance = getRouteDistance(fHLocation, poi);
    }

    public static void main(String[] args) {
        LinkedList<Double> factors1 = new LinkedList<>();
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint locationFH1 = new Pinpoint(-3,-5);
        FieldHospital fh1 = new FieldHospital(factors1, locationFH1, poi);

        factors1.add(0, fh1.getDanger());
        factors1.add(1, fh1.getUnavailability());
        factors1.add(2, fh1.getRouteDistance(locationFH1, poi));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        //testing out weighted sum calculator
        double fH1WeightedDesirablity = weightedSumCalculator(myWeights, fh1);
        System.out.println("The route score for the given weight values is: " + fH1WeightedDesirablity);

        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,9);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital(factorsA, locationA, poi); //TODO is this getting the wrong location for factors? (see line 33)
        fhA.setFHName("The A FH");
        factorsA.add(0, fhA.getDanger());
        factorsA.add(1, fhA.getUnavailability());
        factorsA.add(2, fhA.getRouteDistance(locationA, poi));

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,11);
        FieldHospital fhB = new FieldHospital(factorsB, locationB, poi);
        fhB.setFHName("The B FH");
        factorsB.add(0, fhB.getDanger());
        factorsB.add(1, fhB.getUnavailability());
        factorsB.add(2, fhB.getRouteDistance(locationB, poi));

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(3,6);
        FieldHospital fhC = new FieldHospital(factorsC, locationC, poi);
        fhC.setFHName("The C FH");
        factorsC.add(0, fhC.getDanger());
        factorsC.add(1, fhC.getUnavailability());
        factorsC.add(2, fhC.getRouteDistance(locationC, poi));

        LinkedList<Double> factorsD = new LinkedList<>();
        Pinpoint locationD = new Pinpoint(7,0);
        FieldHospital fhD = new FieldHospital(factorsD, locationD, poi);
        fhD.setFHName("The D FH");
        factorsD.add(0, fhD.getDanger());
        factorsD.add(1, fhD.getUnavailability());
        factorsD.add(2, fhD.getRouteDistance(locationD, poi));

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);
        myFieldHospitals.add(fhD);

        top3FieldHospitalsCalculator(myFieldHospitals, poi);

    }

    //number of factors is specified at runtime
    //input: weights, route
    //output: weightedSum
    //for a given route, do factor methods times each weight and add up
    public static double weightedSumCalculator(Vector<Double> weights, FieldHospital myFH) {
        double weightedSum = 0;
        for (int i = 0; i < weights.size(); i++) {
            if (weights.get(i) != 0.0) {
                weightedSum += weights.get(i) * myFH.factors.get(i); //TODO factors need to figure out how to make
                                                                        // it get the right factor for locations
                                                                        // a, b, c, d
            }
        }
        return weightedSum;
    }

    //input: list of field hospitals, poi
    //output: list of best 3 field hospitals
    //calculate weighted desirability with respect to point of injury
    public static ArrayList<String> top3FieldHospitalsCalculator(LinkedList<FieldHospital> fieldHospitals, Pinpoint poi) {
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        HashMap<FieldHospital, Double> allFHWeightedSums = new HashMap<FieldHospital, Double>();
        ArrayList<String> top3FH = new ArrayList<>();
        double first, second, third;

        for (FieldHospital fh : fieldHospitals) {
            double thisWeightedSum = weightedSumCalculator(myWeights, fh); //get weighted sum for each field hospital
            allFHWeightedSums.put(fh, thisWeightedSum); //add each fh with its weighted sum to a hashmap
        }

        if (allFHWeightedSums.size() < 3) {
            System.out.println("Invalid input");
        }

        first = second = third = Integer.MAX_VALUE;
        //now we need to check the values of the hashmap and save the 3 fh's with the least weighted sums to a linked list
        for (Map.Entry<FieldHospital, Double> entry : allFHWeightedSums.entrySet()) {

            if (entry.getValue() < first) {
                /* If current value is smaller than first
              then update first, second, and third */
                third = second = first;
                first = entry.getValue();
                top3FH.add(entry.getKey().getFHName());
                /* If allFHWeightedSums.get(i) is in between first and second
               then update second  */
            } else if (entry.getValue() < second && entry.getValue() != first) {
                second = entry.getValue();
                top3FH.add(entry.getKey().getFHName());
                /* If allFHWeightedSums.get(i) is in between second and third
               then update third  */
            } else {
                if (entry.getValue() < third && entry.getValue() != second && entry.getValue() != first) {
                    third = entry.getValue();
                    top3FH.add(entry.getKey().getFHName());
                }
            }
        }

        if (third == Integer.MAX_VALUE) {
            System.out.println("There is no third smallest element");
        } else if (second == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest element");
        } else {
            System.out.println("The smallest element is " + first + " and second Smallest" +
                    " element is " + second + " and third Smallest" +
                    " element is " + third);
        }

        return top3FH;
    }


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

    public double getDanger() {
        return this.danger = 0.8;
    }

    public double getUnavailability() {
        return this.unavailability = 0.8;
    }

    public double getRouteDistance(Pinpoint fHLocation, Pinpoint poi) {
        return Pinpoint.eDistance(fHLocation, poi);
    }
}
