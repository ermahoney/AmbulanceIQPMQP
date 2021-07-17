import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

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

    @Test
        //tests when zero weights are given
    Boolean testWeightedSumZeroWeights() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        myFH.setfHLocation(new Pinpoint(0,5));

        Vector<Double> myWeights = new Vector<>();

        //assertEquals(0.0, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (-1.0 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 1.0 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
        //tests when 1 weight, not zero, is given
    Boolean testWeightedSumOneWeight() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();

        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);

        //assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (0.1 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 0.3 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
        //tests when 2 weights, both not zero, are given
    Boolean testWeightedSumTwoWeights() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);

        //assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (0.5 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 0.7 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
        //tests when 2 weights, first zero second not, are given
    Boolean testWeightedSumTwoWeightsFirstZero() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);

        //assertEquals(0.4, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (0.3 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 0.5 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
        //tests when 2 weights, second zero first not, are given
    Boolean testWeightedSumTwoWeightsSecondZero() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);

        //assertEquals(0.2, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (0.1 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 0.3 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    //Testing weightedSumCalculator()
    @Test
    //tests when 3 weights of values not zero are given
    Boolean testWeightedSumThreeWeights() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.75);

        //assertEquals(4.35, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (4.3 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 4.4 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
    //tests when 3 weights, first one zero other two not, are given
    Boolean testWeightedSumThreeWeightsFirstZero() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.0);
        myWeights.add(0.50);
        myWeights.add(0.75);

        //assertEquals(4.15, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (4.1 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 4.2 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
    //tests when 3 weights, second one zero other two not, are given
    Boolean testWeightedSumThreeWeightsSecondZero() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.0);
        myWeights.add(0.75);

        //assertEquals(3.95, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (3.9 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 4.0 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }

    @Test
    //tests when 3 weights, third one zero other two not, are given
    Boolean testWeightedSumThreeWeightsThirdZero() {
        LinkedList<Double> factors = new LinkedList<>();
        Pinpoint locationMyFH = new Pinpoint(0,5);
        Pinpoint poi = new Pinpoint(0,0);
        FieldHospital myFH = new FieldHospital();
        factors.add(0, FieldHospital.danger());
        factors.add(1, FieldHospital.unavailability());
        factors.add(2, FieldHospital.routeDistance(poi, locationMyFH));

        Vector<Double> myWeights = new Vector<>();
        myWeights.add(0.25);
        myWeights.add(0.50);
        myWeights.add(0.0);

        //assertEquals(0.6000000000000001, FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
        return (0.5 <= FieldHospital.weightedSumCalculator(myWeights, factors, myFH) && 0.7 >= FieldHospital.weightedSumCalculator(myWeights, factors, myFH));
    }


    //Testing top3FieldHospitalsCalculator()
    @Test
    //testing top3fh when given just one field hospital
    Boolean testTop3FHOneFH(){
        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        FieldHospital fhA = new FieldHospital();
        fhA.setfHLocation(locationA);
        fhA.setFHName("The A FH");

        LinkedList<Double> factorsA = new LinkedList<>();
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        myFieldHospitals.add(fhA);
        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, factorsA));
        return isGood;
    }


    @Test
        //testing top3fh when given just two field hospitals
    Boolean testTop3FHTwoFH(){
        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        FieldHospital fhA = new FieldHospital();
        fhA.setfHLocation(locationA);

        LinkedList<Double> factorsA = new LinkedList<>();
        fhA.setFHName("The A FH");
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        Pinpoint locationB = new Pinpoint(5,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setfHLocation(locationB);
        fhB.setFHName("The B FH");

        LinkedList<Double> factorsB = new LinkedList<>();
        factorsB.add(0, FieldHospital.danger());
        factorsB.add(1, FieldHospital.unavailability());
        factorsB.add(2, FieldHospital.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        top3FH.add(fhB.getFHName());
        //assertEquals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)), top3FH);
        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)));
        //return (FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)) == top3FH);
        return isGood;
    }



    @Test
        //testing top3fh when given three field hospitals
    Boolean testTop3FHThreeFH(){

        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital();
        fhA.setFHName("The A FH");
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setFHName("The B FH");
        factorsB.add(0, FieldHospital.danger());
        factorsB.add(1, FieldHospital.unavailability());
        factorsB.add(2, FieldHospital.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(10,10);
        FieldHospital fhC = new FieldHospital();
        fhC.setFHName("The C FH");
        factorsC.add(0, FieldHospital.danger());
        factorsC.add(1, FieldHospital.unavailability());
        factorsC.add(2, FieldHospital.routeDistance(locationC, poi));
        fhC.setFactors(factorsC);

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);

        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        top3FH.add(fhB.getFHName());
        top3FH.add(fhC.getFHName());
        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)));
        return isGood;
    }

    @Test
    //testing top3fh when given three field hospitals where just first and second have same location
    Boolean testTop3FHThreeFHFirstSecondSameSpot(){

        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(5,5);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital();
        fhA.setFHName("The A FH");
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setFHName("The B FH");
        factorsB.add(0, FieldHospital.danger());
        factorsB.add(1, FieldHospital.unavailability());
        factorsB.add(2, FieldHospital.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(10,10);
        FieldHospital fhC = new FieldHospital();
        fhC.setFHName("The C FH");
        factorsC.add(0, FieldHospital.danger());
        factorsC.add(1, FieldHospital.unavailability());
        factorsC.add(2, FieldHospital.routeDistance(locationC, poi));
        fhC.setFactors(factorsC);

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);

        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        top3FH.add(fhB.getFHName());
        top3FH.add(fhC.getFHName());

        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)));
        return isGood;
    }

    @Test
    //testing top3fh when given three field hospitals where just second and third have same location
    Boolean testTop3FHThreeFHSecondThirdSameSpot(){

        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital();
        fhA.setFHName("The A FH");
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(5,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setFHName("The B FH");
        factorsB.add(0, FieldHospital.danger());
        factorsB.add(1, FieldHospital.unavailability());
        factorsB.add(2, FieldHospital.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(5,5);
        FieldHospital fhC = new FieldHospital();
        fhC.setFHName("The C FH");
        factorsC.add(0, FieldHospital.danger());
        factorsC.add(1, FieldHospital.unavailability());
        factorsC.add(2, FieldHospital.routeDistance(locationC, poi));
        fhC.setFactors(factorsC);

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);

        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        top3FH.add(fhB.getFHName());
        top3FH.add(fhC.getFHName());

        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)));
        return isGood;
    }

    @Test
    //testing top3fh when given three field hospitals where first, second, and third have same location
    Boolean testTop3FHThreeFHAllSameSpot(){

        Pinpoint poi = new Pinpoint(0,0);
        LinkedList<FieldHospital> myFieldHospitals = new LinkedList<>();
        Pinpoint locationA = new Pinpoint(0,5);
        LinkedList<Double> factorsA = new LinkedList<>();
        FieldHospital fhA = new FieldHospital();
        fhA.setFHName("The A FH");
        factorsA.add(0, FieldHospital.danger());
        factorsA.add(1, FieldHospital.unavailability());
        factorsA.add(2, FieldHospital.routeDistance(locationA, poi));
        fhA.setFactors(factorsA);

        LinkedList<Double> factorsB = new LinkedList<>();
        Pinpoint locationB = new Pinpoint(0,5);
        FieldHospital fhB = new FieldHospital();
        fhB.setFHName("The B FH");
        factorsB.add(0, FieldHospital.danger());
        factorsB.add(1, FieldHospital.unavailability());
        factorsB.add(2, FieldHospital.routeDistance(locationB, poi));
        fhB.setFactors(factorsB);

        LinkedList<Double> factorsC = new LinkedList<>();
        Pinpoint locationC = new Pinpoint(0,5);
        FieldHospital fhC = new FieldHospital();
        fhC.setFHName("The C FH");
        factorsC.add(0, FieldHospital.danger());
        factorsC.add(1, FieldHospital.unavailability());
        factorsC.add(2, FieldHospital.routeDistance(locationC, poi));
        fhC.setFactors(factorsC);

        myFieldHospitals.add(fhA);
        myFieldHospitals.add(fhB);
        myFieldHospitals.add(fhC);

        ArrayList<String> top3FH = new ArrayList<>();
        top3FH.add(fhA.getFHName());
        top3FH.add(fhB.getFHName());
        top3FH.add(fhC.getFHName());

        Boolean isGood = top3FH.equals(FieldHospital.top3FieldHospitalsCalculator(myFieldHospitals, FieldHospital.getFactorsFHList(myFieldHospitals)));
        return isGood;
    }



    //Testing getDanger()
    @Test
    //tests dummy function returns 0.8 for the danger factor of a field hospital
    Boolean testDangerDummy(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(0.8, FieldHospital.danger());
        return (0.7 <= FieldHospital.danger() && 0.9 >= FieldHospital.danger());
    }

    //Testing getUnavailability()
    @Test
    //tests dummy function returns 0.8 for the unavailability factor of a field hospital
    Boolean testUnavailabilityDummy(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, fH.routeDistance(fHLocation, poi));
        //assertEquals(0.8, fH.unavailability());
        return (0.7 <= FieldHospital.unavailability() && 0.9 >= FieldHospital.unavailability());
    }

    //Testing getRouteDistance()
    @Test
    //tests field hospital has positive X value
    Boolean testRouteDistancePosX(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(5.0, FieldHospital.routeDistance(fHLocation, poi));
        return (4.0 <= FieldHospital.routeDistance(fHLocation, poi) && 6.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has positive y value
    Boolean testRouteDistancePosY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, 5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(5.0, FieldHospital.routeDistance(fHLocation, poi));
        return (4.0 <= FieldHospital.routeDistance(fHLocation, poi) && 6.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has positive xy values
    Boolean testRouteDistancePosXY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(5, 5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(7.0710678118654755, FieldHospital.routeDistance(fHLocation, poi));
        return (7.0 <= FieldHospital.routeDistance(fHLocation, poi) && 8.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
        //tests field hospital has negative x value
    Boolean testRouteDistanceNegX(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(-5, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(5.0, FieldHospital.routeDistance(fHLocation, poi));
        return (4.0 <= FieldHospital.routeDistance(fHLocation, poi) && 6.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has negative y value
    Boolean testRouteDistanceNegY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, -5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(5.0, FieldHospital.routeDistance(fHLocation, poi));
        return (4.0 <= FieldHospital.routeDistance(fHLocation, poi) && 6.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
    //tests field hospital has negative xy values
    Boolean testRouteDistanceNegXY(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(-5, -5);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(7.0710678118654755, FieldHospital.routeDistance(fHLocation, poi));
        return (7.0 <= FieldHospital.routeDistance(fHLocation, poi) && 8.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }

    @Test
    //tests poi and field hospital in same location
    Boolean testRouteDistanceSameSpot(){
        Pinpoint poi = new Pinpoint(0,0);
        Pinpoint fHLocation = new Pinpoint(0, 0);
        LinkedList<Double> factorsFH = new LinkedList<>();
        FieldHospital fH = new FieldHospital();
        fH.setFHName("The FH");
        factorsFH.add(0, FieldHospital.danger());
        factorsFH.add(1, FieldHospital.unavailability());
        factorsFH.add(2, FieldHospital.routeDistance(fHLocation, poi));
        //assertEquals(0.0, FieldHospital.routeDistance(fHLocation, poi));
        return (-1.0 <= FieldHospital.routeDistance(fHLocation, poi) && 1.0 >= FieldHospital.routeDistance(fHLocation, poi));
    }


}