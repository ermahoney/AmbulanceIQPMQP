import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import static java.util.Arrays.asList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TestFieldHospital {

    //Testing top3FHCalculator
    @Test
    void testTop3FHJustWorks(){

        Pinpoint poi = new Pinpoint(0,0);
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
        factorsA.add(0, fhB.getDanger());
        factorsA.add(1, fhB.getUnavailability());
        factorsA.add(2, fhB.getRouteDistance(locationB, poi));

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

        List<String> bestFHs = asList("The C FH", "The B FH", "The A FH");
        assertTrue(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, poi).equals(bestFHs));
    }



    //Testing WeightedSumCalculator
    @Test
    void testWeightedSumThreeWeights() {

        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);

        assertEquals(1.2000000000000002, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsFirstOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(1.0);
        myWeights.add(1.0);

        assertEquals(1.6, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsSecondOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        myWeights.add(0.75);

        assertEquals(0.8, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsThirdOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.0);

        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeights() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);

        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeightsFirstZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);

        assertEquals(0.4, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeightsSecondZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);

        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumOneWeight() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);

        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);

        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumOneWeightZeroWeightValues() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);

        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);

        assertEquals(0.0, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

}