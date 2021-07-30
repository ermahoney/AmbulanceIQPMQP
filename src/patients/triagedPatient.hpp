/** Function prototypes for calculating retrievable welfare
 *
 * @author Alex Miera
 */

#ifndef TRIAGED_PATIENT_H
#define TRIAGED_PATIENT_H

#include <stdio.h>
#include <vector>
#include <iostream>
#include "../common/linkedlist.hpp"

class TriagedPatient {
    public:
        double *extractionTime;
        double *burnPercent;
        double *respirationRate;
        double *tidalVolume;
        double *pulse;
        double *systolicPressure;
        double *diastolicPressure;
        double *temperature;
        double *bloodOxygen;

        LinkedList::LLIST* factors;

        TriagedPatient() {
            printf("2\n");

            extractionTime = (double*) malloc(sizeof(double));
            *extractionTime= getExtractionTime();

            printf("3\n");

            burnPercent = (double*) malloc(sizeof(double));
            *burnPercent = getBurnPercent();

            respirationRate = (double*) malloc(sizeof(double));
            *respirationRate = getRespirationRate();

            tidalVolume = (double*) malloc(sizeof(double));
            *tidalVolume = getTidalVolume();

            pulse = (double*) malloc(sizeof(double));
            *pulse = getPulse();

            systolicPressure = (double*) malloc(sizeof(double));
            *systolicPressure = getSystolicPressure();

            diastolicPressure = (double*) malloc(sizeof(double));
            *diastolicPressure = getDiastolicPressure();

            temperature = (double*) malloc(sizeof(double));
            *temperature = getTemperature();

            bloodOxygen = (double*) malloc(sizeof(double));
            *bloodOxygen = getBloodOxygen();
        }

        double getExtractionTime();
        double getBurnPercent();
        double getRespirationRate();
        double getTidalVolume();
        double getPulse();
        double getSystolicPressure();
        double getDiastolicPressure();
        double getTemperature();
        double getBloodOxygen();

        int createFactors(LinkedList* llist, TriagedPatient* ppatient);
        int deleteTriagedPatient(LinkedList* llist, TriagedPatient* ppatient);
};

double calculateRetrievableWelfare(std::vector<double> weights, 
                                   LinkedList* llist,
                                   struct TriagedPatient *ppatient);

#endif
