/*
 * AllMyTests.cpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#include "../../src/tests/AllMyTests.h"

#include <iostream>

#include "../../src/tests/Production.h"

// int main(int argc, char* argv[]) {
// 	std::cout << "!!!Hello World, we are doing MQP!!!" << std::endl;
// 	AllMyTests* tsP = new AllMyTests();
// 	if(tsP->tests()){
// 		Production* pP = new Production();
// 		if(pP->prod(argc, *argv)){
// 			std::cout << "Production passed." << std::endl;
// 		}
// 		delete(pP);
// 	}
// 	else{
// 		std::cout << "Not all tests passed." << std::endl;
// 	}
// 	delete(tsP);
// 	return 0;
// }

bool AllMyTests ::tests()
{
	//WEIGHTED SUM
	fHW1 = test1();
	fHW2 = test2();
	fHW3 = test3();
	fHW4 = test4();
	fHW5 = test5();
	fHW6 = test6();
	fHW7 = test7();
	fHW8 = test8();
	fHW9 = test9();
	//TOP3FH
	fHT10 = test10();
	fHT11 = test11();
	fHT12 = test12();
	fHT13 = test13();
	fHT14 = test14();
	fHT15 = test15();
	//DANGER
	fHD16 = test16();
	//UNAVAILABILITY
	fHU17 = test17();
	//ROUTEDISTANCE
	fHR18 = test18();
	fHR19 = test19();
	fHR20 = test20();
	fHR21 = test21();
	fHR22 = test22();
	fHR23 = test23();
	fHR24 = test24();
	//EDISTANCE
	pE25 = test25();
	pE26 = test26();
	//MDISTANCE
	pM27 = test27();
	pM28 = test28();

	//all tests
	okay = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9 && fHT10 && fHT11 && fHT12 && fHT13 && fHT14 && fHT15 &&
		   fHD16 && fHU17 && fHR18 && fHR19 && fHR20 && fHR21 && fHR22 && fHR23 && fHR24 && pE25 && pE26 && pM27 && pM28;
	//weighted sum
	fHWOKAY = fHW1 && fHW2 && fHW3 && fHW4 && fHW5 && fHW6 && fHW7 && fHW8 && fHW9;
	//top3
	fHTOKAY = fHT10 && fHT11 && fHT12 && fHT13 && fHT14 && fHT15;
	//danger
	fHDOKAY = fHD16;
	//unavailability
	fHUOKAY = fHU17;
	//route distance
	fHROKAY = fHR18 && fHR19 && fHR20 && fHR21 && fHR22 && fHR23 && fHR24;
	//euclidean distance
	pEOKAY = pE25 && pE26;
	//manhattan distance
	pMOKAY = pM27 && pM28;

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
	return pEOKAY;
}

//begin fieldHospitalTest weightedSumCalculator
bool AllMyTests ::test1()
{
	fieldHospitalTest *x = new fieldHospitalTest();
	bool answer = x->testWeightedSumZeroWeights();
	return answer;
}

bool AllMyTests ::test2()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumOneWeight();
	return answer;
}

bool AllMyTests ::test3()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumTwoWeights();
	return answer;
}

bool AllMyTests ::test4()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumTwoWeightsFirstZero();
	return answer;
}

bool AllMyTests ::test5()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumTwoWeightsSecondZero();
	return answer;
}

bool AllMyTests ::test6()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumThreeWeights();
	return answer;
}

bool AllMyTests ::test7()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumThreeWeightsFirstZero();
	return answer;
}

bool AllMyTests ::test8()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumThreeWeightsSecondZero();
	return answer;
}

bool AllMyTests ::test9()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testWeightedSumThreeWeightsThirdZero();
	return answer;
}
//end fieldHospitalTest weightedSumCalculator

//begin fieldHospitalTest top3FieldHospitalsCalculator
bool AllMyTests ::test10()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHOneFH();
	return answer;
}

bool AllMyTests ::test11()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHTwoFH();
	return answer;
}

bool AllMyTests ::test12()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHThreeFH();
	return answer;
}

bool AllMyTests ::test13()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHThreeFHFirstSecondSameSpot();
	return answer;
}

bool AllMyTests ::test14()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHThreeFHSecondThirdSameSpot();
	return answer;
}

bool AllMyTests ::test15()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testTop3FHThreeFHAllSameSpot();
	return answer;
}
//end fieldHospitalTest top3FieldHospitalsCalculator

//begin fieldHospitalTest danger
bool AllMyTests ::test16()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testDangerDummy();
	return answer;
}
//end fieldHospitalTest danger

//begin fieldHospitalTest unavailability
bool AllMyTests ::test17()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testUnavailabilityDummy();
	return answer;
}
//end fieldHospitalTest unavailability

//begin fieldHospitalTest routeDistanceScore
bool AllMyTests ::test18()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistancePosX();
	return answer;
}

bool AllMyTests ::test19()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistancePosY();
	return answer;
}

bool AllMyTests ::test20()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistancePosXY();
	return answer;
}

bool AllMyTests ::test21()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistanceNegX();
	return answer;
}

bool AllMyTests ::test22()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistanceNegY();
	return answer;
}

bool AllMyTests ::test23()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistanceNegXY();
	return answer;
}

bool AllMyTests ::test24()
{
	fieldHospitalTest *testFH = new fieldHospitalTest();
	bool answer = testFH->testRouteDistanceSameSpot();
	return answer;
}
//end fieldHospitalTest routeDistanceScore

//begin pinpointTest eDistance
bool AllMyTests ::test25()
{
	pinpointTest *testP = new pinpointTest();
	bool answer = testP->testEuclideanDist();
	return answer;
}

bool AllMyTests ::test26()
{
	pinpointTest *testP = new pinpointTest();
	bool answer = testP->testEuclideanDistSameSpot();
	return answer;
}
//end pinpointTest eDistance

//begin pinpointTest mDistance
bool AllMyTests ::test27()
{
	pinpointTest *testP = new pinpointTest();
	bool answer = testP->testManhattanDist();
	return answer;
}

bool AllMyTests ::test28()
{
	pinpointTest *testP = new pinpointTest();
	bool answer = testP->testManhattanDistSameSpot();
	return answer;
}
//end pinpointTest mDistance
