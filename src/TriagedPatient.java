package src.triage;

/**
 * @author Emily Mahoney, Alex Miera
 * @version %I% %G%
*/

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
        
    }

    /** Function that calculates the patients likelyhood of survival, i.e. 
     *  retrievable welfare
     * 
     * @note number of factors is specified at runtime
     * 
     * @param weights
     * @param triagedPatient
     * @return weightedSum
     * @note low triage weight = green to yellow tag
     *       high triage weight = red to black tag
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

    /** Function that gets the time it takes to transfer the patient from the
     *  ground to the field hospital starting at the time a distress signal
     *  was sent to EMS (t_r) and ending at the time of arrival at a field 
     *  hospital (s_rh)
     * 
     * @param void
     * @return extractionTime
     * @note extractionTime is in min
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