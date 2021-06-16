public class EuclideanDistanceCalculator {
    public static void main (String[] args){
        double lat1 = 3;
        double long1 = 3;
        double lat2 = 3;
        double long2 = 0;
        double distLatLong = distance(lat1, long1, lat2, long2);
        System.out.print(distLatLong);
    }

    public static double distance(double x1, double x2, double y1, double y2){
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        double dist = Math.sqrt(x + y);
        return dist;
    }
}
