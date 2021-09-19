/*
 * fieldHospital.cpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */
#include "../../src/hospitals/fieldHospital.h"

#include <string>
#include <vector>
#include <list>
#include <map>
#include <functional>
#include <iostream>
#include <stdio.h>
#include <limits>
#include <algorithm>
#include <iterator>

#include "../../src/tests/AllMyTests.h"
#include "../../src/tests/Production.h"
#include "../../src/common/linkedlist.hpp"
#include "../../src/location/pinpoint.h"

/*
    Description: Calculates the weighed sum for a given set of weights and factors for a given field hospital
    @param vector of weights, field hospital
    @return weightedSum
*/
double fieldHospital::weightedSumCalculator(std::vector<double> weights, LinkedList &llistFac, fieldHospital *myFH)
{
    double weightedSum = 0;
    LinkedList::LLNODE *pnode = llistFac.get_first_node(
        reinterpret_cast<LinkedList::LLIST *>(myFH->getFactors1FH(reinterpret_cast<fieldHospital &>(*myFH))));
    for (int i = 0; i < weights.size(); i++)
    {
        if (weights.at(i) != 0.0)
        {
            if (!(*static_cast<double *>(pnode->data) < 0.0))
                weightedSum += weights.at(i) * (*static_cast<double *>(pnode->data));
            pnode = llistFac.get_next_node(pnode);
        }
    }
    return weightedSum;
}

/*
    Description: Calculates weighted desirability with respect to point of injury for a given list of field hospitals
    and returns the top 3 field hospitals in ranked order
    @param list of field hospitals, poi
    @return list of best 3 field hospitals
*/
std::vector<std::string> fieldHospital::top3FieldHospitalsCalculator(LinkedList *fieldHospitals, LinkedList *factors)
{
    std::vector<double> myWeights;
    myWeights.push_back(0.25);
    myWeights.push_back(0.50);
    myWeights.push_back(0.75);

    std::map<fieldHospital, double> allFHWeightedSums;

    std::vector<std::string> top3FH;
    double frst, scnd, thrd;

    /*iterate through list of field hospitals to put them into a map with the field
          hospitals as keys and the weighted sums values*/
    LinkedList::LLNODE *pnode = fieldHospitals->LinkedList::get_first_node(reinterpret_cast<LinkedList::LLIST *>(fieldHospitals));
    for (int i = 0; i < sizeof(fieldHospitals); i++)
    {
        fieldHospital *f = (static_cast<fieldHospital *>(pnode->data));
        LinkedList *myFactors = f->getFactors1FH(*f);
        double thisWeightedSum = fieldHospital::weightedSumCalculator(myWeights,
                                                                      reinterpret_cast<LinkedList &>(*myFactors), reinterpret_cast<fieldHospital *>(f));

        allFHWeightedSums[*f] = thisWeightedSum;
    }

    // Check if list of field hospitals is zero or less and stops if true
    if (allFHWeightedSums.size() < 1)
    {
        std::cout << "Invalid input" << std::endl;
    }

    frst = scnd = thrd = std::numeric_limits<int>::max();
    std::map<fieldHospital, double>::iterator it = allFHWeightedSums.begin();
    //loop through the values of the hashmap and save the 3 fh's with the least weighted sums to a linked list
    while (it != allFHWeightedSums.end())
    {
        /* If current value is smaller than frst
              then update frst, scnd, and thrd */
        if (it->second < frst)
        {

            thrd = scnd = frst;
            frst = it->second;
            fieldHospital frstFH = it->first;
            top3FH.push_back(frstFH.getFHName());

            /* If allFHWeightedSums.get(i) is in between frst and scnd
               then update second  */
        }
        else if (it->second < scnd)
        {
            scnd = it->second;
            fieldHospital scndFH = it->first;
            top3FH.push_back(scndFH.getFHName());

            /* If allFHWeightedSums.get(i) is in between scnd and thrd
               then update thrd  */
        }
        else
        {
            if (it->second < thrd)
            {
                thrd = it->second;
                fieldHospital thrdFH = it->first;
                top3FH.push_back(thrdFH.getFHName());
            }
        }
    }

    //print out the weighted sums of the field hospitals in ranked order
    if (frst == scnd && scnd == thrd && frst != std::numeric_limits<int>::max())
    { //case for first, second, and third tied
        std::cout << "There is a tie for first second, and third smallest element" << std::endl;
        std::cout << "First, second, and third are tied for smallest element at: " << frst << std::endl;
    }
    else if (frst == scnd && frst != std::numeric_limits<int>::max() && thrd == std::numeric_limits<int>::max())
    { //case for first and second tied
        std::cout << "There is a tie for first and second smallest element" << std::endl;
        std::cout << "First and second are tied for smallest element at: " << frst << std::endl;
    }
    else if (frst == scnd && frst != std::numeric_limits<int>::max() && thrd != std::numeric_limits<int>::max())
    { //case for first and second tied
        std::cout << "There is a tie for first and second smallest element, but not third" << std::endl;
        std::cout << "First and second are tied for smallest element at: " << frst << " and the third smallest element is " << thrd << std::endl;
    }
    else if (scnd == thrd && scnd != std::numeric_limits<int>::max() && frst != std::numeric_limits<int>::max())
    { //case for second and third tied
        std::cout << "There is a tie for second and third smallest element, but not first" << std::endl;
        std::cout << "The smallest element is " << frst << " and second and third are tied for smallest element at: " << scnd << std::endl;
    }
    else if (thrd == std::numeric_limits<int>::max() && scnd != std::numeric_limits<int>::max())
    { //case for 2 field hospitals provided
        std::cout << "There is no third smallest element" << std::endl;
        std::cout << "The smallest element is " << frst << " and second smallest element is " << scnd << std::endl;
    }
    else if (scnd == std::numeric_limits<int>::max() && thrd == std::numeric_limits<int>::max())
    { //case for 1 field hospital provided
        std::cout << "There is no second or third smallest element" << std::endl;
        std::cout << "The smallest element is " << frst << std::endl;
    }
    else
    { //case for 3 field hospitals provided
        std::cout << "The smallest element is " << frst << " and second smallest element is " << scnd << " and third smallest element is " << thrd << std::endl;
    }

    return top3FH;
}

//FACTOR METHODS
double fieldHospital::dangerScore() { return 0.8; }
double fieldHospital::unavailabilityScore() { return 0.8; }
double fieldHospital::routeDistanceScore(pinpoint fHLocation, pinpoint poi)
{
    //return fHLocation.pinpoint::eDistance(fHLocation, poi);
    return fHLocation.eDistance(fHLocation, poi);
}

//getters and setters
std::string fieldHospital::getFHName() const { return this->fHName; }
void fieldHospital::setFHName(std::string fHName) { this->fHName = fHName; }
pinpoint fieldHospital::getFHLocation() { return this->fHLocation; }
void fieldHospital::setFHLocation(pinpoint fHLocation) { this->fHLocation = fHLocation; }
void fieldHospital::setFactors(LinkedList llistFac) { factors = &llistFac; }
LinkedList *fieldHospital::getFactors1FH(fieldHospital &hospital) { return reinterpret_cast<LinkedList *>(this->factors); }
LinkedList *fieldHospital::getFactorsFHList(LinkedList *llistFHs)
{
    return reinterpret_cast<LinkedList *>(factors);
}
