/*
 * AllMyTests.hpp
 *
 *  Created on: Aug 24, 2021
 *      Author: emilymahoney
 */

#ifndef TESTS_ALLMYTESTS_H_
#define TESTS_ALLMYTESTS_H_

#include "../../src/hospitals/fieldHospital.h"
#include "../../src/hospitals/fieldHospitalTest.h"
#include "../../src/location/pinpointTest.h"
#include "../location/pinpoint.h"

class AllMyTests : public fieldHospitalTest, pinpointTest {
public:
	bool tests();

private:
		//WEIGHTED SUM
        bool fHW1;
        bool fHW2;
        bool fHW3;
        bool fHW4;
        bool fHW5;
        bool fHW6;
        bool fHW7;
        bool fHW8;
        bool fHW9;
        //TOP3FH
        bool fHT10;
        bool fHT11;
        bool fHT12;
        bool fHT13;
        bool fHT14;
        bool fHT15;
        //DANGER
        bool fHD16;
        //UNAVAILABILITY
        bool fHU17;
        //ROUTEDISTANCE
        bool fHR18;
        bool fHR19;
        bool fHR20;
        bool fHR21;
        bool fHR22;
        bool fHR23;
        bool fHR24;
        //EDISTANCE
        bool pE25;
        bool pE26;
        //MDISTANCE
        bool pM27;
        bool pM28;

        //all tests
        bool okay;
        //weighted sum
        bool fHWOKAY;
        //top3
        bool fHTOKAY;
        //danger
        bool fHDOKAY;
        //unavailability
        bool fHUOKAY;
        //route distance
        bool fHROKAY;
        //euclidean distance
        bool pEOKAY;
        //manhattan distance
        bool pMOKAY;





//begin fieldHospitalTest weightedSumCalculator

bool test1();

bool test2();

bool test3();

bool test4();

bool test5();

bool test6();

bool test7();

bool test8();

bool test9();
//end fieldHospitalTest weightedSumCalculator


//begin fieldHospitalTest top3FieldHospitalsCalculator
bool test10();

bool test11();

bool test12();

bool test13();

bool test14();

bool test15();
//end fieldHospitalTest top3FieldHospitalsCalculator

//begin fieldHospitalTest danger
bool test16();
//end fieldHospitalTest danger


//begin fieldHospitalTest unavailability
bool test17();
//end fieldHospitalTest unavailability


//begin fieldHospitalTest routeDistanceScore
bool test18();

bool test19();

bool test20();

bool test21();

bool test22();

bool test23();

bool test24();
//end fieldHospitalTest routeDistanceScore

//begin pinpointTest eDistance
bool test25();

bool test26();
//end pinpointTest eDistance

//begin pinpointTest mDistance
bool test27();

bool test28();
//end pinpointTest mDistance


};





#endif /* TESTS_ALLMYTESTS_H_ */
