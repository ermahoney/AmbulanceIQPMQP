/* Authors: Emily Mahoney, Alex Miera */
/* Creation date: July 11, 2021 */
/* Last edited: July 11, 2021 */

import java.util.LinkedList;
import java.util.Vector;

public class TriagedPatient {
    /* Declares variables that make up retrievable welfare */
    public static double extractionTime; /* Declares the time it will take to 
                                            extract the patient */
    public static double burnPercent;
    public static double respirationRate;
    public static double tidalVolume;
    public static double pulse;
    public static double systolicPressure;
    public static double diastolicPressure;
    public static double temperature;
    public static double bloodOxygen;

    public static LinkedList<Double> factors; /* Declares factors that make up 
                                                 triaged patient object */

    /* Declares triaged patient object */
    public TriagedPatient(LinkedList<Double> factors) {
        this.extractionTime = getExtractionTime();
        this.burnPercent = getBurnPercent();
        this.respirationRate = getRespirationRate();
        this.tidalVolume = getTidalVolume();
        this.pulse = getPulse();
        this.systolicPressure = getSystolicPressure();
        this.diastolicPressure = getDiastolicPressure();
        this.temperature = getTemperature();
        this.bloodOxygen = getBloodOxygen();
    }

    public static void main (String[] args) {
        /* Defines variables that make up retrivable welfare at runtime */
        extractionTime = getExtractionTime();

        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        factors = new LinkedList<>();
        TriagedPatient patient = new TriagedPatient(factors);
        factors.add(0, patient.getExtractionTime());
        factors.add(1, patient.getBurnPercent());
        factors.add(2, patient.getRespirationRate());
        factors.add(3, patient.getTidalVolume());
        factors.add(4, patient.getPulse());
        factors.add(5, patient.getSystolicPressure());
        factors.add(6, patient.getDiastolicPressure());
        factors.add(7, patient.getTemperature());
        factors.add(8, patient.getBloodOxygen());

        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.4);
        weights.add(0.5);
        weights.add(0.15);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.2);
        weights.add(0.1);
        weights.add(0.05);
        weights.add(0.35);

        /* Tests weighted sum caclulator */
        double retrievableWelfare = 
            calculateRetrievableWelfare(weights, patient);
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
     * ground to the field hospital starting at the time a distress signal
     * was sent to EMS (t_r) and ending at the time of arrival at a field 
     * hospital (s_rh)
     * 
     * Input: void
     * Output: extraction time in min
    */
    public static double getExtractionTime() {
        return 70;
    }

    public static double getBurnPercent() {
        return 90.9;
    }

    public static double getRespirationRate() {
        return 20;
    }

    public static double getTidalVolume() {
        return 8;
    }

    public static double getPulse() {
        return 70;
    }

    public static double getSystolicPressure() {
        return 115;
    }

    public static double getDiastolicPressure() {
        return 70;
    }

    public static double getTemperature() {
        return 99.5;
    }

    public static double getBloodOxygen() {
        return 99;
    }
}