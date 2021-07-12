/* Authors: Emily Mahoney, Alex Miera */
/* Creation date: July 11, 2021 */
/* Last edited: July 11, 2021 */

import java.util.LinkedList;
import java.util.Vector;

public class TriagedPatient {
    /* Declares variables that make up retrievable welfare */
    public static double extractionTime; /* Declares the time it will take to 
                                            extract the patient */

    public static LinkedList<Double> factors; /* Declares factors that make up 
                                                 triaged patient object */

    /* Declares triaged patient object */
    public TriagedPatient(LinkedList<Double> factors) {
        this.extractionTime = getExtractionTime()
    }

    public static void main (String[] args) {
        /* Defines variables that make up retrivable welfare at runtime */
        extractionTime = getExtractionTime();

        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        factors = new LinkedList<>();
        TriagedPatient patient1 = new TriagedPatient(factors);
        factors.add(0, patient1.getExtractionTime());

        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.25);

        /* Tests weighted sum caclulator */
        double retrievableWelfare = 
            calculateRetrievableWelfare(weights, patient1);
        System.out.println("The patient triage weight for the given weight values is: " + retrievableWelfare);
    }

    /* Function that calculates the patients likelyhood of survival, i.e. 
       retrievable welfare
     * 
     * Note: number of factors is specified at runtime
     * 
     * Input: weights, triaged patient
     * Output: triage weight
               low triage weight = green to yellow tag
               hight triage weight = red to black tag
    */
    public static double calculateRetrievableWelfare(Vector<Double> weights, TriagedPatient triagedPatient){
        double weightedSum = 0;

        for( int i = 0; i < weights.size(); i++ ){
            if( weights.get(i) != 0.0){
                weightedSum += weights.get(i) * triagedPatient.factors.get(i);
            }
        }
        return weightedSum;
    }

    /* Function that gets the time it takes to transfer the patient from the
     * ground to the field hospital starting at the time of injury (t_i) 
     * and ending at the time of arrival at a field hospital (s_rh)
     * 
     * Input: void
     * Output: extraction time in min
    */
    public static double getExtractionTime() {
        return 70;
    }
}