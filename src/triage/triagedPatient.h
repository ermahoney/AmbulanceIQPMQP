/** Function prototypes for calculating retrievable welfare
 *
 * @author Alex Miera
 */

#ifndef TRIAGED_PATIENT_H
#define TRIAGED_PATIENT_H

#include <stdio.h>
#include "linkedlist.h"
#include <vector>
#include <iostream>

class TriagedPatient {
    public:
        double* extractionTime;
        double* burnPercent;
        double* respirationRate;
        double* tidalVolume;
        double* pulse;
        double* systolicPressure;
        double* diastolicPressure;
        double* temperature;
        double* bloodOxygen;

        LinkedList::LLIST* factors;

        TriagedPatient() {
            printf("2\n");
            *extractionTime = getExtractionTime();
            /* issue is that extraction time is not given a place in memory */
            printf("3\n");
            *burnPercent = getBurnPercent();
            *respirationRate = getRespirationRate();
            *tidalVolume = getTidalVolume();
            *pulse = getPulse();
            *systolicPressure = getSystolicPressure();
            *diastolicPressure = getDiastolicPressure();
            *temperature = getTemperature();
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
};

double calculateRetrievableWelfare(std::vector<double> weights, 
                                   LinkedList* llist,
                                   struct TriagedPatient *triagedPatient);

#endif
