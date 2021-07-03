import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class FieldHospital {
    private String fHName;
    private double danger;
    private double unavailability;
    private double routeDistance;
    public static LinkedList<Double> factors;
    public static LinkedList<String> fieldHospitals;
    public static double poi;


    public FieldHospital(LinkedList<Double> factors) {
        this.fHName = fHName;
        this.danger = getDanger();
        this.unavailability = getUnavailability();
        this.routeDistance = getRouteDistance();
    }

    public static void main(String[] args) {
        factors = new LinkedList<>();
        FieldHospital fh1 = new FieldHospital(factors);

        factors.add(0, fh1.getDanger());
        factors.add(1, fh1.getUnavailability());
        factors.add(2, fh1.getRouteDistance());

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        //testing out weighted sum calculator
        double fH1WeightedDesirablity = weightedSumCalculator(myWeights, fh1);
        System.out.println("The route score for the given weight values is: " + fH1WeightedDesirablity);

        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        FieldHospital fhA = new FieldHospital(factors);
        FieldHospital fhB = new FieldHospital(factors);
        FieldHospital fhC = new FieldHospital(factors);
        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);
        //TODO: change poi to have type of coordinates and make getDistance take in poi for calculation of euclidean
        //TODO: give FieldHospitals coordinates of their own locations
        poi = 0.6;
        top3FieldHospitalsCalculator(myFieldHospitals, poi);

    }

    //number of factors is specified at runtime
    //input: weights, route
    //output: weightedSum
    //for a given route, do factor methods times each weight and add up
    public static double weightedSumCalculator(Vector<Double> weights, FieldHospital myRoute) {
        double weightedSum = 0;
        for (int i = 0; i < weights.size(); i++) {
            if (weights.get(i) != 0.0) {
                weightedSum += weights.get(i) * myRoute.factors.get(i);
            }
        }
        return weightedSum;
    }

    //input: list of field hospitals, poi
    //output: list of best 3 field hospitals
    //calculate weighted desirability with respect to point of injury
    public static ArrayList<FieldHospital> top3FieldHospitalsCalculator(LinkedList<FieldHospital> fieldHospitals, double poi) {
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        HashMap<FieldHospital, Double> allFHWeightedSums = new HashMap<FieldHospital, Double>();
        ArrayList<FieldHospital> top3FH = new ArrayList<>();
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
                top3FH.add(entry.getKey());
                /* If allFHWeightedSums.get(i) is in between first and second
               then update second  */
            } else if (entry.getValue() < second && entry.getValue() != first) {
                second = entry.getValue();
                top3FH.add(entry.getKey());
                /* If allFHWeightedSums.get(i) is in between second and third
               then update third  */
            } else {
                if (entry.getValue() < third && entry.getValue() != second) {
                    third = entry.getValue();
                    top3FH.add(entry.getKey());
                }
            }
            if (third == Integer.MAX_VALUE) {
                System.out.println("There is no third" +
                        "smallest element");
            } else if (second == Integer.MAX_VALUE) {
                System.out.println("There is no second" +
                        "smallest element");
            } else {
                System.out.println("The smallest element is " + first + " and second Smallest" +
                        " element is " + second + " and third Smallest" +
                        " element is " + third);

            }
        }
        //TODO
        //i need to figure out how to get the key associated with the values first, second, and third to put them in the
        //top3FH linked list
        //should I switch to an arraylist? or some other version of a hashmap?
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

    public double getDanger() {
        return this.danger = 0.8;
    }

    public double getUnavailability() {
        return this.unavailability = 0.8;
    }

    public double getRouteDistance() {
        return this.routeDistance = 0.8;
    }
}
