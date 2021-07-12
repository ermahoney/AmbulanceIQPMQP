// Authors: Emily Mahoney, Alex Miera
// Creation date: June 5, 2021
// Last edited: June 5, 2021

import java.util.LinkedList;
import java.util.Vector;

public class TriagedPatient {
    public static double retrievableWelfare; // Declares the factor that will account for extraction time during triage
    public static double extractionTime; // Declares the time it will take to extract the patient
    public static LinkedList<Double> factors; // Declares factors that make up triaged patient object

    // Declares triaged patient object
    public TriagedPatient(LinkedList<Double> factors) {
        this.retrievableWelfare = getRetrievableWelfare(extractionTime);
    }

    public static void main (String[] args) {
        // Defines extraction time
        // Note: extraction time may need to be interrelated with Route.getRouteDistance();
        extractionTime = getExtractionTime();

        // Defines a triaged patient
        factors = new LinkedList<>();
        TriagedPatient patient1 = new TriagedPatient(factors);
        factors.add(0, patient1.getRetrievableWelfare(extractionTime));

        // Defines weights for each factor
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);

        // Tests weighted sum calculator
        double triageWeight = weightedSumCalculator(myWeights, patient1);
        System.out.println("The patient triage weight for the given weight values is: " + triageWeight);
    }

    // Note: number of factors is specified at runtime
    // Input: weights, triaged patient
    /* Output: triage weight
               low triage weight = green to yellow tag
               hight triage weight = red to black tag
    */
    public static double weightedSumCalculator( Vector<Double> weights, TriagedPatient myTriagedPatient){
        double weightedSum = 0;

        for( int i = 0; i < weights.size(); i++ ){
            if( weights.get(i) != 0.0){
                weightedSum += weights.get(i) * myTriagedPatient.factors.get(i);
            }
        }
        return weightedSum;
    }

    // Input: extraction time or the time it takes to get to the patient
    /* Output: retrievable welfare
               low retrievable welfare = positive patient outlook
               high retrievable welfare = negative patient outlook
    */
    public double getRetrievableWelfare(double extractionTime) {
        // Creates an array of 60 values according to the golden hour
        double time[] = new double[60];
        for (int i = 0; i < time.length; i++) {
            time[i] = i + 1;
        }

        // Maxes out retrievable welfare to golen hour limit
        if (extractionTime > 60) {
            return this.retrievableWelfare = 60;
        }

        return this.retrievableWelfare = extractionTime;
    }

    public static double getExtractionTime() {
        return 10;
    }
}
