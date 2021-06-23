import java.util.LinkedList;
import java.util.Vector;

public class Route {
    public static double danger;
    public static double unavailability;
    public static double routeDistance;
    public static LinkedList<Double> factors;


    public Route(LinkedList<Double> factors){
        this.danger = getDanger();
        this.unavailability = getUnavailability();
        this.routeDistance = getRouteDistance();
    }

    public static void main (String[] args){
        factors = new LinkedList<>();
        Route route1 = new Route(factors);

        factors.add(0, route1.getDanger());
        factors.add(1, route1.getUnavailability());
        factors.add(2, route1.getRouteDistance());

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        //testing out weighted sum calculator
        double routeScore = weightedSumCalculator(myWeights, route1);
        System.out.println("The route score for the given weight values is: " + routeScore);
    }

    //number of factors is specified at runtime
    //input: weights, route
    //output: weightedSum
    //for a given route, do factor methods times each weight and add up
    public static double weightedSumCalculator( Vector<Double> weights, Route myRoute){
        double weightedSum = 0;
        for( int i = 0; i < weights.size(); i++ ){
            if( weights.get(i) == 0.0){
                continue;
            } else {
                weightedSum += weights.get(i) * myRoute.factors.get(i);
            }
        }
        return weightedSum;
    }

    public double getDanger(){
        return this.danger = 0.8;
    }

    public double getUnavailability(){
        return this.unavailability = 0.8;
    }

    public double getRouteDistance(){
        return this.routeDistance = 0.8;
    }
}
