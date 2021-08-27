/*
 * pinpointTest.cpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#include <vector>
#include <stdio.h>
#include "pinpoint.h"
#include "pinpointTest.h"

bool pinpointTest::testEuclideanDist(){
    pinpoint* pinpointA = new pinpoint();
    pinpointA->setX(-3);
    pinpointA->setY(-5);
    pinpoint* pinpointB = new pinpoint();
    pinpointB->setX(3);
    pinpointB->setY(5);
    //EXPECT_EQ(11.661903789690601, eDistance(pinpointA, pinpointB));
    return(11.0 <= eDistance(*pinpointA, *pinpointB) && 12.0 >= eDistance(*pinpointA, *pinpointB));
}

bool pinpointTest::testEuclideanDistSameSpot(){
    pinpoint* pinpointA = new pinpoint();
    pinpointA->setX(3);
    pinpointA->setY(5);
    pinpoint* pinpointB = new pinpoint();
    pinpointB->setX(3);
    pinpointB->setY(5);
    //EXPECT_EQ(0, eDistance(pinpointA, pinpointB));
    return(-1.0 <= eDistance(*pinpointA, *pinpointB) && 1.0 >= eDistance(*pinpointA, *pinpointB));
}

bool pinpointTest::testManhattanDist(){
    pinpoint* pinpointA = new pinpoint();
    pinpointA->setX(-3);
    pinpointA->setY(-5);
    pinpoint* pinpointB = new pinpoint();
    pinpointB->setX(3);
    pinpointB->setY(5);
    //EXPECT_EQ(16.0, mDistance(pinpointA, pinpointB));
    return(15.0 <= mDistance(*pinpointA, *pinpointB) && 17.0 >= mDistance(*pinpointA, *pinpointB));
}

bool pinpointTest::testManhattanDistSameSpot(){
    pinpoint* pinpointA = new pinpoint();
    pinpointA->setX(3);
    pinpointA->setY(5);
    pinpoint* pinpointB = new pinpoint();
    pinpointB->setX(3);
    pinpointB->setY(5);
    //EXPECT_EQ(0, mDistance(pinpointA, pinpointB));
    return (-1.0 <= mDistance(*pinpointA, *pinpointB) && 1.0 >= mDistance(*pinpointA, *pinpointB));
}

