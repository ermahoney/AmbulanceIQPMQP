/*
 * fieldHospitalTest.hpp
 *
 *  Created on: Aug 20, 2021
 *      Author: emilymahoney
 */

#ifndef HOSPITALS_FIELDHOSPITALTEST_H_
#define HOSPITALS_FIELDHOSPITALTEST_H_


class fieldHospitalTest {
public:
	bool testWeightedSumZeroWeights();
	bool testWeightedSumOneWeight();
	bool testWeightedSumTwoWeights();
	bool testWeightedSumTwoWeightsFirstZero();
	bool testWeightedSumTwoWeightsSecondZero();
	bool testWeightedSumThreeWeights();
	bool testWeightedSumThreeWeightsFirstZero();
	bool testWeightedSumThreeWeightsSecondZero();
	bool testWeightedSumThreeWeightsThirdZero();
	bool testTop3FHOneFH();
	bool testTop3FHTwoFH();
	bool testTop3FHThreeFH();
	bool testTop3FHThreeFHFirstSecondSameSpot();
	bool testTop3FHThreeFHSecondThirdSameSpot();
	bool testTop3FHThreeFHAllSameSpot();
	bool testDangerDummy();
	bool testUnavailabilityDummy();
	bool testRouteDistancePosX();
	bool testRouteDistancePosY();
	bool testRouteDistancePosXY();
	bool testRouteDistanceNegX();
	bool testRouteDistanceNegY();
	bool testRouteDistanceNegXY();
	bool testRouteDistanceSameSpot();
};



#endif /* HOSPITALS_FIELDHOSPITALTEST_H_ */
