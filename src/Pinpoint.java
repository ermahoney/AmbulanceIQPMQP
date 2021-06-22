public class Pinpoint {

    public final double x;
    public final double y;

    public Pinpoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static void main (String[] args){
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);

        //testing out Euclidean distance calculator
        double eDistPinpoints = eDistance(pinpoint1, pinpoint2);

        //testing out Manhattan distance calculator
        double mDistPinpoints = mDistance(pinpoint1, pinpoint2);
        System.out.print("For points (" + pinpoint1.x + "," + pinpoint1.y + ") and (" + pinpoint2.x + "," + pinpoint2.y + "), Euclidean Distance = " + eDistPinpoints + " and Manhattan Distance = " + mDistPinpoints);
    }

    //Euclidean distance calculator
    public static double eDistance(Pinpoint pinpoint1, Pinpoint pinpoint2){
        double x = Math.pow(pinpoint2.x - pinpoint1.x, 2);
        double y = Math.pow(pinpoint2.y - pinpoint1.y, 2);
        return Math.sqrt(x + y);
    }

    //Manhattan distance calculator
    public static double mDistance(Pinpoint pinpoint1, Pinpoint pinpoint2){
        return Math.abs(pinpoint2.x - pinpoint1.x) + Math.abs(pinpoint2.y - pinpoint1.y);
    }

}
