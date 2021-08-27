/*
 * fieldHospital.hpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#ifndef HOSPITALS_FIELDHOSPITAL_H_
#define HOSPITALS_FIELDHOSPITAL_H_

#include <string>
#include <vector>
#include "../location/pinpoint.h"
#include "../common/linkedlist.hpp"

class fieldHospital {

private:
    std::string fHName;
    pinpoint fHLocation;
    pinpoint poi;
    LinkedList* factors;
    double danger;
    double unavailability;
    double routeDistance;
    friend struct fHCompare;

public:
    fieldHospital(){
        this->setFHName(fHName);
        fHName = getFHName();
        this->setFHLocation(fHLocation);
        fHLocation = getFHLocation();
        this->setFactors(*factors);
    }

    std::string getFHName() const;
    void setFHName(std::string fHName);
    pinpoint getFHLocation();
    void setFHLocation(pinpoint fHLocation);
    LinkedList* getFactors1FH(fieldHospital &hospital);
    void setFactors(LinkedList llistFac);
    LinkedList* getFactorsFHList(LinkedList* llistFHs);
    static double weightedSumCalculator(std::vector<double> weights, LinkedList& llistFac, fieldHospital* myFH);
    static double dangerScore();
    static double unavailabilityScore();
    static double routeDistanceScore(pinpoint fHLocation, pinpoint poi);
    std::vector<std::string> top3FieldHospitalsCalculator(LinkedList* fieldHospitals, LinkedList* factors);


};

namespace std
    	{
    	    template<> struct less<fieldHospital>
    	    {
    	       bool operator() (const fieldHospital& lhs, const fieldHospital& rhs) const
    	       {
    	           return lhs.getFHName() < rhs.getFHName();
    	       }
    	    };
    	}


#endif /* HOSPITALS_FIELDHOSPITAL_H_ */
