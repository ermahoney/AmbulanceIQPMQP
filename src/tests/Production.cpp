/*
 * production.cpp
 *
 *  Created on: Aug 20, 2021
 *      Author: emilymahoney
 */
#include "../../src/tests/Production.h"

#include <string>
#include <iostream>

#include "../../src/hospitals/fieldHospital.h"

bool Production :: prod(int argc, char argv[]) {
    //WEIGHTED SUM
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
    double myFHWeightedDesirablity = fieldHospital::weightedSumCalculator(*myWeights, *factors, myFH);
    std::cout << "The route score for the given weight values is: " << myFHWeightedDesirablity << std::endl;

    //TOP 3 FIELD HOSPITALS
    //making 4 samples of field hospitals
    //Field Hospital A
    LinkedList* myFieldHospitals = new LinkedList();
    pinpoint* locationA = new pinpoint();
    LinkedList* factorsA = new LinkedList();
    fieldHospital* fhA = new fieldHospital();
    fhA->setFHName("The A FH");
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


    //Field Hospital B
    LinkedList* factorsB = new LinkedList();
    pinpoint* locationB = new pinpoint();
    fieldHospital* fhB = new fieldHospital();
    fhB->setFHName("The B FH");
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


    //Field Hospital C
    LinkedList* factorsC = new LinkedList();
    pinpoint* locationC = new pinpoint();
    fieldHospital* fhC = new fieldHospital();
    fhC->setFHName("The C FH");
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


    //adding the 3 sample field hospitals to a list
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhA);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhB);
    myFieldHospitals->LinkedList::addtail(reinterpret_cast<LinkedList::LLIST *>(myFieldHospitals), fhC);


    //testing out the method that ranks my list of field hospitals according to the given poi
    LinkedList* factorslist = fhA->getFactorsFHList(myFieldHospitals);

    fhC->top3FieldHospitalsCalculator(myFieldHospitals, factorslist);

    return true;


}
