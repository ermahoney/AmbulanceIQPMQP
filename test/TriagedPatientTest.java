package test;

/**
 * @author Alex Miera
 * @version %I% %G%
*/

import java.util.LinkedList;
import java.util.Vector;
import org.junit.Test;
import src.triage.TriagedPatient;
import static org.junit.Assert.assertEquals;

public class TriagedPatientTest {

    @Test
    public void testRetrieveableWelfareCalculator () {
        testNineWeights();
        testOneWeight();
        testNoWeights();
        testNinthWeightZero();
        testFirstWeightZero();
        testAllWeightsZero();
    }
    
    public TriagedPatient createTriagedPatient() {
        TriagedPatient patient = new TriagedPatient(TriagedPatient.factors);
        TriagedPatient.factors.add(0, patient.getExtractionTime());
        TriagedPatient.factors.add(1, patient.getBurnPercent());
        TriagedPatient.factors.add(2, patient.getRespirationRate());
        TriagedPatient.factors.add(3, patient.getTidalVolume());
        TriagedPatient.factors.add(4, patient.getPulse());
        TriagedPatient.factors.add(5, patient.getSystolicPressure());
        TriagedPatient.factors.add(6, patient.getDiastolicPressure());
        TriagedPatient.factors.add(7, patient.getTemperature());
        TriagedPatient.factors.add(8, patient.getBloodOxygen());

        return patient;
    }

    @Test
    public void testNineWeights() {
        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();
   
        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.1);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.4);
        weights.add(0.5);
        weights.add(0.6);
        weights.add(0.7);
        weights.add(0.8);
        weights.add(0.9);

        assertEquals(356.08, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.01);
    }

    @Test
    public void testOneWeight() {
           /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();

        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.1);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.4);
        weights.add(0.5);

        assertEquals(69.38, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.01);
    }

    @Test
    public void testNoWeights() {
           /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();

        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();

        assertEquals(0.0, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.0);
    }

    @Test 
    public void testNinthWeightZero() {
        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();

        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.1);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.4);
        weights.add(0.5);
        weights.add(0.6);
        weights.add(0.7);
        weights.add(0.8);
        weights.add(0.0);

        assertEquals(266.98, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.01);
    }

    @Test
    public void testFirstWeightZero() {
        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();
   
        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.0);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.4);
        weights.add(0.5);
        weights.add(0.6);
        weights.add(0.7);
        weights.add(0.8);
        weights.add(0.9);

        assertEquals(349.08, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.01);
    }

    @Test
    public void testAllWeightsZero() {
        /* Defines a triaged patient and adds factors that will make up 
           retrievable welfare */
        TriagedPatient.factors = new LinkedList<>();
        TriagedPatient patient = createTriagedPatient();
   
        /* Defines a weight for each factor */
        Vector<Double> weights = new Vector<>();
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);
        weights.add(0.0);

        assertEquals(0.0, TriagedPatient.calculateRetrievableWelfare(weights, patient), 0.0);
    }
}