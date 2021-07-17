import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
============================================================================
Name : TestPinpoint.java
Author : Emily Mahoney
Version :
Copyright : Your copyright notice
Description : tests for eDistance and mDistance in Java
============================================================================
*/

public class TestPinpoint {

    @Test
    Boolean testEuclideanDist() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(11.661903789690601, Pinpoint.eDistance(pinpoint1, pinpoint2));
        return (11.0 <= Pinpoint.eDistance(pinpoint1, pinpoint2) && 12.0 >= Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    Boolean testEuclideanDistSameSpot() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(0.0, Pinpoint.eDistance(pinpoint1, pinpoint2));
        return (-1.0 <= Pinpoint.eDistance(pinpoint1, pinpoint2) && 1.0 >= Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    Boolean testManhattanDist() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(16.0, Pinpoint.mDistance(pinpoint1, pinpoint2));
        return (15.0 <= Pinpoint.mDistance(pinpoint1, pinpoint2) && 17.0 >= Pinpoint.mDistance(pinpoint1, pinpoint2));
    }

    @Test
    Boolean testManhattanDistSameSpot() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(0.0, Pinpoint.mDistance(pinpoint1, pinpoint2));
        return (-1.0 <= Pinpoint.mDistance(pinpoint1, pinpoint2) && 1.0 >= Pinpoint.mDistance(pinpoint1, pinpoint2));
    }

}
