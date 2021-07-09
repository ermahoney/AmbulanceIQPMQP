import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/*
============================================================================
Name : TestFieldHospital.java
Author : Emily Mahoney
Version :
Copyright : Your copyright notice
Description : tests for weightedSumCalculator and top3FieldHospitalsCalculator in Java
============================================================================
*/

public class TestFieldHospital {

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
    }





    //Testing weightedSumCalculator()
    @Test
    //tests when 3 weights of values not zero are given
    void testWeightedSumThreeWeights() {

        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);

        assertEquals(7.35, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 3 weights, first one zero other two not, are given
    void testWeightedSumThreeWeightsFirstOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);
        myWeights.add(0.75);

        assertEquals(7.15, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 3 weights, second one zero other two not, are given
    void testWeightedSumThreeWeightsSecondOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        myWeights.add(0.75);

        assertEquals(6.95, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 3 weights, third one zero other two not, are given
    void testWeightedSumThreeWeightsThirdOneZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.0);

        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 2 weights, both not zero, are given
    void testWeightedSumTwoWeights() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);

        assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 2 weights, first zero second not, are given
    void testWeightedSumTwoWeightsFirstZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);

        assertEquals(0.4, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 2 weights, second zero first not, are given
    void testWeightedSumTwoWeightsSecondZero() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);
        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);

        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 1 weight, not zero, is given
    void testWeightedSumOneWeight() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);

        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);

        assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }

    @Test
    //tests when 1 weight, that is zero, is given
    void testWeightedSumOneWeightZeroWeightValues() {
        FieldHospital.factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,9);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital(FieldHospital.factors, locationMyFH, poi);

        FieldHospital.factors.add(0, myFH.getDanger());
        FieldHospital.factors.add(1, myFH.getUnavailability());
        FieldHospital.factors.add(2, myFH.getRouteDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);

        assertEquals(0.0, FieldHospital.weightedSumCalculator(myWeights, myFH));
    }


    //Testing top3FieldHospitalsCalculator()
    @Test
    //first test, just want top3fh to fail, which it does. currently working on debugging
    void testTop3FHJustFails(){

        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,9);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital(factorsA, locationA, poi); //TODO is this getting the wrong location for factors? (see line 33)
        fhA.setFHName("The A FH");
        factorsA.add(0, fhA.getDanger());
        factorsA.add(1, fhA.getUnavailability());
        factorsA.add(2, fhA.getRouteDistance(locationA, poi));

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,11);
        FieldHospital fhB = new FieldHospital(factorsB, locationB, poi);
        fhB.setFHName("The B FH");
        factorsB.add(0, fhB.getDanger());
        factorsB.add(1, fhB.getUnavailability());
        factorsB.add(2, fhB.getRouteDistance(locationB, poi));

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(3,6);
        FieldHospital fhC = new FieldHospital(factorsC, locationC, poi);
        fhC.setFHName("The C FH");
        factorsC.add(0, fhC.getDanger());
        factorsC.add(1, fhC.getUnavailability());
        factorsC.add(2, fhC.getRouteDistance(locationC, poi));

        LinkedList<Double> factorsD = new LinkedList<>();
        Pinpoint locationD = new Pinpoint(7,0);
        FieldHospital fhD = new FieldHospital(factorsD, locationD, poi);
        fhD.setFHName("The D FH");
        factorsD.add(0, fhD.getDanger());
        factorsD.add(1, fhD.getUnavailability());
        factorsD.add(2, fhD.getRouteDistance(locationD, poi));

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);
        myFieldHospitals.add(fhD);

        List<String> bestFHs = asList("The C FH", "The B FH", "The A FH");
        assertFalse(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, poi).equals(bestFHs));
    }

    //Testing getDanger()
    @Test
    //tests dummy function returns 0.8 for the danger factor of a field hospital
    public void testGetDangerDummy(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(0.8, fH.getDanger());
    }

    //Testing getUnavailability()
    @Test
    //tests dummy function returns 0.8 for the unavailability factor of a field hospital
    public void testGetUnavailabilityDummy(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(0.8, fH.getUnavailability());
    }

    //Testing getRouteDistance()
    @Test
    //tests field hospital has positive X value
    public void testGetRouteDistancePosX(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(5.0, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has positive y value
    public void testGetRouteDistancePosY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, 5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(5.0, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has positive xy values
    public void testGetRouteDistancePosXY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(7.0710678118654755, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has negative y value
    public void testGetRouteDistanceNegY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, -5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(5.0, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has negative x value
    public void testGetRouteDistanceNegX(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(-5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(5.0, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has negative xy values
    public void testGetRouteDistanceNegXY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(-5, -5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(7.0710678118654755, fH.getRouteDistance(fHLocation, poi));
    }

    @Test
    //tests poi and field hospital in same location
    public void testGetRouteDistanceSameSpot(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital(factorsFH, fHLocation, poi);
        fH.setFHName("The FH");
        factorsFH.add(0, fH.getDanger());
        factorsFH.add(1, fH.getUnavailability());
        factorsFH.add(2, fH.getRouteDistance(fHLocation, poi));
        assertEquals(0.0, fH.getRouteDistance(fHLocation, poi));
    }


}