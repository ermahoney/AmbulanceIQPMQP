public class DistanceCalculators {
    public static void main (String[] args){
        //lat = x, long = y
        double lat1 = 0;
        double long1 = 0;
        double lat2 = 7;
        double long2 = 6;

        //testing out Euclidean distance calculator
        double eDistLatLong = eDistance(lat1, lat2, long1, long2);


        //testing out Manhattan distance calculator
        double mDistLatLong = mDistance(lat1, lat2, long1, long2);
        System.out.print("For points (" + lat1 + "," + long1 + ") and (" + lat2 + "," + long2 + "), Euclidean Distance = " + eDistLatLong + " and Manhattan Distance = " + mDistLatLong);
    }

    //Euclidean distance calculator
    public static double eDistance(double x1, double x2, double y1, double y2){
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        double eDist = Math.sqrt(x + y);
        return eDist;
    }

    //Manhattan distance calculator
    public static double mDistance(double x1, double x2, double y1, double y2){
        double mDist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return mDist;
    }

}
