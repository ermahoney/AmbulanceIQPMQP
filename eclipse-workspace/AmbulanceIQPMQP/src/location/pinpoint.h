/*
 * pinpoint.hpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#ifndef LOCATION_PINPOINT_HPP_
#define LOCATION_PINPOINT_HPP_


class pinpoint {
private:
    double x;
    double y;
public:
    pinpoint(){
        this->setX(x);
        this->setY(y);
        x = getX();
        y = getY();
    }

    double getX();
    double getY();
    void setX(double x);
    void setY(double y);


};

double eDistance(pinpoint pinpoint1, pinpoint pinpoint2);
double mDistance(pinpoint pinpoint1, pinpoint pinpoint2);



#endif /* LOCATION_PINPOINT_HPP_ */
