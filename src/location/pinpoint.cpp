/*
 * pinpoint.cpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#include "../../src/location/pinpoint.h"

#include <iostream>
#include <cmath>

/*
    Description: Euclidean distance calculator
    Input: Two pinpoint locations
    Output: Euclidean distance between two Pinpoints
*/
double eDistance(pinpoint pinpoint1, pinpoint pinpoint2){
    double x = pow(pinpoint2.getX() - pinpoint1.getX(), 2);
    double y = pow(pinpoint2.getY() - pinpoint1.getY(), 2);
    return sqrt(x + y);
}

/*
    Description: Manhattan distance calculator
    Input: Two pinpoint locations
    Output: Manhattan distance between two Pinpoints
*/
double mDistance(pinpoint pinpoint1, pinpoint pinpoint2){
    return abs(pinpoint2.getX() - pinpoint1.getX()) + abs(pinpoint2.getY() - pinpoint1.getY());
}

//getters
double pinpoint::getX() {
    return this->x;
}

double pinpoint::getY() {
    return this->y;
}
//setters
void pinpoint::setX(double x) {
    this->x = x;
}

void pinpoint::setY(double y) {
    this->y = y;
}
