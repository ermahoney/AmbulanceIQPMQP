import org.junit.jupiter.api.Test;

public class AllMyTests {
    public Boolean tests(){
        Boolean fHW1 = test1();
        //System.out.println(fHW1 + " red");
        Boolean fHW2 = test2();
        //System.out.println(fHW2 + " orange");
        Boolean fHW3 = test3();
        //System.out.println(fHW3 + " yellow");
        Boolean fHW4 = test4();
        //System.out.println(fHW4 + " green");
        Boolean fHW5 = test5();
        //System.out.println(fHW5 + " blue");
        Boolean fHW6 = test6();
        //System.out.println(fHW6 + " purple");
        Boolean fHW7 = test7();
        //System.out.println(fHW7 + " pink");
        Boolean fHW8 = test8();
        //System.out.println(fHW8 + " black");
        Boolean fHW9 = test9();
        //System.out.println(fHW9 + "brown");

        Boolean fHT10 = test10();
        //System.out.println(fHT10 + "this test");
        Boolean fHT11 = test11();
        //System.out.println(fHT11 + " BLUE");
        Boolean fHT12 = test12();
        //System.out.println(fHT12 + " hi");

        Boolean fHD13 = test13();
        //System.out.println(fHD13);

        Boolean fHU14 = test14();
        //System.out.println(fHU14);

        Boolean fHR15 = test15();
        //System.out.println(fHR15);
        Boolean fHR16 = test16();
        //System.out.println(fHR16);
        Boolean fHR17 = test17();
        //System.out.println(fHR17);
        Boolean fHR18 = test18();
        //System.out.println(fHR18);
        Boolean fHR19 = test19();
        //System.out.println(fHR19);
        Boolean fHR20 = test20();
        //System.out.println(fHR20);
        Boolean fHR21 = test21();
        //System.out.println(fHR21);

        Boolean pE22 = test22();
        //System.out.println(pE22);
        Boolean pE23 = test23();
        //System.out.println(pE23);

        Boolean pM24 = test24();
        //System.out.println(pM24);
        Boolean pM25 = test25();
        //System.out.println(pM25);

        //all
        Boolean okay = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9 && fHT10 && fHT11 && fHT12 &&
                fHD13 && fHU14 && fHR15 && fHR16 && fHR17 && fHR18 && fHR19 && fHR20 && fHR21 && pE22 && pE23 && pM24 && pM25;
        //weighted sum
        Boolean fHWOKAY = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9;
        //top3
        Boolean fHTOKAY = fHT10 && fHT11;
        //danger
        Boolean fHDOKAY = fHD13;
        //unavailability
        Boolean fHUOKAY = fHU14;
        //route distance
        Boolean fHROKAY = fHR15 && fHR16 && fHR17 && fHR18 && fHR19 && fHR20 && fHR21;
        //euclidean distance
        Boolean pEOKAY = pE22 && pE23;
        //manhattan distance
        Boolean pMOKAY = pM24 && pM25;

        //return fHWOKAY;
        //return fHTOKAY;
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
        Boolean answer = testFH.testTop3FHJustFails();
        return answer;
    }

    //end TestFieldHospital top3FieldHospitalsCalculator


    //begin TestFieldHospital danger
    private Boolean test13(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testDangerDummy();
        return answer;
    }
    //end TestFieldHospital danger


    //begin TestFieldHospital unavailability
    private Boolean test14(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testUnavailabilityDummy();
        return answer;
    }
    //end TestFieldHospital unavailability


    //begin TestFieldHospital routeDistance
    private Boolean test15(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosX();
        return answer;
    }

    private Boolean test16(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosY();
        return answer;
    }

    private Boolean test17(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistancePosXY();
        return answer;
    }

    private Boolean test18(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegX();
        return answer;
    }

    private Boolean test19(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegY();
        return answer;
    }

    private Boolean test20(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceNegXY();
        return answer;
    }

    private Boolean test21(){
        TestFieldHospital testFH = new TestFieldHospital();
        Boolean answer = testFH.testRouteDistanceSameSpot();
        return answer;
    }
    //end TestFieldHospital routeDistance

    //begin TestPinpoint eDistance
    private Boolean test22(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testEuclideanDist();
        return answer;
    }

    private Boolean test23(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testEuclideanDistSameSpot();
        return answer;
    }
    //end TestPinpoint eDistance

    //begin TestPinpoint mDistance
    private Boolean test24(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testManhattanDist();
        return answer;
    }

    private Boolean test25(){
        TestPinpoint testP = new TestPinpoint();
        Boolean answer = testP.testManhattanDistSameSpot();
        return answer;
    }
    //end TestPinpoint mDistance
}
