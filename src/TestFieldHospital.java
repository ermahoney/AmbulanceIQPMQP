import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TestFieldHospital {

    @Test
    void testWeightedSumThreeWeights() {

        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        assertEquals(1.2000000000000002, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsFirstOneZero() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(1.0);
        myWeights.add(1.0);
        assertEquals(1.6, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsSecondOneZero() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        myWeights.add(0.75);
        assertEquals(0.8, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumThreeWeightsThirdOneZero() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.0);
        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeights() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeightsFirstZero() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);
        assertEquals(0.4, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumTwoWeightsSecondZero() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumOneWeight() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    void testWeightedSumOneWeightZeroWeightValues() {
        FieldHospital.factors = new LinkedList<>();
        FieldHospital myFH = new FieldHospital(FieldHospital.factors);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        assertEquals(0.0, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

}