import java.util.LinkedList;
import java.util.Vector;

public class Production {
    public void prod(String args[]){
        //WEIGHTED SUM
        //setting my poi to be at the origin
        Pinpoint poi = new Pinpoint(0,0);
        //making a field hospital with factors and a location
        Pinpoint locationFH1 = new Pinpoint(-3,-5);
        LinkedList<Double> factors1 = new LinkedList<>();
        FieldHospital fh1 = new FieldHospital();

        //adding my 3 factors to a list of factors
        factors1.add(0, fh1.danger());
        factors1.add(1, fh1.unavailability());
        factors1.add(2, fh1.routeDistance(locationFH1, poi));

        //making a vector of 3 weights for the 3 factors
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);

        //testing out the method that calculates the weighted sum of the factors for a given field hospital and weights
        //double fH1WeightedDesirablity = weightedSumCalculator(myWeights, fh1);
        //System.out.println("The route score for the given weight values is: " + fH1WeightedDesirablity);


        //TOP 3 FIELD HOSPITALS
        //making 4 samples of field hospitals
        //Field Hospital A
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital();
        fhA.setFHName("The A FH");
        factorsA.add(0, fhA.danger());
        factorsA.add(1, fhA.unavailability());
        factorsA.add(2, fhA.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);


        //Field Hospital B
        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setFHName("The B FH");
        factorsB.add(0, fhB.danger());
        factorsB.add(1, fhB.unavailability());
        factorsB.add(2, fhB.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);


        //Field Hospital C
        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(10,10);
        FieldHospital fhC = new FieldHospital();
        fhC.setFHName("The C FH");
        factorsC.add(0, fhC.danger());
        factorsC.add(1, fhC.unavailability());
        factorsC.add(2, fhC.routeDistance(locationC, poi));
        fhC.setFactors(factorsC);


        //adding the 3 sample field hospitals to a list
        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);

        //testing out the method that ranks my list of field hospitals according to the given poi
        FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals));

    }
}
