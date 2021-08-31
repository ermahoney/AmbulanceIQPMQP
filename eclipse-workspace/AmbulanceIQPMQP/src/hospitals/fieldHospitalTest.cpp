/*
 * fieldHospitalTest.cpp
 *
 *  Created on: Aug 19, 2021
 *      Author: emilymahoney
 */

#include "../hospitals/fieldHospital.h"
#include "../hospitals/fieldHospitalTest.h"
#include <vector>
#include <stdio.h>
#include <stdbool.h>

//testing weightedSum()
bool fieldHospitalTest::testWeightedSumZeroWeights(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    return (-1.0 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 1.0 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumOneWeight(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    return (0.1 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 0.3 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumTwoWeights(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    myWeights->push_back(0.50);
    return (0.5 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 0.7 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumTwoWeightsFirstZero(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.0);
    myWeights->push_back(0.50);
    return (0.3 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 0.5 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumTwoWeightsSecondZero(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    myWeights->push_back(0.0);
    return (0.1 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 0.3 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumThreeWeights(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    myWeights->push_back(0.50);
    myWeights->push_back(0.75);
    return (4.3 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 4.4 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumThreeWeightsFirstZero(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.0);
    myWeights->push_back(0.50);
    myWeights->push_back(0.75);
    return (4.1 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 4.2 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumThreeWeightsSecondZero(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    myWeights->push_back(0.0);
    myWeights->push_back(0.75);
    return (3.9 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 4.0 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

bool fieldHospitalTest::testWeightedSumThreeWeightsThirdZero(){
    LinkedList* factors = new LinkedList();
    pinpoint* locationMyFH = new pinpoint();
    locationMyFH->setX(0);
    locationMyFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    fieldHospital* myFH = new fieldHospital();
    myFH->setFHLocation(*locationMyFH);
    std::vector<double>* myWeights = new std::vector<double>();
    myWeights->push_back(0.25);
    myWeights->push_back(0.50);
    myWeights->push_back(0.0);
    return (0.5 <= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH) && 0.7 >= fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH));
}

//testing top3fieldhospitals()
//testing top3fh when given just one field hospital
bool fieldHospitalTest::testTop3FHOneFH(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(0);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    bool isGood = (firstIsGood == true);
    return isGood;
}

//testing top3fh when given just two field hospitals
bool fieldHospitalTest::testTop3FHTwoFH(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(0);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    pinpoint* locationB = new pinpoint();
    locationA->setX(5);
    locationA->setY(5);
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHLocation(*locationB);
    fhB->setFHName("The B FH");

    LinkedList* factorsB = new LinkedList();
    double dB = fieldHospital::dangerScore();
    double * pdB = &dB;
    double uB = fieldHospital::unavailabilityScore();
    double * puB = &uB;
    double rB = fieldHospital::routeDistanceScore(*locationB, *poi);
    double * prB = &rB;
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(pdB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(puB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(prB)));
    fhB->setFactors(*factorsB);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    //check that second field hospital in list returned by top3FieldHospitalsCalculator matches what i expect, if null, accept
    bool secondIsGood = top3FHResult.at(1) == fhB->getFHName();
    bool isGood = (firstIsGood == true) & (secondIsGood == true);
    return isGood;
}

//testing top3fh when given three field hospitals
bool fieldHospitalTest::testTop3FHThreeFH(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(0);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    pinpoint* locationB = new pinpoint();
    locationB->setX(5);
    locationB->setY(5);
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHLocation(*locationB);
    fhB->setFHName("The B FH");

    LinkedList* factorsB = new LinkedList();
    double dB = fieldHospital::dangerScore();
    double * pdB = &dB;
    double uB = fieldHospital::unavailabilityScore();
    double * puB = &uB;
    double rB = fieldHospital::routeDistanceScore(*locationB, *poi);
    double * prB = &rB;
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(pdB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(puB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(prB)));
    fhB->setFactors(*factorsB);

    pinpoint* locationC = new pinpoint();
    locationC->setX(10);
    locationC->setY(10);
    fieldHospital* fhC = new fieldHospital();
    fhC->setFHLocation(*locationC);
    fhC->setFHName("The C FH");

    LinkedList* factorsC = new LinkedList();
    double dC = fieldHospital::dangerScore();
    double * pdC = &dC;
    double uC = fieldHospital::unavailabilityScore();
    double * puC = &uC;
    double rC = fieldHospital::routeDistanceScore(*locationC, *poi);
    double * prC = &rC;
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(pdC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(puC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(prC)));
    fhC->setFactors(*factorsC);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhC);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    //check that second field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool secondIsGood = top3FHResult.at(1) == fhB->getFHName();
    //check that third field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool thirdIsGood = top3FHResult.at(2) == fhC->getFHName();
    bool isGood = (firstIsGood == true) & (secondIsGood == true) & (thirdIsGood == true);
    return isGood;
}

//testing top3fh when given three field hospitals where just first and second have same location
bool fieldHospitalTest::testTop3FHThreeFHFirstSecondSameSpot(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(5);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    pinpoint* locationB = new pinpoint();
    locationB->setX(5);
    locationB->setY(5);
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHLocation(*locationB);
    fhB->setFHName("The B FH");

    LinkedList* factorsB = new LinkedList();
    double dB = fieldHospital::dangerScore();
    double * pdB = &dB;
    double uB = fieldHospital::unavailabilityScore();
    double * puB = &uB;
    double rB = fieldHospital::routeDistanceScore(*locationB, *poi);
    double * prB = &rB;
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(pdB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(puB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(prB)));
    fhB->setFactors(*factorsB);

    pinpoint* locationC = new pinpoint();
    locationC->setX(10);
    locationC->setY(10);
    fieldHospital* fhC = new fieldHospital();
    fhC->setFHLocation(*locationC);
    fhC->setFHName("The C FH");

    LinkedList* factorsC = new LinkedList();
    double dC = fieldHospital::dangerScore();
    double * pdC = &dC;
    double uC = fieldHospital::unavailabilityScore();
    double * puC = &uC;
    double rC = fieldHospital::routeDistanceScore(*locationC, *poi);
    double * prC = &rC;
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(pdC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(puC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(prC)));
    fhC->setFactors(*factorsC);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhC);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    //check that second field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool secondIsGood = top3FHResult.at(1) == fhB->getFHName();
    //check that third field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool thirdIsGood = top3FHResult.at(2) == fhC->getFHName();
    bool isGood = (firstIsGood == true) & (secondIsGood == true) & (thirdIsGood == true);
    return isGood;
}

//testing top3fh when given three field hospitals where just second and third have same location
bool fieldHospitalTest::testTop3FHThreeFHSecondThirdSameSpot(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(0);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    pinpoint* locationB = new pinpoint();
    locationB->setX(5);
    locationB->setY(5);
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHLocation(*locationB);
    fhB->setFHName("The B FH");

    LinkedList* factorsB = new LinkedList();
    double dB = fieldHospital::dangerScore();
    double * pdB = &dB;
    double uB = fieldHospital::unavailabilityScore();
    double * puB = &uB;
    double rB = fieldHospital::routeDistanceScore(*locationB, *poi);
    double * prB = &rB;
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(pdB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(puB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(prB)));
    fhB->setFactors(*factorsB);

    pinpoint* locationC = new pinpoint();
    locationC->setX(5);
    locationC->setY(5);
    fieldHospital* fhC = new fieldHospital();
    fhC->setFHLocation(*locationC);
    fhC->setFHName("The C FH");

    LinkedList* factorsC = new LinkedList();
    double dC = fieldHospital::dangerScore();
    double * pdC = &dC;
    double uC = fieldHospital::unavailabilityScore();
    double * puC = &uC;
    double rC = fieldHospital::routeDistanceScore(*locationC, *poi);
    double * prC = &rC;
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(pdC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(puC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(prC)));
    fhC->setFactors(*factorsC);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhC);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    //check that second field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool secondIsGood = top3FHResult.at(1) == fhB->getFHName();
    //check that third field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool thirdIsGood = top3FHResult.at(2) == fhC->getFHName();
    bool isGood = (firstIsGood == true) & (secondIsGood == true) & (thirdIsGood == true);
    return isGood;
}

//testing top3fh when given three field hospitals where first, second, and third have same location
bool fieldHospitalTest::testTop3FHThreeFHAllSameSpot(){
    pinpoint* locationA = new pinpoint();
    locationA->setX(0);
    locationA->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* myFieldHospitals = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHLocation(*locationA);
    fhA->setFHName("The A FH");

    LinkedList* factorsA = new LinkedList();
    double dA = fieldHospital::dangerScore();
    double * pdA = &dA;
    double uA = fieldHospital::unavailabilityScore();
    double * puA = &uA;
    double rA = fieldHospital::routeDistanceScore(*locationA, *poi);
    double * prA = &rA;
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(pdA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(puA)));
    factorsA->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsA), (static_cast<void*>(prA)));
    fhA->setFactors(*factorsA);

    pinpoint* locationB = new pinpoint();
    locationB->setX(0);
    locationB->setY(5);
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHLocation(*locationB);
    fhB->setFHName("The B FH");

    LinkedList* factorsB = new LinkedList();
    double dB = fieldHospital::dangerScore();
    double * pdB = &dB;
    double uB = fieldHospital::unavailabilityScore();
    double * puB = &uB;
    double rB = fieldHospital::routeDistanceScore(*locationB, *poi);
    double * prB = &rB;
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(pdB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(puB)));
    factorsB->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsB), (static_cast<void*>(prB)));
    fhB->setFactors(*factorsB);

    pinpoint* locationC = new pinpoint();
    locationC->setX(0);
    locationC->setY(5);
    fieldHospital* fhC = new fieldHospital();
    fhC->setFHLocation(*locationC);
    fhC->setFHName("The C FH");

    LinkedList* factorsC = new LinkedList();
    double dC = fieldHospital::dangerScore();
    double * pdC = &dC;
    double uC = fieldHospital::unavailabilityScore();
    double * puC = &uC;
    double rC = fieldHospital::routeDistanceScore(*locationC, *poi);
    double * prC = &rC;
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(pdC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(puC)));
    factorsC->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsC), (static_cast<void*>(prC)));
    fhC->setFactors(*factorsC);

    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhC);

    LinkedList* allFactors = fhA->fieldHospital::getFactorsFHList(myFieldHospitals);
    fieldHospital* thisFH =  new fieldHospital();
    std::vector<std::string> top3FHResult = thisFH->top3FieldHospitalsCalculator(myFieldHospitals, allFactors);

    //check that first field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool firstIsGood = top3FHResult.at(0) == fhA->getFHName();
    //check that second field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool secondIsGood = top3FHResult.at(1) == fhB->getFHName();
    //check that third field hospital in list returned by top3FieldHospitalsCalculator matches what i expect
    bool thirdIsGood = top3FHResult.at(2) == fhC->getFHName();
    bool isGood = (firstIsGood == true) & (secondIsGood == true) & (thirdIsGood == true);
    return isGood;
}

