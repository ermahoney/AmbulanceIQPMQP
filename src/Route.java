import java.util.Vector;

public class Route {
    public double danger;
    public double unavailability;
    public double routeDistance;

    public Route(){
        this.danger = danger;
        this.unavailability = unavailability;
        this.routeDistance = routeDistance;
    }

    public static void main (String[] args){

        Route route1 = new Route();

        Vector<Double> myWeights = new Vector<Double>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);
        //testing out weighted sum calculator
        double routeScore = weightedSumCalculator(myWeights, 3, route1);
        System.out.println("The route score for route1 is: " + routeScore);
    }

    //number of factors is specified at runtime
    //input: weights, numWeights
    //output: sum
    //for a given route, do factor methods times each weight and add up
    public static double weightedSumCalculator( Vector<Double> weights, int numWeights, Route route){
        weights.setSize(numWeights);
        double weightedSum = 0;
        for( int i = 0; i < weights.size(); i++ ){
            if( i == 0 ){
                weightedSum += weights.get(i) * route.getDanger();
            } else if( i == 1 ){
                weightedSum += weights.get(i) * route.getUnavailability();
            } else if( i == 2 ){
                weightedSum += weights.get(i) * route.getRouteDistance();
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
