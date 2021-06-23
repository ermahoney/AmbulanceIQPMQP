import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TestRoute {

    @Test
    void testWeightedSumThreeWeights() {

        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        assertEquals(1.2000000000000002, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumThreeWeightsFirstOneZero() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(1.0);
        myWeights.add(1.0);
        assertEquals(1.6, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumThreeWeightsSecondOneZero() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        myWeights.add(0.75);
        assertEquals(0.8, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumThreeWeightsThirdOneZero() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.0);
        assertEquals(0.6000000000000001, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumTwoWeights() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        assertEquals(0.6000000000000001, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumTwoWeightsFirstZero() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);
        assertEquals(0.4, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumTwoWeightsSecondZero() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        assertEquals(0.2, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumOneWeight() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        assertEquals(0.2, Route.weightedSumCalculator(myWeights, myRoute));
    }

    @Test
    void testWeightedSumOneWeightZeroWeightValues() {
        Route.factors = new LinkedList<>();
        Route myRoute = new Route(Route.factors);
        Route.factors.add(0, myRoute.getDanger());
        Route.factors.add(1, myRoute.getUnavailability());
        Route.factors.add(2, myRoute.getRouteDistance());
        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        assertEquals(0.0, Route.weightedSumCalculator(myWeights, myRoute));
    }

}