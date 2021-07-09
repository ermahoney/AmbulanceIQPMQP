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
    void testEuclideanDist() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(11.661903789690601, Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testEuclideanDistFail() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertNotEquals(16.0, Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testEuclideanDistSameSpot() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(0.0, Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testEuclideanDistSameSpotFail() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertNotEquals(1.0, Pinpoint.eDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testManhattanDist() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(16.0, Pinpoint.mDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testManhattanDistFail() {
        Pinpoint pinpoint1 = new Pinpoint(-3,-5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertNotEquals(11.661903789690601, Pinpoint.mDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testManhattanDistSameSpot() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertEquals(0.0, Pinpoint.mDistance(pinpoint1, pinpoint2));
    }

    @Test
    void testManhattanDistSameSpotFail() {
        Pinpoint pinpoint1 = new Pinpoint(3,5);
        Pinpoint pinpoint2 = new Pinpoint(3,5);
        assertNotEquals(1.0, Pinpoint.mDistance(pinpoint1, pinpoint2));
    }
}