//Testing getdangerScore()
//tests dummy function returns 0.8 for the danger factor of a field hospital
bool fieldHospitalTest::testDangerDummy(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(5);
    locationFH->setY(0);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (0.7 <= fieldHospital::dangerScore() && 0.9 >= fieldHospital::dangerScore());
}

//Testing getunavailabilityScore()
//tests dummy function returns 0.8 for the unavailability factor of a field hospital
bool fieldHospitalTest::testUnavailabilityDummy(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(5);
    locationFH->setY(0);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (0.7 <= fieldHospital::unavailabilityScore() && 0.9 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has positive x value
bool fieldHospitalTest::testRouteDistancePosX(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(5);
    locationFH->setY(0);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (4.0 <= fieldHospital::unavailabilityScore() && 6.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has positive y value
bool fieldHospitalTest::testRouteDistancePosY(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(0);
    locationFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (4.0 <= fieldHospital::unavailabilityScore() && 6.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has positive xy values
bool fieldHospitalTest::testRouteDistancePosXY(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(5);
    locationFH->setY(5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (7.0 <= fieldHospital::unavailabilityScore() && 8.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has negative x value
bool fieldHospitalTest::testRouteDistanceNegX(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(-5);
    locationFH->setY(0);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));

    return (4.0 <= fieldHospital::unavailabilityScore() && 6.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has negative Y value
bool fieldHospitalTest::testRouteDistanceNegY(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(0);
    locationFH->setY(-5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));
    return (4.0 <= fieldHospital::unavailabilityScore() && 6.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests field hospital has negative XY value
bool fieldHospitalTest::testRouteDistanceNegXY(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(-5);
    locationFH->setY(-5);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));
    return (7.0 <= fieldHospital::unavailabilityScore() && 8.0 >= fieldHospital::unavailabilityScore());
}

//Testing getrouteDistanceScore()
//tests poi and field hospital in same location
bool fieldHospitalTest::testRouteDistanceSameSpot(){
    pinpoint* locationFH = new pinpoint();
    locationFH->setX(0);
    locationFH->setY(0);
    pinpoint* poi = new pinpoint();
    poi->setX(0);
    poi->setY(0);
    LinkedList* factorsFH = new LinkedList();
    fieldHospital* fH = new fieldHospital();
    double dFH = fieldHospital::dangerScore();
    double * pdFH = &dFH;
    double uFH = fieldHospital::unavailabilityScore();
    double * puFH = &uFH;
    double rFH = fieldHospital::routeDistanceScore(*locationFH, *poi);
    double * prFH = &rFH;
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(pdFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(puFH)));
    factorsFH->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(factorsFH), (static_cast<void*>(prFH)));
    return (-1.0 <= fieldHospital::unavailabilityScore() && 1.0 >= fieldHospital::unavailabilityScore());
}


