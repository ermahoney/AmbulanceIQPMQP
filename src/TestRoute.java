import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TestRoute {
    //different numbers of factors by changing number of weights
    //different numbers of weights different values for weights

    @Test
    void testWeightedSumThreeWeightsInitialWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        assertEquals(1.2000000000000002, Route.weightedSumCalculator(myWeights, 3, myRoute));
    }

    @Test
    void testWeightedSumThreeWeightsDiffWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(1.0);
        myWeights.add(1.0);
        myWeights.add(1.0);
        assertEquals(2.4000000000000004, Route.weightedSumCalculator(myWeights, 3, myRoute));
    }

    @Test
    void testWeightedSumThreeWeightsZeroWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.0);
        myWeights.add(0.0);
        myWeights.add(0.0);
        assertEquals(0.0, Route.weightedSumCalculator(myWeights, 3, myRoute));
    }

    @Test
    void testWeightedSumTwoWeightsInitialWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        assertEquals(0.6000000000000001, Route.weightedSumCalculator(myWeights, 2, myRoute));
    }

    @Test
    void testWeightedSumTwoWeightsDiffWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(1.0);
        myWeights.add(1.0);
        assertEquals(1.6, Route.weightedSumCalculator(myWeights, 2, myRoute));
    }

    @Test
    void testWeightedSumTwoWeightsZeroWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.0);
        myWeights.add(0.0);
        assertEquals(0.0, Route.weightedSumCalculator(myWeights, 2, myRoute));
    }

    @Test
    void testWeightedSumOneWeightInitialWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.25);
        assertEquals(0.2, Route.weightedSumCalculator(myWeights, 1, myRoute));
    }

    @Test
    void testWeightedSumOneWeightDiffWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(1.0);
        assertEquals(0.8, Route.weightedSumCalculator(myWeights, 1, myRoute));
    }

    @Test
    void testWeightedSumOneWeightZeroWeightValues() {
        Route myRoute = new Route();
        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.0);
        assertEquals(0.0, Route.weightedSumCalculator(myWeights, 1, myRoute));
    }

}