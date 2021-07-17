import org.junit.jupiter.api.Test;

public class AllMyTests {
    public Boolean tests(){
        Boolean fHW1 = test1();
        //System.out.println(fHW1);
        Boolean fHW2 = test2();
        //System.out.println(fHW2);
        Boolean fHW3 = test3();
        //System.out.println(fHW3);
        Boolean fHW4 = test4();
        //System.out.println(fHW4);
        Boolean fHW5 = test5();
        //System.out.println(fHW5);
        Boolean fHW6 = test6();
        //System.out.println(fHW6);
        Boolean fHW7 = test7();
        //System.out.println(fHW7);
        Boolean fHW8 = test8();
        //System.out.println(fHW8);
        Boolean fHW9 = test9();
        //System.out.println(fHW9);

        Boolean fHT10 = test10();
        //System.out.println(fHT10);
        Boolean fHT11 = test11();
        //System.out.println(fHT11);
        Boolean fHT12 = test12();
        //System.out.println(fHT12);
        Boolean fHT13 = test13();
        //System.out.println(fHT13);
        Boolean fHT14 = test14();
        //System.out.println(fHT14);
        Boolean fHT15 = test15();
        //System.out.println(fHT15);

        Boolean fHD16 = test16();
        //System.out.println(fHD16);

        Boolean fHU17 = test17();
        //System.out.println(fHU17);

        Boolean fHR18 = test18();
        //System.out.println(fHR18);
        Boolean fHR19 = test19();
        //System.out.println(fHR19);
        Boolean fHR20 = test20();
        //System.out.println(fHR20);
        Boolean fHR21 = test21();
        //System.out.println(fHR21);
        Boolean fHR22 = test22();
        //System.out.println(fHR22);
        Boolean fHR23 = test23();
        //System.out.println(fHR23);
        Boolean fHR24 = test24();
        //System.out.println(fHR24);

        Boolean pE25 = test25();
        //System.out.println(pE25);
        Boolean pE26 = test26();
        //System.out.println(pE26);

        Boolean pM27 = test27();
        //System.out.println(pM27);
        Boolean pM28 = test28();
        //System.out.println(pM28);

        //all
        Boolean okay = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9 && fHT10 && fHT11 && fHT12 &&fHT13 && fHT14 && fHT15 &&
                 fHD16 && fHU17 && fHR18 && fHR19 && fHR20 && fHR21 && fHR22 && fHR23 && fHR24
                && pE25 && pE26 && pM27 && pM28;
        //weighted sum
        Boolean fHWOKAY = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9;
        //top3
        Boolean fHTOKAY = fHT10 && fHT11 && fHT12 && fHT13 && fHT14 && fHT15;
        //danger
        Boolean fHDOKAY = fHD16;
        //unavailability
        Boolean fHUOKAY = fHU17;
        //route distance
        Boolean fHROKAY = fHR18 && fHR19 && fHR20 && fHR21 && fHR22 && fHR23 && fHR24;
        //euclidean distance
        Boolean pEOKAY = pE25 && pE26;
        //manhattan distance
        Boolean pMOKAY = pM27 && pM28;

        //return fHWOKAY;
        //return fHTOKAY;
        //return fHT13OKAY;
        //return fHT14OKAY;
        //return fHT15OKAY;
        //return fHDOKAY;
        //return fHUOKAY;
        //return fHROKAY;
        //return pEOKAY;
        //return pMOKAY;
        //return fHWOKAY && fHTOKAY && fHDOKAY && fHUOKAY && fHROKAY && pEOKAY && pMOKAY;
        return okay;
    }

    //begin TestFieldHospital weightedSumCalculator
    private Boolean test1(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumZeroWeights();
        return answer;
    }

    private Boolean test2(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumOneWeight();
        return answer;
    }

    private Boolean test3(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumTwoWeights();
        return answer;
    }

    private Boolean test4(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumTwoWeightsFirstZero();
        return answer;
    }

    private Boolean test5(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumTwoWeightsSecondZero();
        return answer;
    }

    private Boolean test6(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumThreeWeights();
        return answer;
    }

    private Boolean test7(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumThreeWeightsFirstZero();
        return answer;
    }

    private Boolean test8(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumThreeWeightsSecondZero();
        return answer;
    }

    private Boolean test9(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testWeightedSumThreeWeightsThirdZero();
        return answer;
    }
    //end TestFieldHospital weightedSumCalculator

    //begin TestFieldHospital top3FieldHospitalsCalculator
    private Boolean test10(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHOneFH();
        return answer;
    }


    private Boolean test11(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHTwoFH();
        return answer;
    }


    private Boolean test12(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHThreeFH();
        return answer;
    }

    private Boolean test13(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHThreeFHFirstSecondSameSpot();
        return answer;
    }

    private Boolean test14(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHThreeFHSecondThirdSameSpot();
        return answer;
    }

    private Boolean test15(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testTop3FHThreeFHAllSameSpot();
        return answer;
    }



    //end TestFieldHospital top3FieldHospitalsCalculator


    //begin TestFieldHospital danger
    private Boolean test16(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testDangerDummy();
        return answer;
    }
    //end TestFieldHospital danger


    //begin TestFieldHospital unavailability
    private Boolean test17(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testUnavailabilityDummy();
        return answer;
    }
    //end TestFieldHospital unavailability


    //begin TestFieldHospital routeDistance
    private Boolean test18(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosX();
        return answer;
    }

    private Boolean test19(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosY();
        return answer;
    }

    private Boolean test20(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosXY();
        return answer;
    }

    private Boolean test21(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegX();
        return answer;
    }

    private Boolean test22(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegY();
        return answer;
    }

    private Boolean test23(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegXY();
        return answer;
    }

    private Boolean test24(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceSameSpot();
        return answer;
    }
    //end TestFieldHospital routeDistance

    //begin TestPinpoint eDistance
    private Boolean test25(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testEuclideanDist();
        return answer;
    }

    private Boolean test26(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testEuclideanDistSameSpot();
        return answer;
    }
    //end TestPinpoint eDistance

    //begin TestPinpoint mDistance
    private Boolean test27(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testManhattanDist();
        return answer;
    }

    private Boolean test28(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testManhattanDistSameSpot();
        return answer;
    }
    //end TestPinpoint mDistance
}
